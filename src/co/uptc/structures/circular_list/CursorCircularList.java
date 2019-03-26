package co.uptc.structures.circular_list;

public class CursorCircularList<T> extends CircularList<T> {
    
    private NodeCircularList<T> cursor;

    public CursorCircularList(CircularList<T> list) {
        super(list);
        this.cursor = this.cursor;
    }
    
    public boolean isOut() {
        return this.cursor == null;
    }
    
    public boolean isLast() {
        return this.cursor.next == null;
    }
    
    public T getInfo() {
        return this.cursor.info;
    }
    
    public void next() {
        this.cursor = cursor.next;
    }
    
    public T nextAndGetInfo() {
        T aux = cursor.info;
        this.cursor = cursor.next;
        return aux;
    }
    
}
