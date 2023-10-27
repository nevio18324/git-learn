package Set;

public class MySet<E> implements MySetInterfaceSimple {
    Object[] content;

    public static void main(String[] args) {
        MySet mySet = new MySet();
        System.out.println(mySet.size());
    }

    @Override
    public boolean add(Object element) {
        if (this.content != null) {
            for (Object obj : this.content) {
                if (obj != null) {
                    if (obj.equals(element)) {
                        return false;
                    }
                } else if (null == element) {
                    return false;
                }
            }
            Object[] newContent = new Object[this.size() + 1];
            System.arraycopy(this.content, 0, newContent, 0, this.content.length);
            newContent[this.content.length] = element;
            this.content = newContent;
            return true;
        } else {
            this.content = new Object[]{element};
            return true;
        }
    }

    @Override
    public boolean remove(Object object) {
        boolean removed = false;
        if (this.content != null) {
            for (int i = 0; i < this.content.length; i++) {
                if (this.content[i] == object) {
                    if (i == this.content.length - 1) {
                        removed = true;
                    } else {
                        for (int j = i; j < this.content.length - 1; j++) {
                            this.content[j] = this.content[j + 1];
                            removed = true;
                        }
                    }
                }
            }
        }
        while (removed) {
            Object[] newContent = new Object[this.content.length - 1];
            System.arraycopy(this.content, 0, newContent, 0, this.content.length - 1);
            this.content = newContent;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        if (this.content != null) {
            for (Object obj : this.content) {
                if (obj == object) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        if (this.content != null) {
            return this.content.length;
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        try {
            Object a = this.content[0];
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public void clear() {
        this.content = new Object[]{};
    }
}
