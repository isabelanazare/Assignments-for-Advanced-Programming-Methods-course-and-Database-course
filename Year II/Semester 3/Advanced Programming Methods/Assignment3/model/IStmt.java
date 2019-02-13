package model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public interface IStmt {
    String toString();
    PrgState execute(PrgState state) throws IOException,FileAlreadyExistsException, FileNotFoundException;
}
