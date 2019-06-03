package be.vdab;

import be.vdab.domain.GameController;
import be.vdab.domain.Terrarium;

import java.util.Scanner;

public class Main {
	//scanner om de inputs te lezen
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welkom bij Terrarium. Zo begint jouw terrarium:");

        //maak een terrarium en gamecontroller object
	    Terrarium terrarium = new Terrarium();
	    GameController controller = new GameController(terrarium);
	    //print dag 1
	    controller.printTerrarium();
		System.out.println("druk v voor volgende dag, druk s om te stoppen");
	    //vraag en check input aan de user
		String input = scanner.nextLine();
		while(input != "s") {
			if (input == "v") {
				controller.spawnPlants();
				controller.activateOrganisms();
				controller.printTerrarium();
			}
			else {
				System.out.println("foute input");
			}
			System.out.println("druk v voor volgende dag, druk s om te stoppen");
			input = scanner.nextLine();
		}
    }
}
