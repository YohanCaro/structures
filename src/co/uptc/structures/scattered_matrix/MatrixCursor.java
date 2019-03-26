package co.uptc.structures.scattered_matrix;

import co.uptc.structures.simple_list.Cursor;

public class MatrixCursor<TC, TR, T> extends MyMatrix<TC, TR, T> {
	protected Cursor<Header<TC, T>> cursorColumn;
	protected Cursor<Header<TR, T>> cursorRow;

	public MatrixCursor(MyMatrix<TC, TR, T> matrix) {
		super(matrix);
		this.cursorColumn = new Cursor<>(matrix.columnList);
		this.cursorRow = new Cursor<>(matrix.rowList);

	}

	public T getNextInfo() {
		T aux = null;
		if (this.cursorRow.isOut()) {
			this.cursorRow.reset();
			this.cursorColumn.next();
		}
		if (!this.cursorColumn.isOut())
			aux = this.get(this.cursorColumn.getInfo().getData(), this.cursorRow.getInfo().getData());
		this.cursorRow.next();
		if (aux == null)
			return null;
		return aux;
	}

	public T getData() {
		return this.get(this.cursorColumn.getInfo().getData(), this.cursorRow.getInfo().getData());
	}

	public void next() {
		this.cursorRow.next();
		if (this.cursorRow.isOut()) {
			this.cursorRow.reset();
			this.cursorColumn.next();
		}
	}

	public boolean isOut() {
		return this.cursorColumn.isOut();
	}

	public void reset() {
		this.cursorColumn.reset();
		this.cursorRow.reset();
	}
}
