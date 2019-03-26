package co.uptc.structures.circular_list;

public class NodeCircularList<T> {
    protected T info;
    public NodeCircularList<T>  next;

    public NodeCircularList(T info, NodeCircularList<T> next) {
        this.info = info;
        this.next = next;
    }

    public NodeCircularList(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public NodeCircularList<T> getNext() {
        return next;
    }

    public void setNext(NodeCircularList<T> next) {
        this.next = next;
    }
    
}
