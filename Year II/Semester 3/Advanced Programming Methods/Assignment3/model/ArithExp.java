package model;
import Exception.*;

public class ArithExp extends Exp {

    private Exp e1, e2;
    private String op;

    public ArithExp(String op, Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op=op;
    }
    @Override
    public int eval(MyIDictionary<String, Integer> symTable) {

        int rez1 = this.e1.eval(symTable);
        int rez2 = this.e2.eval(symTable);
        switch (op){
            case "+":
                return rez1 + rez2;
            case "-":
                return rez1 - rez2;
            case "*":
                return rez1 * rez2;
            case "/":
                if(rez2 == 0)
                    throw new DivisionByZero("Division by 0 is not ok");
                return rez1/rez2;
        }
        throw new InvalidOperator("Invalid operator");
    }

    @Override
    public String toString() {
        return "" + e1.toString() + op + e2.toString();

    }
}
