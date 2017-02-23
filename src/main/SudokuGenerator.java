package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SudokuGenerator {
	
	public static Sudoku generateSudoku(){
		Sudoku generatedSudoku = new Sudoku();
		boolean isGenerated = false;
		
		while(!isGenerated){
			try{				
				populateSudoku(generatedSudoku);
				isGenerated = true;
			}catch (IllegalArgumentException e) {						
				generatedSudoku.resetSudoku();			
			}
		}
		
		
		
		return generatedSudoku;
	}
	
	private static void populateSudoku(Sudoku sudoku) throws IllegalArgumentException{		
		fillCuadrant(0, 3, 0, 3, sudoku);
		fillCuadrant(0, 3, 3, 6, sudoku);
		fillCuadrant(0, 3, 6, 9, sudoku);	
		
		fillCuadrant(3, 6, 0, 3, sudoku);
		fillCuadrant(3, 6, 3, 6, sudoku);
		fillCuadrant(3, 6, 6, 9, sudoku);				
		
		fillCuadrant(6, 9, 0, 3, sudoku);
		fillCuadrant(6, 9, 3, 6, sudoku);
		fillCuadrant(6, 9, 6, 9, sudoku);								
	}
	
	private static void fillCuadrant(int initialRow, int finalRow, int initialCol, int finalCol, Sudoku sudoku) throws IllegalArgumentException{
		int[][] sudokuArray = sudoku.getSudokuArray();
		ArrayList<Integer> posibles;
		
		for(int i=initialRow; i < finalRow; i++){
			for(int j=initialCol; j < finalCol; j++){				
				posibles = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
				int pos = ThreadLocalRandom.current().nextInt(posibles.size());
				int number = posibles.get(pos);
								
				while(isOnRow(number, i, sudoku) || isOnColumn(number, j, sudoku) || isOnSquare(number, i, j, sudoku)){					
					posibles.remove(pos);
					pos = ThreadLocalRandom.current().nextInt(posibles.size());									
					number = posibles.get(pos);								
				}				
				sudokuArray[i][j] = number;				
			}
		}				
	}
	
	private static boolean isOnRow(int number, int row, Sudoku sudoku){
		int[][] sudokuArray = sudoku.getSudokuArray();
		boolean isOnRow = false;
		for(int j=0; j < sudokuArray[row].length; j++){
			if(sudokuArray[row][j] == number){
				isOnRow = true;
			}
		}
		return isOnRow;		
	}
	
	private static boolean isOnColumn(int number, int column, Sudoku sudoku){
		int[][] sudokuArray = sudoku.getSudokuArray();
		boolean isOnColumn = false;		
		for(int i=0; i < sudokuArray.length; i++){
			if(sudokuArray[i][column] == number){
				isOnColumn = true;
			}
		}
		return isOnColumn;		
	}
	
	private static boolean isOnSquare(int number, int row, int column, Sudoku sudoku){		
		int[][] sudokuArray = sudoku.getSudokuArray();
		
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
		
	public static void showSudoku(Sudoku sudoku){
		int[][] sudokuArray = sudoku.getSudokuArray();
		for(int i=0; i < sudokuArray.length; i++){
			for(int j=0; j < sudokuArray[i].length; j++){
				System.out.print(sudokuArray[i][j] + " ");
			}
			System.out.println();
		}		
		System.out.println("---------------");
	}
	
}
