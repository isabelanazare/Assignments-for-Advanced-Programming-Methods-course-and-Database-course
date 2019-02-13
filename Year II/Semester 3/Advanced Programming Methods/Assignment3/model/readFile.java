package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class readFile implements IStmt {
    private Exp exp;
    private String var;

    public readFile(Exp exp, String var) {
        this.exp = exp;
        this.var = var;
    }

    @Override
    public PrgState execute(PrgState state) throws IOException, FileAlreadyExistsException, FileNotFoundException {
        MyIDictionary <String,Integer> symTable=state.getSymTable();
        MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable;

        int fd = this.exp.eval(state.getSymTable());
        Tuple<String, BufferedReader> br = state.getFileTable().get(fd);
        if (br == null)
            throw new FileNotFoundException("FileNotFoundException at: " + this.toString() + "\nNo such file descriptor: " + String.valueOf(fd));
        String line = br.getSecond().readLine();
        int val = 0;
        if(line != null)
            val = Integer.parseInt(line);
        state.getSymTable().put(this.var, val);
        return state;
    }

    @Override
    public String toString() {
        return "readFile(" + this.exp.toString() + ", " + this.var + ")";
    }
}