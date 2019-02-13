using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ConsoleApp1.Model.ADT;
using ConsoleApp1.Model.Statements;
using ConsoleApp1.Controllerfile;
using ConsoleApp1.Repository;
using ConsoleApp1.Model;
using ConsoleApp1.Model.Expressions;
namespace ConsoleApp1.View
{
    class Ui
    {
        public void printMenu()
        {
            Console.WriteLine("Available commands:");
            Console.WriteLine("1: v = 2;Print(v)");
            Console.WriteLine("2: a = 2 + 3 * 5;b = a + 1;Print(b)");
            Console.WriteLine("3: a = 2 - 2; If a Then v = 2 Else v = 3;Print(v)");
            Console.WriteLine("4: openRFile(var_f,'test.in');readFile(var_f, var_c); print(var_c);(if var_c then readFile(var_f, var_c); print(var_c)else print(0)); closeRFile(var_f)");
        }
        public void executeOneStep(Statement s)
        {
            IExeStack<Statement> exeStack = new ExeStack<Statement>();
            ISymbolTable<string, int> symbolTable = new SymbolTable<string, int>();
            IOutput<int> messages = new Output<int>();
            IFileTable<int, FileData> fd = new FileTable<int, FileData>();
            PrgState state = new PrgState(symbolTable, exeStack, messages, fd);
            IPrgRepository repo = new PrgRepository(state);
            Controller ctrl = new Controller(repo);

            ctrl.executeOneStep();
        }
        public void executeAllSteps(Statement s)
        {
            IExeStack<Statement> exeStack = new ExeStack<Statement>();
            ISymbolTable<string, int> symbolTable = new SymbolTable<string, int>();
            IOutput<int> messages = new Output<int>();
            IFileTable<int, FileData> fd = new FileTable<int, FileData>();
            exeStack.Push(s);
            PrgState state = new PrgState(symbolTable, exeStack, messages, fd);
            IPrgRepository repo = new PrgRepository(state);
            Controller ctrl = new Controller(repo);
            ctrl.executeAllSteps();
        }
        public void run()
        {
            this.printMenu();
            while (true)
            {
                try
                {
                    Console.WriteLine("Enter a command:");
                    int num = Convert.ToInt32(Console.ReadLine());
                    if (num == 0)
                    {
                        break;
                    }
                    else if (num == 1)
                    {
                        
                            Statement s = new CompoundStatement(
                                    new AssignStatement("v",
                                            new ConstantExpression(2)),
                                    new PrintStatement(
                                            new VariableExpression("v")));
                        this.executeAllSteps(s);

                    }
                    else if (num == 2)
                    {
                        Statement s1 = new CompoundStatement(
                               new AssignStatement("a",
                                       new ArithmeticExpression('+',
                                               new ConstantExpression(2),
                                               new ArithmeticExpression('*',
                                                       new ConstantExpression(3),
                                                       new ConstantExpression(5)))),
                               new CompoundStatement(new AssignStatement("b",
                                       new ArithmeticExpression('+',
                                               new VariableExpression("a"),
                                               new ConstantExpression(1))),
                                       new PrintStatement(
                                               new VariableExpression("b"))));
                        this.executeAllSteps(s1);
                    }
                    else if (num == 3)
                    {
                        Statement s2 = new CompoundStatement(
                               new AssignStatement("a",
                                       new ArithmeticExpression('-',
                                               new ConstantExpression(2),
                                               new ConstantExpression(2))),
                               new CompoundStatement(
                                       new IfStatement(
                                               new VariableExpression("a"),
                                               new AssignStatement("v",
                                                       new ConstantExpression(3)),
                                               new AssignStatement("v",
                                                       new ConstantExpression(5))),
                                       new PrintStatement(
                                               new VariableExpression("v"))));
                        this.executeAllSteps(s2);
                    }
                    else if (num == 4)
                    {
                        Statement s4 = new CompoundStatement(
                           new CompoundStatement(
                                   new CompoundStatement(
                                           new OpenFileStatement("var_f", "D:\\Year II\\Metode avansate de programare\\ConsoleApp1\\ConsoleApp1\\test.in"),
                                           new ReadFileStatement(new VariableExpression("var_f"), "var_c")
                                   ),
                                   new CompoundStatement(
                                           new PrintStatement(new VariableExpression("var_c")),
                                           new IfStatement(
                                                   new VariableExpression("var_c"),
                                                   new PrintStatement(new ConstantExpression(0))
                                                  , new CompoundStatement(
                                                           new ReadFileStatement(new VariableExpression("var_f"), "var_c"),
                                                           new PrintStatement(new VariableExpression("var_c"))
                                                   )

                                           )
                                   )


                           ),
                           new CloseFileStatement(new VariableExpression("var_f"))
                   );
                        this.executeAllSteps(s4);
                    }
                    else if (num == 5)
                    {
                        Statement s5 = new CompoundStatement(
                           new CompoundStatement(
                                   new CompoundStatement(
                                           new OpenFileStatement("var_f", "D:\\Year II\\Metode avansate de programare\\ConsoleApp1\\ConsoleApp1\\test.in"),
                                           new ReadFileStatement(new ArithmeticExpression('+', new VariableExpression("var_f"), new ConstantExpression(2)), "var_c")
                                   ),
                                   new CompoundStatement(
                                           new PrintStatement(new VariableExpression("var_c")),
                                           new IfStatement(
                                                   new VariableExpression("var_c"),
                                                   new PrintStatement(new ConstantExpression(0)),
                                                   new CompoundStatement(
                                                           new ReadFileStatement(new VariableExpression("var_f"), "var_c"),
                                                           new PrintStatement(new VariableExpression("var_c"))
                                                   )

                                           )
                                   )


                           ),
                           new CloseFileStatement(new VariableExpression("var_f"))
                   );
                        this.executeAllSteps(s5);
                    }

                }
                catch (DivideByZeroException e)
                {
                    Console.WriteLine(e.ToString());
                }
                catch (SystemException e)
                {
                    Console.WriteLine(e.ToString());
                }

            }

        }
    }
}

