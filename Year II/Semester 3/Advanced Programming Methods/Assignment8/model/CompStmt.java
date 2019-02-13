package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import Exception.*;
public class CompStmt implements IStmt {
    private IStmt first, second;

    public CompStmt(IStmt first, IStmt second){
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString(){
        return first.toString() + "; " + second.toString();
    }

    @Override
    public PrgState execute(PrgState state)throws IOException, FileAlreadyExistsException, FileNotFoundException, VariableNotDefined, DivisionByZero, InvalidOperator {
        MyIStack<IStmt> stack = state.getExeStack();
        stack.push(second);
        stack.push(first);
        return null;
    }
}
