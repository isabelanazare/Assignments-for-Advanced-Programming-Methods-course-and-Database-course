package model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PrgState {
    private int id;
    private MyIStack <IStmt> exeStack;
    private MyIDictionary <String, Integer> symTable;
    private MyIList<Integer> out;
    private IStmt originalProgram;

    public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<String, Integer> symTable, MyIList<Integer> out) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        //this.originalProgram = prg;
        //this.exeStack.push(prg);
    }
    public boolean isNotCompleted() {
        return this.exeStack.isEmpty() == false;
    }
    public PrgState oneStep() {
        IStmt cur = this.getExeStack().pop();
        return cur.execute(this);
    }
    public MyIStack<IStmt> getExeStack() {
        return this.exeStack;
    }
    public MyIDictionary<String, Integer> getSymTable() {
        return this.symTable;
    }
    public MyIList<Integer> getOut() {
        return this.out;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nExeStack\n");
        for (IStmt s : exeStack.getStack()) {
            builder.append(s).append("\n");
        }
        builder.append("\nSymTable\n");
        for (String key : symTable.keys()) {
            builder.append(key).append(" : ").append(symTable.get(key)).append("\n");
        }
        builder.append("\nOut\n");
        for (Integer i : out.toList()) {
            builder.append(i).append("\n");
        }
        return builder.toString();
    }
}