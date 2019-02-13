package model;

public class AssignStmt implements IStmt {
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return this.id + " = " + exp.toString();
    }

    @Override
    public PrgState execute(PrgState state){
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        symTable.put(this.id, this.exp.eval(symTable));
        return null;
    }
}