package repository;

import model.PrgState;
import java.io.IOException;
import java.util.List;

public interface IRepository {

    List<PrgState> getPrgList();
    PrgState getCurrentPrgs();

    void logPrgStateExec(PrgState state)  throws IOException;

}