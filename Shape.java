/* ERIC LEGG 2017 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Shape {
	
	public static void main(String[] args) {
		int i, j;
		String label;
		int row = 0;
		Boolean end = false;
		String endString = " "; //string for use when ending program

		Scanner input = new Scanner(System.in);
		
		while (end == false) {
			System.out.println("Please enter the shape you would like to create.  Options:");

			System.out.println("Type T for Triangle");
			System.out.println("Type S for Square");
			System.out.println("Type D for Diamond");
			
			String userType = input.nextLine();
			char type = userType.charAt(0);

			while (type != 'T' && type != 't' && type != 'S' && type != 's' && type != 'D' && type != 'd') {
				System.out.println("Invalid option. Please select a valid option: ");
				userType = input.nextLine();
				type = userType.charAt(0);
				
				if (type == 'T' || type == 't' || type == 'S' || type == 's' || type == 'D' || type == 'd') {
					break;
				}
			}
			
			System.out.println("Shape's height: ");

			int height = input.nextInt();
			input.nextLine();
			
			System.out.println("Shape label. For default, press enter without entering anything: ");
			
			label = input.nextLine();

			System.out.println("Please select row for \"" + label + "\"."); 
			
			int tempLabel = label.length()-1;
			
			if (type == 'T' || type == 't') {
				if (label.length() > height) {
					System.out.println("Unable to apply label; unsupported by height constraints.");
					row = 0;
					label = "";
				} else {
					while (row < label.length()-1 || row >= height+1) {
						System.out.println("Must be higher than " + tempLabel + " and less than or equal to " + height);
						row = input.nextInt();
						input.nextLine();
					}
				}
			} else if (type == 'D' || type == 'd') {
				if (label.length() > height/2) {
					System.out.println("Unable to apply label; unsupported by height constraints.");
					row = 0;
					label = "";
				} else if (label.length() < height/2) {
					while (row <= label.length() || row >= (height-label.length())) {
						System.out.println("Value must be between " + label.length() + " and " + (height-label.length()));
						row = input.nextInt();
						input.nextLine();
					}
				}
			} else if (type == 'S' || type == 's') {
				if (label.length() > height) {
					System.out.println("Unable to apply label; unsupported by height constraints.");
					row = 0;
					label = "";
				} else {
					while (row <= 0 || row > height) {
						System.out.println("Value must be below " + (height+1));
						row = input.nextInt();
						input.nextLine();
					}
				}
			}
			
			row -= 1; //in order to align with array (whose max index is number -1
			
			if (type == 'T' || type == 't') {
				Shape triangle = new Triangle(height, label, row);
			} else if (type == 'S' || type == 's') {
				Shape square = new Square(height, label, row);
			} else if (type == 'D' || type == 'd') {
				Shape diamond = new Diamond(height, label, row);
			} else {
				System.out.println("Invalid input measure.");
			}
			
			while (!endString.equalsIgnoreCase("Y") && !endString.equalsIgnoreCase("N")) { 
				System.out.println("Would you like to create another shape? Enter Y or N.");
				endString = input.nextLine();
				
				if (endString.equalsIgnoreCase("N")) {
					return;
				}
			}
		}
	}
	
	
}