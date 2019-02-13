package view;
import model.*;
import java.util.*;
import repository.*;
import controller.Controller;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args){
        IStmt ex1 = new CompStmt(new AssignStmt("v", new ConstExp(2)), new PrintStmt(new
                VarExp("v")));
        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp("+", new ConstExp(2), new
                ArithExp("*", new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b", new ArithExp("+", new VarExp("a"), new
                        ConstExp(1))), new PrintStmt(new VarExp("b"))));
        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp("-", new ConstExp(2), new
                ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"), new AssignStmt("v", new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));

        IStmt ex4 = new CompStmt(
                new openRFile("var_f", "file2.txt"),
                new CompStmt(
                        new readFile(new VarExp("var_f"), "var_c"),
                        new CompStmt(
                                new PrintStmt(new VarExp("var_c")),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("var_c"),
                                                new CompStmt(
                                                        new readFile(new VarExp("var_f"), "var_c"),
                                                        new PrintStmt(new VarExp("var_c"))
                                                ),
                                                new PrintStmt(new ConstExp(0))
                                        ),
                                        new CloseRFile(new VarExp("var_f"))
                                )
                        )
                ));
        IStmt ex5 = new CompStmt(
                new openRFile("var_f", "file3.txt"),
                new CompStmt(
                        new readFile(new ArithExp("+", new VarExp("var_f"), new ConstExp(2)), "var_c"),
                        new CompStmt(
                                new PrintStmt(new VarExp("var_c")),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("var_c"),
                                                new CompStmt(
                                                        new readFile(new VarExp("var_f"), "var_c"),
                                                        new PrintStmt(new VarExp("var_c"))
                                                ),
                                                new PrintStmt(new ConstExp(0))
                                        ),
                                        new CloseRFile(new VarExp("var_f"))
                                )
                        )
                )
        );


        MyIStack<IStmt> exeStack1= new MyStack<>(new Stack<IStmt>());
        MyIDictionary<String, Integer> symTable1= new MyDictionary<>(new HashMap<String,Integer>());
        MyIList<Integer> out1 = new MyList<>(new ArrayList<Integer>());
        MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable1 = new MyDictionary<>(new HashMap<Integer, Tuple<String, BufferedReader>>());
        exeStack1.push(ex1);
        PrgState prg1 = new PrgState(exeStack1,symTable1, out1,fileTable1);
        IRepository repo1 = new Repository(prg1, "D:\\Year II\\Metode avansate de programare\\A3.2\\file1.txt");
        Controller ctrl1 = new Controller(repo1);

        MyIStack<IStmt> exeStack2 = new MyStack<>(new Stack<IStmt>());
        MyIDictionary<String, Integer> symTable2= new MyDictionary<>(new HashMap<String,Integer>());
        MyIList<Integer> out2 = new MyList<>(new ArrayList<Integer>());
        MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable2 = new MyDictionary<>(new HashMap<Integer, Tuple<String, BufferedReader>>());
        exeStack2.push(ex2);
        PrgState prg2 = new PrgState(exeStack2, symTable2, out2,fileTable2);
        IRepository repo2 = new Repository(prg2, "D:\\Year II\\Metode avansate de programare\\A3.2\\file1.txt");
        Controller ctrl2 = new Controller(repo2);

        MyIStack<IStmt> exeStack3 = new MyStack<>(new Stack<IStmt>());
        MyIDictionary<String, Integer> symTable3= new MyDictionary<>(new HashMap<String,Integer>());
        MyIList<Integer> out3 = new MyList<>(new ArrayList<Integer>());
        MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable3 = new MyDictionary<>(new HashMap<Integer, Tuple<String, BufferedReader>>());
        exeStack3.push(ex3);
        PrgState prg3 = new PrgState(exeStack3, symTable3, out3,fileTable3);
        IRepository repo3 = new Repository(prg3, "D:\\Year II\\Metode avansate de programare\\A3.2\\file1.txt");
        Controller ctrl3 = new Controller(repo3);

        MyIStack<IStmt> exeStack4 = new MyStack<>(new Stack<IStmt>());
        MyIDictionary<String, Integer> symTable4= new MyDictionary<>(new HashMap<String,Integer>());
        MyIList<Integer> out4= new MyList<>(new ArrayList<Integer>());
        MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable4 = new MyDictionary<>(new HashMap<Integer, Tuple<String, BufferedReader>>());
        exeStack4.push(ex4);
        PrgState prg4 = new PrgState(exeStack4, symTable4, out4,fileTable4);
        IRepository repo4 = new Repository(prg4, "D:\\Year II\\Metode avansate de programare\\A3.2\\file1.txt");
        Controller ctrl4 = new Controller(repo4);

        MyIStack<IStmt> exeStack5 = new MyStack<>(new Stack<IStmt>());
        MyIDictionary<String, Integer> symTable5= new MyDictionary<>(new HashMap<String,Integer>());
        MyIList<Integer> out5 = new MyList<>(new ArrayList<Integer>());
        MyIDictionary<Integer, Tuple<String, BufferedReader>> fileTable5 = new MyDictionary<>(new HashMap<Integer, Tuple<String, BufferedReader>>());
        exeStack5.push(ex5);
        PrgState prg5 = new PrgState(exeStack5, symTable5, out5,fileTable5);
        IRepository repo5 = new Repository(prg5, "D:\\Year II\\Metode avansate de programare\\A3.2\\file1.txt");
        Controller ctrl5 = new Controller(repo5);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
        menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
        menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));

        menu.show();
    }
}