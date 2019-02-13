package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AssignStmt implements IStmt {
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return this.id + " = " + exp.toString();
    }

    @Override
    public PrgState execute(PrgState state)throws IOException, FileAlreadyExistsException, FileNotFoundException {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIHeap<Integer> heap=state.getHeap();

        symTable.put(this.id, this.exp.eval(symTable,heap));
        return null;
    }
}