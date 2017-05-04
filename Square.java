/* ERIC LEGG 2017 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Square extends Shape{
	private int height;
	private String label;
	private int row;
	
	Square(int height, String label, int row) {
		this.height = height;
		this.label = label;
		this.row = row;
		
		draw();
	}
	
		
	public char[][] create() {
		int i, j;
		
		char[][] array = new char[this.height][this.height];
		
		for(i = 0; i < this.height; i++) {
			for(j = 0; j < this.height; j++) {
				array[i][j] = 'X';
			}
		}
		
		int label_placement = ((this.height/2) - (this.label.length())/2);
		
		//placing the designated label into the shape
		for (j = 0; j < this.label.length(); j++) {
			array[this.row][j+label_placement] = this.label.charAt(j);
		}
		
		return array;
	}
	
	public void draw() {
		char[][] array = create();
		int i, j;
		
		for (i = 0; i < this.height; i++) {
			for(j = 0; j < this.height; j++) {
				System.out.printf("%c ", array[i][j]);
				if (j == this.height-1) {
					System.out.printf("%n");
				}
			}
		}
	}	
}