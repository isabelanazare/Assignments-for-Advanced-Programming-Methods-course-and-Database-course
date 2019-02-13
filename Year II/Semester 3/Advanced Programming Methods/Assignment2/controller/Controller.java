package controller;

import model.PrgState;
import repository.IRepository;
import model.IStmt;
import model.MyIStack;

import java.util.List;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo) {
        this.repo=repo;
    }
/*
    public PrgState oneStep(PrgState state){
        MyIStack<IStmt> stk=state.getExeStack();
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }*/
    public PrgState oneStep(PrgState state){
        MyIStack<IStmt> stk=state.getExeStack();
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }/*
    public void allSteps(){
        List<PrgState> prg = repo.getPrgList(); // repo is the controller field of type MyRepoInterface
        int i=0;
        while (!(prg.get(i).getExeStack().isEmpty())) {
            oneStep(prg.get(i));
            System.out.println(prg.get(i).toString());
            i++;
        }}*/
    public void allSteps() {
        PrgState prg = repo.getCurrentPrgs();
        while(!prg.getExeStack().isEmpty()){
            oneStep(prg);
            System.out.println("_____________");
            System.out.println(prg);
        }

    }
    public void setMain(PrgState state) {
        this.repo.getPrgList().clear();
        this.repo.getPrgList().add(state);
    }
}