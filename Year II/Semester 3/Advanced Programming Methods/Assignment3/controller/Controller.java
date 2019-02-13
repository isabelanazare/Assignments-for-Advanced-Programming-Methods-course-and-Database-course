package controller;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

import model.PrgState;
import repository.IRepository;
import model.IStmt;
import model.MyIStack;
import java.io.IOException;
import Exception.*;
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
                repo.logPrgStateExec(prg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("_____________");
            System.out.println(prg);
        }

    }
}