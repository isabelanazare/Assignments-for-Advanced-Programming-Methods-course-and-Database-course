package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import Exception.*;
public class readFile implements IStmt {
    private Exp exp;
    private String var;

    public readFile(Exp exp, String var) {
        this.exp = exp;
        this.var = var;
    }

    @Override
    public PrgState execute(PrgState state) throws IOException, FileAlreadyExistsException, FileNotFoundException, VariableNotDefined, DivisionByZero, InvalidOperator {
        int fd = this.exp.eval(state.getSymTable(),state.getHeap());
        Tuple<String, BufferedReader> br = state.getFileTable().get(fd);
        if (br == null)
            throw new FileNotFoundException("FileNotFoundException at: " + this.toString() + "\nNo such file descriptor: " + String.valueOf(fd));
        String line = br.getSecond().readLine();
        int val = 0;
        if(line != null)
            val = Integer.valueOf(line);
        state.getSymTable().put(this.var, val);
        return null;
    }

    @Override
    public String toString() {
        return "readFile(" + this.exp.toString() + ", " + this.var + ")";
    }
}