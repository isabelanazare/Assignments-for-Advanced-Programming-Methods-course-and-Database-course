package model;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import Exception.*;
public class openRFile implements IStmt {
    private static int fd = 1;
    private String id, fileName;
    public openRFile(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }
    @Override
    public PrgState execute(PrgState state) throws IOException, FileAlreadyExistsException, FileNotFoundException, VariableNotDefined, DivisionByZero, InvalidOperator
    {
        for(Tuple<String, BufferedReader> act : state.getFileTable().values())
            if(act.getFirst() == this.fileName)
                throw new FileAlreadyExistsException("FileAlreadyExistsException at: " + this.toString() + "\nThe file " + this.fileName + " is already open");
        File f = new File(this.fileName);
        if(!f.exists())
            throw new FileNotFoundException("FileNotFoundException at: " + this.toString() + "\n" + "The file " + this.fileName + " does not exist");
        int actFd = ++ openRFile.fd; /// static variable
        state.getFileTable().put(actFd, new Tuple<String, BufferedReader> (this.fileName, new BufferedReader(new FileReader(this.fileName))));
        state.getSymTable().put(this.id, actFd);
        return null;
    }

    @Override
    public String toString() {
        return "openRFile(" + this.id + ", " + this.fileName + ")";
    }
}
