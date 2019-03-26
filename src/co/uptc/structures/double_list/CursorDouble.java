package co.uptc.structures.double_list;

/**
 * Clase que maneja el cursor que se va a mover en la lista!
 * Fecha 31/08/2018
 * @author Yohan Caro
 */
public class CursorDouble<T> extends MyDoubleList<T> {
    
    private NodeDouble<T> cursor;

    public CursorDouble(MyDoubleList<T> list) {
        super(list);
        this.cursor = this.first;
    }
    
    public boolean isOut() {
        return this.cursor == null;
    }
    
    public void reset() {
        this.cursor = this.first;
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
