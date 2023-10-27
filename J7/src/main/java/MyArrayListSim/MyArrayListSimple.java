package MyArrayListSim;


public  class MyArrayListSimple<T> implements MyListInterfaceSimple{
    private Object[] content;



    @Override
    public void add(Object element) {
        if (this.content != null) {
            Object[] newContent = new Object[this.content.length + 1];
            System.arraycopy(this.content, 0, newContent, 0, content.length);
            newContent[this.content.length] = element;
            this.content = newContent;
        }else {
            this.content = new Object[]{element};
        }
    }
    public Object get(int index){
        return this.content[index];
    }
    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (this.content != null) {
            if (index <= this.content.length) {
                Object toBeRemoved = this.content[index];
                for (int i = index; i < this.content.length - 1; i++) {
                    this.content[i] = this.content[i + 1];
                }
                Object[] newContent = new Object[this.content.length - 1];
                System.arraycopy(this.content,0,newContent,0,this.content.length - 1);
                this.content = newContent;
                return toBeRemoved;

            }else {
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
    }
    @Override
    public int size() {
        if (this.content == null) {
            return 0;
        }
        else {
            return this.content.length;
        }
    }
    @Override
    public boolean isEmpty() {
        try{
            Object a = this.content[0];
            return false;
        }catch (Exception e){
            return true;
        }
    }
    @Override
    public void clear() {
        this.content = (T[]) new Object[]{};
    }
    public String toString(int index) {
        String toReturn = "";
        if (this.content[index] instanceof Object[]){
            for (Object element: (Object[]) this.content[index]) {
                toReturn += element + ", ";
            }
        }else {
            toReturn = (String) this.content[index];
        }
        return toReturn;
    }


    public static void main(String[] args) {
        MyArrayListSimple myArrayListSimple = new MyArrayListSimple();
        String ka = "adada";
        String[] ok = {"122","1313"};
        myArrayListSimple.add(ok);
        System.out.println(myArrayListSimple.toString(0));
    }
}