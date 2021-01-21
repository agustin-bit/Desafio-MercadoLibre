package meli.challenge.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootApplication
public class MeliChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeliChallengeApplication.class, args);

		boolean active = false;

//		String[] dna = {
//			"CAGTGCCCCCTA",
//			"TTATGTCCCCTA",
//			"AGAAGGCCCCTA",
//			"CCCCCCCCAAAA",
//			"TCACTGCCCCTA",
//			"ATGCGACCCCTA",
//			"ATGCGACCCCTA",
//			"ATGCGACCCCTA",
//			"ATGCGACCCCTA",
//			"ATGCGACCCCTA",
//			"ATGCGACCCCTA",
//			"ATGCGACCCCTA",
//		};

//		String[] dna = {
//					"ATGCGA",
//					"CAGTGC",
//					"TTATGT",
//					"AGAAGG",
//					"CCCCCA",
//					"TCACTG"
//				};

		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGAAGG",
				"CCCCCA",
				"TCACTG"
		};

		char[][] array2DDna = stringArrayTo2DCharArray(dna);
		print(array2DDna);

		//System.out.println("Horizontal -----");

		//printColumn(array2DDna[4]);
		//System.out.println(search(array2DDna[4]));

		//System.out.println("Vertical -----");

		//printColumn(getMatrixColumn(array2DDna, 4));
		//System.out.println(search(getMatrixColumn(array2DDna, 4)));

//		System.out.println("Oblicuo -----");
//		System.out.println(search(getMatrixOblique(array2DDna, 0, 0)));

//		System.out.println("Oblicuo inversa -----");
//		System.out.println(search(getMatrixInverseOblique(array2DDna, 4, 5)));

		//resolve(array2DDna);

	}

	public static char[][] stringArrayTo2DCharArray(String [] dna){
		char[][] matrix = new char[dna.length][dna.length];
		for (int i = 0; i < dna.length; i++) {
			for (int j = 0; j < dna.length; j++) {
				matrix[i][j] = dna[i].charAt(j);
			}
		}
		return matrix;
	}

	public static void print(char[][] dna){
		for (char[] chars : dna) {
			for (int j = 0; j < dna.length; j++) {
				if (j == dna.length - 1)
					System.out.print(chars[j]+"\n");
				else{
					System.out.print(chars[j]);
				}
			}
		}
	}

	public static void printColumn(char [] row){
		for (char c : row) {
			System.out.println(c);
		}
	}

	public static int search(char[] row){
		char flag = ' ';
		int letterCount = 0;
		int sequenceCount = 0;
		boolean restart = false;
		for (char c : row) {
			if (restart) {
				flag = c;
				restart = false;
			}
			if (flag == c) {
				letterCount++;
				if (letterCount == 4) {
					sequenceCount++;
					letterCount = 1;
					restart = true;
				}
			} else {
				letterCount = 1;
				flag = c;
			}
		}
		return sequenceCount;
	}

	public static char[] getMatrixColumn(char [][] matrix, int column){
		char [] row = new char [matrix[1].length];
		for (int i = 0; i < row.length; i++) {
			row[i] = matrix[i][column];
		}
		return row;
	}

	public static char[] getMatrixOblique(char[][] matrix, int row, int column){
		char [] result = new char[matrix.length];
		int flag = 0;
		while (row < matrix[0].length && column < matrix[1].length){
			result[flag] = matrix[row][column];
			flag++;
			row++;
			column++;
		}
		return result;
	}

	public static char[] getMatrixInverseOblique(char[][] matrix, int row, int column){
		char[] result = new char[matrix.length];
		int flag = 0;
		while(row < matrix[0].length && column >= 0){
			result[flag] = matrix[row][column];
			flag++;
			row++;
			column--;
		}
		return result;
	}

	public static void resolve(char[][] matrix){
		int row = matrix.length-1;
		int column = 0;
		while(column < matrix.length && row >= 0){

			//In this line start the execution of the algorithm

			/*

				Example of execution of the algorithm:
				P G G F F R
				T O O O O U
				T O O O O U
				H O O O O X
				H O O O O X
				H O O O O X

				T: Horizontal and oblique search
				U: Inverse oblique search
				R: Vertical and inverse oblique search
				P: Horizontal, vertical and oblique search
				G: Vertical and oblique search
				F: Vertical and inverse oblique search

				Bounds of obliques execution:
				The oblique are executed when the next conditions:
				row < (LENGTH - DNA LENGTH) AND col < (LENGTH - DNA LENGTH)

				The inverse oblique are exectuted when the next conditions:
				row < (LENGTH - DNA LENGTH) AND col > (LENGTH - DNA LENGTH)

			 */


			System.out.println(matrix[row][column]);

			if(column == 0){
				System.out.println(search(matrix[row]));
				if(row <= matrix.length - 4){
					System.out.println(search(getMatrixOblique(matrix, row, column)));
				}
			}

			if(row == 0 && column != 0 && column != matrix.length-1){
				System.out.println(search(getMatrixColumn(matrix, column)));
				if(column <= matrix.length - 4){
					System.out.println(search(getMatrixOblique(matrix, row, column)));
				}
				if(column > matrix.length - 4){
					System.out.println(search(getMatrixOblique(matrix, row, column)));
				}
			}

			if(column == matrix.length-1 && row <= matrix.length - 4){
				System.out.println(search(getMatrixInverseOblique(matrix, row, column)));
			}

			//End execution

			//Start to traverse the matrix

			/*
				Example of execution:

				X X X X X X
				X V V V V X
				X V V V V X
				X V V V V X
				X V V V V X
				X V V V V X

				The X char are the path of execution of the algorithm

			 */


			//if the column is the max index
			//we iterate for the right side of the matrix
			if(column == matrix.length-1){
				if(row < matrix.length-1){
					//Increment the value of the row to down for the right side
					row++;
				}
				else{
					//End the travel
					break;
				}
			}
			//if the row is 0 and the column is not the max
			//we iterate for the top of the matrix
			if(row == 0 && column != matrix.length-1){
				column++;
			}
			//if the columns is 0 the row that decrement one per time
			//we iterate for the left side of the matrix
			if(column == 0){
				//Decrement the row value to up for the left side
				row--;
			}

			//End

		}
	}

}
