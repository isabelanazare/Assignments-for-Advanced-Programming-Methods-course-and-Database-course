package view;
import model.*;
import java.util.*;
import repository.*;
import controller.Controller;

public class Main {
    /*
    public static IRepository getNewRepository(IStmt prg) {

        MyIStack<IStmt> exeStack = new MyStack<>(new Stack<IStmt>());
        MyIDictionary<String, Integer> symTable = new MyDictionary<>(new HashMap<String, Integer>());
        MyIList<Integer> out = new MyList<>(new ArrayList<Integer>());

        PrgState prgState = new PrgState(exeStack, symTable, out);
        IRepository repo = new Repository(prgState);
        return repo;
    }*/

    public static void main(String[] args) {
        while (true) {
            System.out.println("0: EXIT");
            System.out.println("1: v = 2;Print(v)");
            System.out.println("2: a = 2 + 3 * 5;b = a + 1;Print(b)");
            System.out.println("3: a = 2 - 2; If a Then v = 2 Else v = 3;Print(v)");
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();
            if (option == 0)
                break;
            switch (option) {
                case 1: {
                    try {

                        MyIStack<IStmt> exeStack = new MyStack<>(new Stack<IStmt>());
                        MyIDictionary<String, Integer> symTable = new MyDictionary<>(new HashMap<String,Integer>());
                        MyIList<Integer> out = new MyList<>(new ArrayList<Integer>());
                        IStmt ex1 = new CompStmt(new AssignStmt("v", new ConstExp(2)), new PrintStmt(new
                                VarExp("v")));
                        exeStack.push(ex1);
                        PrgState prg = new PrgState(exeStack, symTable, out);
                        IRepository repo = new Repository(prg);

                        Controller ctr1 = new Controller(repo);
                        ctr1.allSteps();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 2: {
                    try {
                        MyIStack<IStmt> exeStack = new MyStack<>(new Stack<IStmt>());
                        MyIDictionary<String, Integer> symTable = new MyDictionary<>(new HashMap<String,Integer>());
                        MyIList<Integer> out = new MyList<>(new ArrayList<Integer>());

                        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp('+', new ConstExp(2), new
                                ArithExp('*', new ConstExp(3), new ConstExp(5)))),
                                new CompStmt(new AssignStmt("b", new ArithExp('+', new VarExp("a"), new
                                        ConstExp(1))), new PrintStmt(new VarExp("b"))));
                        exeStack.push(ex2);
                        PrgState prg = new PrgState(exeStack, symTable, out);
                        IRepository repo = new Repository(prg);

                        Controller ctr1 = new Controller(repo);
                        ctr1.allSteps();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 3: {
                    try {
                        MyIStack<IStmt> exeStack = new MyStack<>(new Stack<IStmt>());
                        MyIDictionary<String, Integer> symTable = new MyDictionary<>(new HashMap<String,Integer>());
                        MyIList<Integer> out = new MyList<>(new ArrayList<Integer>());

                        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExp('-', new ConstExp(2), new
                                ConstExp(2))),
                                new CompStmt(new IfStmt(new VarExp("a"), new AssignStmt("v", new ConstExp(2)), new
                                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
                        exeStack.push(ex3);
                        PrgState prg = new PrgState(exeStack, symTable, out);
                        IRepository repo = new Repository(prg);

                        Controller ctr1 = new Controller(repo);
                        ctr1.allSteps();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }
}