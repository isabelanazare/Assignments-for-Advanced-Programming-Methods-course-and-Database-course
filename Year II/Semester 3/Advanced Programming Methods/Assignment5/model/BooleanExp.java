package model;
import Exception.*;

public class BooleanExp extends Exp {

    private Exp e1, e2;
    private String op;

    public BooleanExp(String op, Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op=op;
    }
    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap) throws VariableNotDefined, DivisionByZero, InvalidOperator {

        int rez1 = this.e1.eval(symTable, heap);
        int rez2 = this.e2.eval(symTable, heap);
        switch (op) {
            case "<=": {
                if (rez1 > rez2)
                    return 0;
                return 1;
            }
            case "==": {
                if (rez1 == rez2)
                    return 1;
                return 0;
            }
            case ">=": {
                if (rez1 < rez2)
                    return 0;
                return 1;
            }
            case ">": {
                if (rez1 > rez2)
                    return 1;
                return 0;
            }
            case "<": {
                if (rez1 < rez2)
                    return 1;
                return 0;
            }
            case "!=": {
                if (rez1 == rez2)
                    return 0;
                return 1;
            }
        }
            throw new InvalidOperator("Invalid operator");
        }
    @Override
    public String toString() {
        return "" + e1.toString() + op + e2.toString();

    }
}
