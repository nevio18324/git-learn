package Stack;

public interface MyStackInterface  <E>{
    public E push(E item);
    public E pop();
    public E peek();
    int size();
    public boolean empty();
    public String toString(int index);
    public int search(Object o);
}
