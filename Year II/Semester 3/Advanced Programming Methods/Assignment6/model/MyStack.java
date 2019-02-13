package model;
import java.util.Stack;

public class MyStack <T> implements MyIStack<T> {
    private Stack <T> stack;
    public MyStack(Stack <T> stack) {
        this.stack = stack;
    }

    @Override
    public void push(T el) {
        this.stack.push(el);
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }

    @Override
    public T peek() {
        return this.stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public Stack<T> getStack() {
        return this.stack;
    }

    @Override
    public String toString() {

        StringBuilder bld = new StringBuilder();

        for(T i : this.stack){
            bld.append(i).append(" ");
        }
        return bld.toString();
        /*
        String repr = "";
        MyStack <T> rev = new MyStack<T>(new Stack<T>());
        boolean ok = false;
        while(!this.isEmpty()) {
            if(ok)
                repr = repr + "\r\n";
            repr += this.peek().toString();
            rev.push(this.pop());
            ok = true;
        }
        while(!rev.isEmpty())
            this.push(rev.pop());
        return repr;*/
    }
}