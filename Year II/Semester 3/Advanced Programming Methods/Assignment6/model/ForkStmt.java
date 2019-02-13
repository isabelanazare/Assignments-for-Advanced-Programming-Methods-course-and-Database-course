package model;

import Exception.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ForkStmt implements IStmt {

    IStmt statement;

    public ForkStmt(IStmt statement) {
        this.statement = statement;
    }


    @Override
    public PrgState execute(PrgState state) {


        MyIStack<IStmt> exeStack2 = new MyStack<>(new Stack<IStmt>());
        MyIDictionary<String, Integer> symTable2= state.getSymTable().clone();
        MyIList<Integer> out2 = state.getOut();
        MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable2 = state.getFileTable();
        MyIHeap<Integer> heap2 = state.getHeap();

        exeStack2.push(statement);
        Integer ID = state.getId()*10;
        return new PrgState(ID,exeStack2,symTable2,out2,fileTable2,heap2);

    }

    @Override
    public String toString(){
        return "fork("+statement+")";
    }
}