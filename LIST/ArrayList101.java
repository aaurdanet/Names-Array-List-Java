package LIST;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList101 {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		char choice = 'Q';
		
		ArrayList<Name> name = new ArrayList<Name>();
		do {
			choice = getChoice();

			switch (choice) {

			case 'A':
				loadList(name);

			case 'D':
				displayNames(name);

			case 'S':
				maxVowel(name);
				retrieveWord(name);
			case 'Q':
				break;

			default:
				System.out.println("Invalid selection");
			}
		} while (choice != 'Q');

	}// end of main

	public static void retrieveWord(ArrayList<Name> names) {
int high =  names.get(0).getVowel();
int index=0;
for(int i = 1; i < names.size(); i ++) {

		if(high < names.get(i).getVowel()) {
		high = names.get(i).getVowel();
			index = i;
		}
			}	
	
System.out.println(names.get(index).getName());
	}

	public static void maxVowel(ArrayList<Name> names) {
		int sum =0;
		for (int i = 0; i < names.size(); i++) {
			String lowerCaseWord = names.get(i).getName().toLowerCase(); // get lowercase version so we don't have to
																			// check each letter twice
			int count = 0;
			for (int j = 0; j < lowerCaseWord.length(); j++) { // loop through each char in the string
				char c = lowerCaseWord.charAt(j);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					count++;
			}
			names.get(i).setVowel(count);
			sum = count + sum;
			

		}
		System.out.println("The total number of vowels is " + sum);
	}


	static char getChoice() {
		String result;
		String menu = "[A]dd a name to the list\n[D]isplay all names in the list in ascending order\n[S]tatistics\n[Q]uit\nEnter selection: ";
		System.out.println(menu);
		result = in.next();

		return result.toUpperCase().charAt(0);
	}// end of getChoice

	public static void displayNames(ArrayList<Name> name) {

		int count = 0;
		for (int i = 0; i < name.size(); i++) {
			System.out.println((i+1) + ". The name is " + name.get(i).getName());
		}
		
		System.out.println("Total names entered " +  name.size());
	}

	public static ArrayList<Name> loadList(ArrayList<Name> list) {// adding names to arrayList
		
		int eSize = 0;
		System.out.println("How many names you want to enter");
		eSize = in.nextInt();
		int i = 0;
		String message;
		message = ("Enter name: ");
		String clear = in.nextLine();

		for (i = 0; i < eSize; i++) {
			Name generic = new Name();
			System.out.println(message);
			generic.setName(in.nextLine());
			list.add(generic);
			
		} // end of loop
		return list;
	}// end of load list

}// end of class
