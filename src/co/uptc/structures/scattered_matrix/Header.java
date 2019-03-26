package co.uptc.structures.scattered_matrix;

public class Header<T, V> {
	protected T data;
	protected Cell<V> cell;
	
	public Header(T data) {
		this.data = data;
		this.cell=null;
	}
	public Header(T data, Cell<V> first) {
		this.data = data;
		this.cell=first;
	}
	
	public T getData() {
		return data;
	}
	
	public Cell<V> getCell() {
		return cell;
	}
	
	public void setCell(Cell<V> cell) {
		this.cell = cell;
	}
}
