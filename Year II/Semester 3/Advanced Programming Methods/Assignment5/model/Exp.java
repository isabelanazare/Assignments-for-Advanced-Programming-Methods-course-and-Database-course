package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import Exception.DivisionByZero;

import Exception.InvalidOperator;
import Exception.VariableNotDefined;

abstract public class Exp {
    abstract public int eval(MyIDictionary<String,Integer> symTable,MyIHeap<Integer> heap) throws VariableNotDefined, DivisionByZero, InvalidOperator;
}
