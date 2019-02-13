package model;
import controller.Controller;

public class RunExample extends Command {
    Controller ctrl;
    public RunExample(String key, String desc, Controller ctrl) {
        super(key, desc);
        this.ctrl = ctrl;
    }
    @Override
    public void execute() {
        /*
        MyIDictionary<String,Integer> symTable=ctrl.getRepo().getCurrentPrgs().getSymTable();
        MyIHeap<Integer> heap=ctrl.getRepo().getCurrentPrgs().getHeap();
        if(this.getKey()=="8"){
            return;
        }*/
        try {
            this.ctrl.allSteps();
        }  catch (Exception e) {
            System.out.println(e);
            return ;
        }
    }
}