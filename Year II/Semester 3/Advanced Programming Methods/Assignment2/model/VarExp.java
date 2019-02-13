package model;

public class VarExp extends Exp {

    private String id;

    public VarExp(String id) {
        this.id = id;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable) {

        return symTable.get(id);
    }

    @Override
    public String toStr() {
        return id;
    }
}