package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import Exception.*;
public class Lower extends Exp {

    Exp st,dr;

    public Lower(Exp st, Exp dr) {
        this.st = st;
        this.dr = dr;
    }


    @Override
    public int eval(MyIDictionary<String, Integer> d, MyIHeap<Integer> heap) throws  VariableNotDefined, DivisionByZero, InvalidOperator {
        if(st.eval(d,heap) < dr.eval(d,heap))
            return 1;
        return 0;
    }

    @Override
    public String toString(){
        return "Lower("+st+"<"+dr+") ";
    }

}