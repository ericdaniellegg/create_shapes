/* ERIC LEGG 2017 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Triangle extends Shape{
	private int height;
	private String label;
	private int row;
	
	Triangle(int height, String label, int row) {
		this.height = height;
		this.label = label;
		this.row = row;
		
		draw();
	}
	
	public char[][] create_triangle() {
		int i, j, k;
		int width = this.height;
		
		int label_placement = ((row/2) - (this.label.length())/2);
		
		char[][] array = new char[this.height][width]; 
		
		//successful right triangle
		for (i = 0; i < this.height; i++) {
			for (k = 0; k <= i; k++) {
				array[i][k] = 'X';
			}
		} 
		
		//placing the designated label into the shape
		for (j = 0; j < this.label.length(); j++) {
			array[this.row][j+label_placement] = this.label.charAt(j);
		}
		
		return array;
	}
	
	public void draw() { 
		char[][] array = create_triangle();
		int i, j, k;
		int space = this.height; 	//this variable adds the appropriate number of spaces to the 
									//right triangle in order to make it appear as an equilateral one
		
		for (i = 0; i < this.height; i++) {
			for (k = 0; k < space; k++) {
				System.out.printf(" ");
			}
			for(j = 0; j < this.height; j++) {
				System.out.printf("%c ", array[i][j]);
				if (j == this.height-1) {
					System.out.printf("%n");
				}
			}
			space--;
		}
	}	
}