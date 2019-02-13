package repository;

import model.MyIHeap;
import model.PrgState;
import java.io.IOException;
import java.util.List;

public interface IRepository {

    List<PrgState> getPrgList();
    //PrgState getCurrentPrgs();

    void setPrgList(List<PrgState> prgList);
    public MyIHeap<Integer> getHeap();
    void logPrgStateExec(PrgState state)  throws IOException;

}