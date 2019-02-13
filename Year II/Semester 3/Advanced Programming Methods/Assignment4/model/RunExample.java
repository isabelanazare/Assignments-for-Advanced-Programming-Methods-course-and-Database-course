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
        try {
            this.ctrl.allSteps();
        }  catch (Exception e) {
            System.out.println(e);
            return ;
        }
    }
}