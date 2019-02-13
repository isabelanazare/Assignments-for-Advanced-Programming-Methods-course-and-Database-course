package model;

public class AppleTree implements Tree {
    private String name;
    private Integer age;

    public AppleTree(String name, Integer age){
        this.name=name;
        this.age=age;
    }
    public String getName(){return this.name;}
    public int getAge(){return this.age;}

}
