package Stack;

import java.util.EmptyStackException;

public class MyStack implements MyStackInterface{
    Object[] content;
    @Override
    public Object push(Object item) {
        if (this.content != null) {
            Object[] newContent = new Object[this.content.length + 1];
            System.arraycopy(content, 0, newContent, 0, this.content.length);
            newContent[this.content.length] = item;
            this.content = newContent;
        }else {
            this.content = new Object[]{item};
        }
        return item;
    }

    @Override
    public Object pop() {
        if (this.content != null) {
            Object obj = this.content[0];
            Object[] newContent = new Object[this.content.length - 1];
            System.arraycopy(this.content, 0, newContent, 0, this.content.length - 1);
            this.content = newContent;
            return obj;
        }
        throw new EmptyStackException();
    }

    @Override
    public Object peek() {
        if (this.content != null) {
            return this.content[this.content.length-1];
        }
        throw new EmptyStackException();
    }

    @Override
    public int size() {
        if (this.content != null) {
            return this.content.length;
        }
        return -1;
    }

    @Override
    public boolean empty() {
        if (this.content != null){
            return false;
        }
        return true;
    }
    @Override
    public String toString(int index){
        if (this.content !=null){
            if (this.content[index] instanceof Object[]){
                String toReturn = "";
                for (Object obj : (Object[]) this.content[index]) {
                    toReturn += obj + ", ";
                }
                return toReturn;
            }else if (this.content[index] instanceof Object){
                return (String) this.content[index];
            }else if (this.content[index] == null){
                return null;
            }
        }
        throw new EmptyStackException();
    }
    @Override
    public int search(Object o) {
        if (this.content != null) {
            for (int i = 0; i < this.size(); i++) {
                if (this.content[i] == o) {
                    return i;
                }
            }
        }else {
            throw new EmptyStackException();
        }
        return -1;
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.search(null);
        Integer[] ints = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        myStack.push(ints);
        System.out.println(myStack.search(ints));
    }
}
