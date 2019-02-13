package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import Exception.DivisionByZero;

import Exception.InvalidOperator;
import Exception.VariableNotDefined;

abstract class Exp {
    abstract int eval(MyIDictionary<String,Integer> symTable,MyIHeap<Integer> heap) throws IOException, FileAlreadyExistsException, FileNotFoundException, VariableNotDefined, DivisionByZero, InvalidOperator;
}
