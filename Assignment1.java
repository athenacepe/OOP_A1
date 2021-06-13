/**
 * Name: Athena Cepe
 * ID: 18470716
 * Pledge of honour: I pledge by honour that this program is solely my own work.
 */

package application;
import static java.lang.System.out;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Assignment1 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//q1();
		//q2();
		//q3();
		//q4();
		//q5();
		//q6();
		//q7();
	}

	public static void q1() {
		String fmt = "%-18s%-20s\n";
		out.printf(fmt, "Escape Sequence", "Description");
		String spaceline = String.format("%40s", "");
		String dashline = spaceline.replace(" ", "-");
		out.println(dashline);
		out.printf(fmt, "\\n", "New Line Character");
		out.printf(fmt, "\\t", "Horizontal Tab Character");
		out.printf(fmt, "\\\"", "Double Quote Character");
		out.printf(fmt, "\\b", "Backspace Character");
	}

	public static void q2() {
		//Asking the user for a radius of a circle
		double num1;
		out.print("Enter circle radius: ");
		num1 = Double.parseDouble(input.nextLine());

		//These will be used to calculate and find the Area, Diameter, and Perimeter using the Radius.
		double Radius = num1;
		double Area = Radius * Radius * Math.PI;
		double Diameter = Radius * 2;
		double Perimeter = Diameter * Math.PI;

		out.print("\n");
		String fmt = "%-15s%-15s%-50s\n";
		out.printf(fmt, "Radius", "Perimeter", "Area");
		String spaceline = String.format("%40s", "");
		String dashline = spaceline.replace(" ", "-");
		out.println(dashline);
		String fmt1 = "%.2f %15.2f %14.2f";
		out.printf(fmt1, Radius, Perimeter, Area); // Output
	}

	public static void q3() {
		//Asks the user to enter a score, this program will determine the letter grade equivalent. 
		double score;
		while(true) {
			out.print("Enter a score: ");
			score = Double.parseDouble(input.nextLine());
			if(score >= 0 && score < 50) {
				out.printf("Score %.1f is in grade D.\n", score);
				break;
			}
			else if(score >= 50 && score < 70 ) {
				out.printf("Score %.1f is in grade C.\n", score);
				break;
			}
			else if(score >= 70 && score < 80 ) {
				out.printf("Score %.1f is in grade B.\n", score);
				break;
			}
			else if(score >= 80 && score < 100 ) {
				out.printf("Score %.1f is in grade A.\n", score);
				break;
			}
			else {
				out.printf("There is no grade score for %.1f.\n", score);
			}
		}
	}

	public static void q4() {
		//Asks the user for a season's name, then displays a greeting message that comes with the season.
		while(true) {
			out.print("Enter season name (summer/spring/winter/autumn): ");
			String season = input.nextLine();
			if(season.equalsIgnoreCase("summer")) {
				out.println("Summer is an oil painting.");
				break;
			}
			else if(season.equalsIgnoreCase("spring")) {
				out.println("Spring is a water colour.");
				break;
			}
			else if(season.equalsIgnoreCase("winter")) {
				out.println("Winter is an etching.");
				break;
			}
			else if(season.equalsIgnoreCase("autumn")) {
				out.println("Autumn is a mosaic of them all.");
				break;
			}
			else {
				out.println("Invalid season name. \n"); //Will be displayed if user input is invalid
			}
		}
	}

	public static void q5() {
		//Asks the user for 2 sets of numbers, and this program will determine the number of overlapping values
		String line1;
		out.println("Enter first line: ");
		line1 = input.nextLine();
		String[] fn = line1.split(",");
		double[] darr1 = new double[fn.length];
		for(int i = 0; i < fn.length; i++){     
			darr1[i] = Double.parseDouble(fn[i]); }

		String line2;
		out.println("Enter second line: ");
		line2 = input.nextLine();
		String[] sn = line2.split(",");
		double[] darr2 = new double[sn.length];
		for(int j = 0; j < sn.length; j++){     
			darr2[j] = Double.parseDouble(sn[j]); }

		int count = 0;
		for(double n1 : darr1) { 
			for(double n2 : darr2) {
				if(n1 == n2) {
					count++;	
				}
			}
		}
		out.println("Number of overlapping values: " + count); // Output 
	}

	public static void q6() {
		//The program will automatically generate a random city and will ask the user to guess which country has that city
		String[] countries = {"New Zealand", "India", "Germany", "Thailand", "Greece", "Netherlands"};
		String[] cities = {"Wellington", "New Delhi", "Berlin", "Bangkok", "Athens", "Amsterdam"};
		int ranInt = ThreadLocalRandom.current().nextInt(0,6); //generates a random number

		String city = cities[ranInt];
		String country = countries[ranInt];

		String ask;
		out.printf("Which country has the capital %s? \n" + "Enter up to three names, comma-separated: ", city);
		ask = input.nextLine();
		String[] resp = ask.split(",");

		if(resp.length > 3) { //If the user guesses more than 3 countries, this message will be displayed and game will end
			out.println("\nToo many names. Game over."); 
		}
		else {
			Boolean check = false;
			for(String c : resp) {
				if (c.equalsIgnoreCase(country)) {
					check = true;
				}
			} 
			if(check) { //This will check whether the user's guess is correct or incorrect
				out.printf("\nThe country is %s.\nYou're correct. Well done.", countries[ranInt]);
			}
			else {
				out.printf("\nThe country is %s.\nYour answer is incorrect.", countries[ranInt]);
			}
		}
	}

	public static void q7() {
		//This program will ask the user the number of sensors are in use, and what the temperature is
		out.print("== Collecting Temperatures ==\n");
		int sensor;
		while(true) {
			out.print("How many sensors are in use: ");
			sensor = Integer.parseInt(input.nextLine());
			if(sensor <= 0) {
				out.println("Invalid.");
			}
			else {
				break;
			}
		}
		// The total, average, and maximum temperature will be automatically calculated based on the input
		ArrayList<Double> tempVal = new ArrayList<Double>();
		double val = 0; 
		double total = 0; 
		int counter = 1; 
		while(sensor > 0 ) {
			out.printf("Enter temperature #%d: ", counter);
			val = Double.parseDouble(input.nextLine()); 
			tempVal.add(val); 
			total += val; 
			counter++;
			sensor--;
		}
		out.printf("Total: %.2f \n", total);

		out.print("\n== Display Statistics ==\n");
		//Average
		double avgTemp = total/tempVal.size();
		out.printf("Average temperature: %.2f \n", avgTemp);
		//Maximum
		Double maxTemp = Collections.max(tempVal);
		out.printf("Maximum temperature: %.2f \n", maxTemp);
		//Number of temperature between 10-20
		int count = 0;
		for(double numTemp : tempVal)     {
			if(numTemp >= 10 && numTemp <= 20) {
				count++;
			}
		}
		out.printf("Number of temperature between 10-20: %d \n ", count);
		
		// User can also query what the temperature is for the sensor they want to know
		out.print("\n== Query Sensor Temperatures ==\n"); 
		int queSensor;
		while(true) {
			out.print("Enter sensor number (1 - " + tempVal.size() + "): ");
			queSensor = Integer.parseInt(input.nextLine());
			if (queSensor < 1 || queSensor > tempVal.size()) {
				out.println("Sensor doesn’t exist. Enter again.");
			}
			else {
				out.printf("Temperature for sensor #%d:  %.2f", queSensor, tempVal.get(queSensor-1));
				break;
			}
		}
	}
}