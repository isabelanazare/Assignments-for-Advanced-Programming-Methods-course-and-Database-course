package controller;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import model.PrgState;
import repository.IRepository;
import model.IStmt;
import model.MyIStack;
import java.io.IOException;
import Exception.*;

import java.util.stream.Collectors;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo) {
        this.repo=repo;
    }

    public PrgState oneStep(PrgState state)  throws IOException,FileAlreadyExistsException, FileNotFoundException{
        MyIStack<IStmt> stk=state.getExeStack();
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }
    public void allSteps() throws IOException,FileAlreadyExistsException, FileNotFoundException{
        PrgState prg = repo.getCurrentPrgs();
        if(repo.getCurrentPrgs().getExeStack().isEmpty())
            throw new EmptyStack("Empty stack");
        while(!prg.getExeStack().isEmpty()){
            oneStep(prg);
            try {
                prg.getHeap().setMap(conservativeGarbageCollector(
                    prg.getSymTable().values(),
                    prg.getHeap().toMap()));
                repo.logPrgStateExec(prg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("_____________");
            System.out.println(prg);
        }

    }
    Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
        return heap.entrySet()
                .stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


}