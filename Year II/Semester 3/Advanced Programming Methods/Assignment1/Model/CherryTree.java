package model;

public class CherryTree implements Tree{
    private String name;
    private Integer age;

    public CherryTree(String name, Integer age){
        this.name=name;
        this.age=age;
    }
    public String getName(){return this.name;}
    public int getAge(){return this.age;}
}
