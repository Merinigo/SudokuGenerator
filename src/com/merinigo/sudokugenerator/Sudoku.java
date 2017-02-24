package com.merinigo.sudokugenerator;

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
	
	public boolean isOnRow(int number, int row){		
		boolean isOnRow = false;
		for(int j=0; j < sudokuArray[row].length; j++){
			if(sudokuArray[row][j] == number){
				isOnRow = true;
			}
		}
		return isOnRow;		
	}
	
	public boolean isOnColumn(int number, int column){		
		boolean isOnColumn = false;		
		for(int i=0; i < sudokuArray.length; i++){
			if(sudokuArray[i][column] == number){
				isOnColumn = true;
			}
		}
		return isOnColumn;		
	}
	
	public boolean isOnSquare(int number, int row, int column){						
		//Cuadrante 1
		if(row < 3 && column < 3){			
			for(int i=0; i < 3; i++){
				for(int j=0; j < 3; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		//Cuadrante 2
		if(row < 3 && column < 6){			
			for(int i=0; i < 3; i++){
				for(int j=3; j < 6; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		//Cuadrante 3
		if(row < 3 && column < 9){			
			for(int i=0; i < 3; i++){
				for(int j=6; j < 9; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		//Cuadrante 4
		if(row < 6 && column < 3){			
			for(int i=3; i < 6; i++){
				for(int j=0; j < 3; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		//Cuadrante 5
		if(row < 6 && column < 6){			
			for(int i=3; i < 6; i++){
				for(int j=3; j < 6; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		//Cuadrante 6
		if(row < 6 && column < 9){			
			for(int i=3; i < 6; i++){
				for(int j=6; j < 9; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		//Cuadrante 7
		if(row < 9 && column < 3){			
			for(int i=6; i < 9; i++){
				for(int j=0; j < 3; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		//Cuadrante 8
		if(row < 9 && column < 6){			
			for(int i=6; i < 9; i++){
				for(int j=3; j < 6; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		//Cuadrante 9
		if(row < 9 && column < 9){			
			for(int i=6; i < 9; i++){
				for(int j=6; j < 9; j++){
					if(sudokuArray[i][j] == number){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	protected int[][] getSudokuArray(){
		return sudokuArray;
	}
	
	protected void resetSudoku(){
		this.sudokuArray = new int[9][9];
	}
	
	
}
