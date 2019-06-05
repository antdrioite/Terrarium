package be.vdab.domain;

import java.util.ArrayList;
import java.util.List;

public class Terrarium {

	List<Organism> grid;


	public void addOrganism(Organism organism) {
		//Location occupiedLocation = new Location(organism.getLocation().getX(), organism.getLocation().getY());


		if (grid.size() <= 36) {
			if (!grid.contains(organism)) {
				grid.add(organism);

			} else if (!this.getEmptyLocations().contains(organism.getLocation())) {
				throw new IllegalArgumentException(" er is al een organisme op die plek aanwezig");
			}


		} else if (grid.contains(organism)) {

			throw new IllegalArgumentException(" de index is meer dan 36 ");
		}
	}

	public void addNewHerbivore() {
		int randomNumber = (int) Math.ceil(Math.random() * getEmptyLocations().size())-1;
		grid.add(new Herbivore(getEmptyLocations().get(randomNumber), 0, this));
	}

	public Terrarium() {

		grid = new ArrayList<>(36);
		//minimum capcity max capacity kan je niet instellen


		//in het geval dat het randomnummer hetzelfde is, zal er een fout zijn
		int randomNumber = (int) Math.ceil(Math.random() * getEmptyLocations().size())-1;
		this.addOrganism(new Plant(getEmptyLocations().get(randomNumber), 1)); //one lifeforce

		randomNumber = (int) Math.ceil(Math.random() * getEmptyLocations().size())-1;
		this.addOrganism(new Herbivore(getEmptyLocations().get(randomNumber), 0, this));

		randomNumber = (int) Math.ceil(Math.random() * getEmptyLocations().size())-1;
		this.addOrganism(new Herbivore(getEmptyLocations().get(randomNumber), 0, this));

		randomNumber = (int) Math.ceil(Math.random() * getEmptyLocations().size())-1;
		this.addOrganism(new Herbivore(getEmptyLocations().get(randomNumber), 0, this));

		randomNumber = (int) Math.ceil(Math.random() * getEmptyLocations().size())-1;
		this.addOrganism(new Herbivore(getEmptyLocations().get(randomNumber), 0, this));

		randomNumber = (int) Math.ceil(Math.random() * getEmptyLocations().size())-1;
		this.addOrganism(new Carnivore(getEmptyLocations().get(randomNumber), 0, this));
	}

	//grid heeft een fixed grote nodig nu

	public List<Location> getEmptyLocations() {


		List<Location> occupiedPlaces = new ArrayList<>();
		for(Organism organism : grid){
			occupiedPlaces.add(organism.getLocation());
		}
		List<Location> emptyPlaces = new ArrayList<>();
		for(int i=0;i<=5;i++){
			for(int j=0;j<=5;j++){
				Location location = new Location(i, j);
				if(!occupiedPlaces.contains(location)){
					emptyPlaces.add(location);

				}
			}
		}
		return emptyPlaces;

	}

	public Terrarium(List<Organism> grid) {
		super();
		this.grid = grid;


	}

	public List<Organism> getAllOrganisms() {

		List<Organism> allOrganisms = new ArrayList<>();

		for(Organism organism : grid) {
			if (organism instanceof Organism) {
				allOrganisms.add(organism);
			}
		}
		return allOrganisms;
	}

	public void remove(Organism organism){

		grid.remove(organism);
	}







}
