package model;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class openRFile implements IStmt {
    private static int fd = 1;
    private String id, fileName;
    public openRFile(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }
    @Override
    public PrgState execute(PrgState state) throws FileNotFoundException, FileAlreadyExistsException
    {
        for(Tuple<String, BufferedReader> act : state.getFileTable().values())
            if(act.getFirst() == this.fileName)
                throw new FileAlreadyExistsException("FileAlreadyOpenedException at: " + this.toString() + "\nThe file " + this.fileName + " is already open");
        File f = new File(this.fileName);
        if(!f.exists())
            throw new FileNotFoundException("FileNotFoundException at: " + this.toString() + "\n" + "The file " + this.fileName + " does not exist");
        int actFd = ++ openRFile.fd;
        state.getFileTable().put(actFd, new Tuple<String, BufferedReader> (this.fileName, new BufferedReader(new FileReader(this.fileName))));
        state.getSymTable().put(this.id, actFd);
        return null;
    }

    @Override
    public String toString() {
        return "openRFile(" + this.id + ", " + this.fileName + ")";
    }
}
