package repository;

import model.PrgState;
import java.util.List;

public interface IRepository {

    List<PrgState> getPrgList();
    PrgState getCurrentPrgs();

    void setPrgList(List<PrgState> prgList);
    void addPrg(PrgState prg);
}