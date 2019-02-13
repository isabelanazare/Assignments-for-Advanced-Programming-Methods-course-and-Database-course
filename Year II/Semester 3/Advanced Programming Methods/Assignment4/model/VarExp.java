package model;

public class VarExp extends Exp {

    private String id;

    public VarExp(String id) {
        this.id = id;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable,MyIHeap<Integer> heap) {

        return symTable.get(id);
    }

    @Override
    public String toString() {
        return id;
    }
}