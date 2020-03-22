/**
 * 
 */


/**CSE201 Project #2
 * @author Jinkai Zeng
 * 
 */
public class Checker {
	private int row;
	private int column;

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	public Checker(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void move(int row, int column) {
		// TO DO
		if(row - this.row == 1 && column - this.column == 1){
			this.row = row;
			this.column = column;
		}
	}
	
	public void capture(int row, int column){
		// TO DO
	}
	
	
	public boolean equals(Checker other) {
		return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());	
	}

	@Override
	public String toString() {
		return "" + "abcdefgh".charAt(row) + (8 - column);
	}
}