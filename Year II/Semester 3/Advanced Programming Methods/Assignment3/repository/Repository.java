package repository;
import model.PrgState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private List<PrgState> prgList;
    private boolean firstTime;
    private int current=0;
    private PrintWriter printWriter;
    private String logFile;

    public Repository(PrgState state, String logFile) {
        this.prgList = new ArrayList<>();
        this.prgList.add(state);
        this.firstTime = true;
        this.printWriter = null;
        this.logFile = logFile;


    }
    @Override
    public List<PrgState> getPrgList() {
        return this.prgList;
    }
    @Override
    public PrgState getCurrentPrgs() {
        return this.prgList.get(current);
    }

    @Override
    public String toString(){
        StringBuilder bld=new StringBuilder();
        for(PrgState state: prgList){
            bld.append(state).append("\n");
        }
        return bld.toString();
    }

    @Override
    public void logPrgStateExec(PrgState state) throws IOException{
        if(firstTime == true) {
        //clearing the content
            try {
                PrintWriter writer = new PrintWriter(new File(logFile));
                writer.print("");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            firstTime = false;
        }

        this.printWriter = new PrintWriter(new FileWriter(logFile, true));

        this.printWriter.println("ExeStack:");
        this.printWriter.println(state.getExeStack().toString());
        this.printWriter.println("SymTable:");
        this.printWriter.println(state.getSymTable().toString());
        this.printWriter.println("Out:");
        this.printWriter.println(state.getOut().toString());
        this.printWriter.println("FileTable:");
        this.printWriter.println(state.getFileTable().toString());

        this.printWriter.close();
    }
}