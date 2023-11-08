package MyArrayListExt;

public  class MyArrayListExtended<T> implements MyListInterfaceExtended <T>{
    private T[] content;

    @Override
    public void add(T element) {
        if (this.content != null) {
            T[] newContent =(T[]) new Object[this.content.length + 1];
            System.arraycopy(this.content, 0, newContent, 0, content.length);
            newContent[this.content.length] = element;
            this.content = newContent;
        }else {
            this.content = (T[]) new Object[]{element};
        }
    }

    public T get(int index){
        return this.content[index];
    }
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (this.content != null) {
            if (index <= this.content.length) {
                T toBeRemoved = this.content[index];
                for (int i = index; i < this.content.length - 1; i++) {
                    this.content[i] = this.content[i + 1];
                }
                T[] newContent = (T[]) new Object[this.content.length - 1];
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

    @Override
    public void add(int index, Object element) throws IndexOutOfBoundsException {
        if (this.content != null) {
            if (index < 0 || index > this.content.length) {
                throw new IndexOutOfBoundsException();
            }
            T[] newArray =(T[]) new Object[this.content.length + 1];
            System.arraycopy(this.content, 0, newArray, 0, index);
            newArray[index] = (T) element;
            System.arraycopy(this.content, index, newArray, index + 1, this.content.length - index);
            this.content = newArray;
        } else if (this.content == null && index == 0) {
            this.content = (T[]) new Object[]{element};
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean contains(Object o) {
        if (this.content != null) {
            for (Object element : this.content) {
                if (element instanceof Object[]) {
                    for (Object value : (Object[]) element) {
                        if (value.equals(o)) {
                            return true;
                        }
                    }
                } else if (element instanceof Object) {
                    if (element.equals(o)) {
                        return true;
                    }
                } else if (element == null) {
                    if (null == o) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        if (this.content != null) {
            for (int i = 0; i < this.content.length; i++) {
                if (this.content[i] != null) {
                    if (this.content[i].equals(o)) {
                        return i;
                    }
                }else {
                    if (null == o){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public Object set(int index, Object element) throws IndexOutOfBoundsException {
        if (this.content != null) {
            if (index <= this.content.length && index >= 0) {
                Object removed = this.content[index];
                this.content[index] = (T) element;
                return removed;
            }else {
                throw new  IndexOutOfBoundsException();
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean remove(Object o) {
        if (this.content != null) {
            for (int i = 0; i < this.content.length; i++) {
                if (this.content[i] != null) {
                    if (this.content[i].equals(o)) {
                        this.remove(i);
                        return true;
                    }
                }else {
                    if (null == o){
                        this.remove(i);
                        return true;
                    }
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public String toString() {
        if (this.content == null){
            return "";
        }
        String toReturn = "";
        for (Object obj: this.content) {
            if (obj instanceof Object[]) {
                for (Object element : (Object[]) obj) {
                    toReturn += element + ", ";
                }
            } else {
                toReturn += (String) obj;
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        MyArrayListExtended customArrayList = new MyArrayListExtended<>();
        Object ko = new Object[]{1,2,3,4,5};
        customArrayList.add(ko);
        customArrayList.add(null);
        System.out.println(customArrayList.toString());
        System.out.println(customArrayList.toString());
    }
}