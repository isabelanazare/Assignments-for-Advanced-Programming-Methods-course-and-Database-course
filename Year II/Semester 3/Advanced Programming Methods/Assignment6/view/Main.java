package view;
import model.*;
import java.util.*;
import repository.*;
import controller.Controller;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args){

 /*
            v=10;new(a,22);
            fork(wH(a,30);v=32;print(v);print(rH(a)));
            print(v);print(rH(a)) */
        IStmt ex8 = new CompStmt(
                new CompStmt(
                    new AssignStmt("v", new ConstExp(10)),
                    new NewStmt("a", new ConstExp(22))
                ),
                new CompStmt(
                        new ForkStmt(
                                new CompStmt(
                                    new WriteHeapStmt("a", new ConstExp(30)),
                                        new CompStmt(
                                                new AssignStmt("v", new ConstExp(32)),
                                                new CompStmt(
                                                        new PrintStmt(new VarExp("v")),
                                                        new PrintStmt(new ReadHeapExp("a"))
                                                )
                                        )
                                )
                        ),
                        new CompStmt(
                                new PrintStmt(new VarExp("v")),
                                new PrintStmt(new ReadHeapExp("a"))
                        )
                )
        );

        MyIStack<IStmt> exeStack = new MyStack<>(new Stack<IStmt>());
        MyIDictionary<String, Integer> symTable= new MyDictionary<>(new HashMap<String,Integer>());
        MyIList<Integer> out = new MyList<>(new ArrayList<Integer>());
        MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable = new MyDictionary<>(new HashMap<Integer, Tuple<String, BufferedReader>>());
        MyIHeap<Integer> heap = new MyHeap<Integer>(new HashMap<Integer, Integer>());
        exeStack.push(ex8);
        int id=1;
        PrgState prg= new PrgState(id,exeStack, symTable, out,fileTable,heap);
        IRepository repo = new Repository(prg, "D:\\Year II\\Metode avansate de programare\\A6\\file1.txt");
        Controller ctrl= new Controller(repo);

        TextMenu menu = new TextMenu();

        menu.addCommand(new RunExample("8",ex8.toString(),ctrl));

        menu.show();
    }
}