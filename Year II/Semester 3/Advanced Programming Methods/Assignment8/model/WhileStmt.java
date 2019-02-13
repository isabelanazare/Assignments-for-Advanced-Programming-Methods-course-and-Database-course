package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import Exception.*;

public class WhileStmt implements IStmt {
    Exp exp;
    IStmt statement;

    public WhileStmt(Exp exp, IStmt statement) {
        this.exp = exp;
        this.statement = statement;
    }


    @Override
    public PrgState execute(PrgState state) throws IOException, FileAlreadyExistsException, FileNotFoundException, VariableNotDefined, DivisionByZero, InvalidOperator {

        MyIStack<IStmt> stack = state.getExeStack();
        MyIHeap<Integer> heap = state.getHeap();
        MyIDictionary<String, Integer> dict = state.getSymTable();

        int val = exp.eval(dict, heap);

        if(val != 0) {
            stack.push(new WhileStmt(exp, statement));
            stack.push(statement);
        }

        //return state;
        return null;
    }

    @Override
    public String toString(){
        return "While("+exp+"){"+statement+"}";
    }
}