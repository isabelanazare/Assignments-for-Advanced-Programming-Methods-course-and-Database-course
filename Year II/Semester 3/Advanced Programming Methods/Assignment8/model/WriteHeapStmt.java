package model;
import Exception.DivisionByZero;
import Exception.EmptyStack;
import Exception.InvalidOperator;
import Exception.VariableNotDefined;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.io.IOException;

public class WriteHeapStmt implements IStmt {
    String id;
    Exp exp;
    public WriteHeapStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }
    @Override
    public PrgState execute(PrgState state) throws IOException, FileAlreadyExistsException, FileNotFoundException, VariableNotDefined, DivisionByZero, InvalidOperator {
        Integer var_val = state.getSymTable().get(id);
        if(var_val == null)
            throw new VariableNotDefined("VariableNotDefined \nError at: " + toString());
        int val = this.exp.eval(state.getSymTable(), state.getHeap());
        state.getHeap().writeAddr(var_val, val);
        return null;
    }

    @Override
    public String toString() {
        return "writeHeap(" + this.id + ", " + this.exp.toString() + ")";
    }
}