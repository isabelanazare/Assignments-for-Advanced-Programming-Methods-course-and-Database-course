package controller;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import model.PrgState;
import repository.IRepository;
import Exception.FileException;

import java.io.IOException;
import Exception.*;
import java.util.stream.Collectors;
import java.util.Collection;

import java.util.concurrent.*;


public class Controller {
    private IRepository repo;
    private ExecutorService executor;

    public Controller(IRepository repo) {
        this.repo=repo;
    }
    public IRepository getRepo(){return this.repo;}

    public void oneStepForAllPrg(List<PrgState> prgList) {
        List<Callable<PrgState>> callList = prgList.stream()
                .map((PrgState p) -> (Callable<PrgState>)(() -> {return p.oneStep();}))
                .collect(Collectors.toList());


        List<PrgState> newList = null;
        try {
            newList = executor.invokeAll(callList)
                    .stream()
                    .map(  future ->
                    {
                        try {
                            return future.get();
                        } catch (InterruptedException e) {
                            throw new ControllerException(e.getMessage());
                        } catch (ExecutionException e) {
                            throw new ControllerException(e.getMessage());
                        }
                    })
                    .filter(p -> p != null)
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            throw new ControllerException(e.getMessage());
        }

        prgList.forEach(prg -> {
            try {
                repo.logPrgStateExec(prg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        prgList.addAll(newList);
        repo.setPrgList(prgList);
    }

    public List<PrgState> removeCompletedPrg(List<PrgState> prgStateList) {
        return prgStateList.stream()
                .filter(p -> p.isNotCompleted())
                .collect(Collectors.toList());
    }
    public void allSteps(){
        executor = Executors.newFixedThreadPool(100);

        List<PrgState> prgList = removeCompletedPrg(repo.getPrgList());

        prgList.forEach(prg -> {
            try {
                repo.logPrgStateExec(prg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        while(prgList.size() > 0){

            prgList.forEach(prg -> {
            try {
                prg.getHeap().setMap(conservativeGarbageCollector(
                        prg.getSymTable().values(),
                        prg.getHeap().toMap()));
                repo.logPrgStateExec(prg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

            oneStepForAllPrg(prgList);
            prgList = removeCompletedPrg(repo.getPrgList());

        }

        executor.shutdownNow();
        //closing files
        prgList.forEach(prg -> {
                    prg.getFileTable().values().stream().forEach(
                            e -> {
                                try {
                                    e.getSecond().close();
                                } catch (IOException ex) {
                                    throw new FileException(ex.toString());
                                }
                            });
                });
        repo.setPrgList(prgList);
    }
    Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
        return heap.entrySet()
                .stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


}