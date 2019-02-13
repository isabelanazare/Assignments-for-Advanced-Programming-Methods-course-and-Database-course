package model;

import Exception.DivisionByZero;
import Exception.EmptyStack;
import Exception.InvalidOperator;
import Exception.VariableNotDefined;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.io.IOException;

import java.io.IOException;

public class NewStmt implements IStmt {
    private String var;
    private Exp exp;
    public NewStmt(String var, Exp exp) {
        this.var = var;
        this.exp = exp;
    }
    @Override
    public PrgState execute(PrgState state) throws IOException, FileAlreadyExistsException, FileNotFoundException, VariableNotDefined, DivisionByZero, InvalidOperator {
        int res = this.exp.eval(state.getSymTable(), state.getHeap());
        int loc = state.getHeap().allocate(res);
        state.getSymTable().put(var, loc);
        return null;
    }

    @Override
    public String toString() {
        return "newStmt(" + this.var + ", " + this.exp.toString() + ")";
    }
}