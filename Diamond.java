/* ERIC LEGG 2017 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Diamond extends Shape{
	private int height;
	private String label;
	private int row;
	
	Diamond(int height, String label, int row) {
		this.height = height;
		this.label = label;
		this.row = row;
		
		draw();
	}
	
	public char[][] create() {
		int exes = this.height;
		int whitespace = 0;
		int i, j, k;
		int width = this.height;
		int counter = 0;
		
		int label_placement = ((row/2) - (this.label.length())/2);
		
		char[][] array = new char[this.height][width]; 
		
		//top half of diamond
		for (i = 0; i < (this.height/2); i++) {
			for (k = 0; k <= i; k++) {
				array[i][k] = 'X';
			}
		} 
		
		//bottom half
		if (this.height%2 != 0) { //if height is odd
			for (i = (this.height/2); i < this.height;i++) {
				for (k = (this.height/2); k >= 0; k--) {
					array[i][k] = 'X';
					
				}
				for (k = 0; k < counter; k++) {
					array[i][k] = ' ';
				}
			counter++;
			}
		} else { //if height is even
			
			for (i = (this.height/2); i < this.height;i++) { 
				for (k = (this.height/2); k >= 0; k--) {
					array[i][k] = 'X';
					
				}
				for (k = 0; k <= counter; k++) { 
					array[i][k] = ' ';
				}
				counter++;
			}
		}
		
		//placing the designated label into the shape
		for (j = 0; j < this.label.length(); j++) {
			array[this.row][j+label_placement] = this.label.charAt(j);
		}
		
		return array;
	}
	
	public void draw() { //make this better
		char[][] array = create();
		int i, j, k;
		int space = this.height; 	//this variable adds the appropriate number of spaces to the 
									//right triangle in order to make it appear as an equilateral one
		
		//if the value of height is odd
		if (this.height%2 != 0) {
			for (i = 0; i < this.height; i++) {
				for (k = 0; k < space; k++) {
					System.out.printf(" ");
				}
				for(j = 0; j < this.height; j++) {
					
					if (j > this.height/2) {

					} else {
						System.out.printf("%c ", array[i][j]);
					}
					if (j == this.height-1) {
						System.out.printf("%n");
					}
				}
				space--;
			}
		//if the value of height is even	
		} else { 
			//top portion
			for (i = 0; i < this.height/2; i++) {
				for (k = 0; k < space; k++) {
					System.out.printf(" ");
				}
				for(j = 0; j < this.height; j++) {
					
					if (j > this.height/2) {

					} else {
						System.out.printf("%c ", array[i][j]);
					}
					if (j == this.height-1) {
						System.out.printf("%n");
					}
				}
				space--;
			}
			space--;
			//bottom portion
			for (i = this.height/2; i < this.height; i++) {
				for (k = 0; k < space; k++) {
					System.out.printf(" ");
				}
				for(j = 0; j < this.height; j++) {
					
					if (j > this.height/2) {

					} else {
						System.out.printf("%c ", array[i][j]);
					}
					if (j == this.height-1) {
						System.out.printf("%n");
					}
				}
				if (space >= 0) {
					space--;
				}
			}
			
		}
	}	
}