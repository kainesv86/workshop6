/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManager;

import helper.MenuHelper;

/**
 *
 * @author Kaine
 */
public class StudentManager {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		MenuHelper menu = new MenuHelper(6);
		menu.add("Add new student");
		menu.add("Search a student");
		menu.add("Update name and mark");
		menu.add("Remove a student");
		menu.add("List all");
		menu.add("Quit");

		int choice = 0;

		do {
			System.out.println("\nStudent managing Program");
			choice = menu.getChoice();
			switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Bye!");
			}
		} while (choice > 0 && choice < 6);
	}
	
}
