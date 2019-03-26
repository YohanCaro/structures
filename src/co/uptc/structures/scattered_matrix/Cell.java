package co.uptc.structures.scattered_matrix;

public class Cell<T> {

	protected T data;
	protected Cell<T> right;
	protected Cell<T> down;

	public Cell(T data) {
		this.data = data;
		this.right = null;
		this.down = null;
	}

	public Cell(T data, Cell<T> right, Cell<T> down) {
		this.data = data;
		this.right = right;
		this.down = down;
	}
	
	/**
	 * Obtiene el dato .
	 *
	 * @return dato
	 */
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public Cell<T> getRight() {
		return right;
	}

	public void setDown(Cell<T> down) {
		this.down = down;
	}
	
	public Cell<T> getDown() {
		return down;
	}
	
	public void setRight(Cell<T> right) {
		this.right = right;
	}
}