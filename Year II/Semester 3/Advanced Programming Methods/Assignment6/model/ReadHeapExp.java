package model;

import Exception.DivisionByZero;
import Exception.EmptyStack;
import Exception.InvalidOperator;
import Exception.VariableNotDefined;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.io.IOException;

public class ReadHeapExp extends Exp  {
    String id;
    public ReadHeapExp(String id) {
        this.id = id;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, MyIHeap<Integer> heap) throws VariableNotDefined, DivisionByZero, InvalidOperator, NullPointerException {
        Integer var_val = symTable.get(this.id);
        if(var_val == null)
            throw new VariableNotDefined("VariableNotDefined exception\nError at ReadHeapExp: " + toString());
        Integer heap_val = heap.readAddr(var_val);
        if(heap_val == null)
            throw new NullPointerException("There is no such memory address\nError at ReadHeapExp: " + toString());
        return heap_val;
    }

    @Override
    public String toString() {
        return "readHeapExp(" + id + ")";
    }
}