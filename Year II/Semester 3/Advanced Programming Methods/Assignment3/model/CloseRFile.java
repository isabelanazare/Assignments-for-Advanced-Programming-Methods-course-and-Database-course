package model;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;

public class CloseRFile implements IStmt {
    private Exp exp;


    public CloseRFile(Exp exp) {
        this.exp = exp;
    }


    @Override
    public String toString() {
        return "CloseRFileStmt(" + this.exp.toString() + ")";
    }


    @Override
    public PrgState execute(PrgState state) throws IOException, FileAlreadyExistsException, FileNotFoundException {
        int fd = this.exp.eval(state.getSymTable());
        Tuple<String, BufferedReader> act = state.getFileTable().remove(fd);
        if (act == null)
            throw new FileNotFoundException("FileNotFoundException Exception at: " + this.toString() + "\nThere is no opened file with fd = " + fd);
        act.getSecond().close();
        return null;
    }
}