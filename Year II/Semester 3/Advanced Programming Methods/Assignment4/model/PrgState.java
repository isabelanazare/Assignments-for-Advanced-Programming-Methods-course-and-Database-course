package model;
import java.io.BufferedReader;

public class PrgState {
    private MyIStack <IStmt> exeStack;
    private MyIDictionary <String, Integer> symTable;
    private MyIList<Integer> out;
    private MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable;
    private MyIHeap<Integer> heap;

    public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<String, Integer> symTable, MyIList<Integer> out, MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable, MyIHeap<Integer> heap) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.fileTable = fileTable;
        this.heap=heap;
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
    public MyIDictionary<Integer, Tuple<String, BufferedReader>> getFileTable() {
        return this.fileTable;
    }
    public MyIHeap<Integer> getHeap() {
        return this.heap;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nExeStack\n");
        for (IStmt s : exeStack.getStack()) {
            builder.append(s).append("\r\n");
        }
        builder.append("\nSymTable\n");
        for (String key : symTable.keys()) {
            builder.append(key).append(" --> ").append(symTable.get(key)).append("\r\n");
        }
        builder.append("\nOut\n");
        for (Integer i : out.toList()) {
            builder.append(i).append("\r\n");
        }
        builder.append("\nFiletable\n");
        builder.append(fileTable.toString());

        builder.append("\nHeap\n");
        builder.append(heap.toString());

        return builder.toString();
    }
}