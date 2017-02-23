package main;

public class Sudoku {

	private int[][] sudokuArray;

	public Sudoku() {
		this.sudokuArray = new int[9][9];
	}
	
	public void setNumInPos(int num, int row, int col){
		this.sudokuArray[row][col] = num;
	}
	
	public int getNumInPos(int row, int col){
		return this.sudokuArray[row][col];
	}
	
	protected int[][] getSudokuArray(){
		return sudokuArray;
	}
	
	protected void resetSudoku(){
		this.sudokuArray = new int[9][9];
	}
	
	
	
}
