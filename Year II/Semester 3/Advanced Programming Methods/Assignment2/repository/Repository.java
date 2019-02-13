package repository;

import model.IStmt;
import model.PrgState;
import repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private List<PrgState> prgList;
    private boolean firstTime;
    private int current=0;

    public Repository(PrgState state) {
        this.prgList = new ArrayList<>();
        this.prgList.add(state);
        this.firstTime = true;
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
    public void setPrgList(List<PrgState> prgList) {
        this.prgList = prgList;
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
    public void addPrg(PrgState prg) {
        prgList.add(prg);
    }
}