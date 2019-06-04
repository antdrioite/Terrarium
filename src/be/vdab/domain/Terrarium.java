package be.vdab.domain;

import java.util.ArrayList;
import java.util.List;

public class Terrarium {

	List<Organism> grid;

	public void addOrganism(Organism organism) {
		grid.add(organism);

	}



	//public Location getXemptyLocations() {
	//	
	//}



	public Terrarium() {

        grid = new ArrayList<>();


        List<Location> emptyLocations;
        emptyLocations = this.getEmptyLocations();

        //in het geval dat het randomnummer hetzelfde is, zal er een fout zijn
        int randomNumber = (int) Math.ceil(Math.random() * emptyLocations.size());
        grid.add(new Plant(emptyLocations.get(randomNumber), 1)); //one lifeforce

        randomNumber = (int) Math.ceil(Math.random() * emptyLocations.size());
        grid.add(new Herbivore(emptyLocations.get(randomNumber), 0));

        randomNumber = (int) Math.ceil(Math.random() * emptyLocations.size());
        grid.add(new Herbivore(emptyLocations.get(randomNumber), 0));

        randomNumber = (int) Math.ceil(Math.random() * emptyLocations.size());
        grid.add(new Herbivore(emptyLocations.get(randomNumber), 0));

        randomNumber = (int) Math.ceil(Math.random() * emptyLocations.size());
        grid.add(new Herbivore(emptyLocations.get(randomNumber), 0));

        randomNumber = (int) Math.ceil(Math.random() * emptyLocations.size());
        grid.add(new Carnivore(emptyLocations.get(randomNumber), 0));
    }

	public List<Location> getEmptyLocations() {


		List<Location> occupiedPlaces = new ArrayList<>();
		for(Organism organism : grid){
			occupiedPlaces.add(organism.getLocation());
		}
		List<Location> emptyPlaces = new ArrayList<>();
		for(int i=0;i<=5;i++){
			for(int j=0;j<=5;j++){
				Location location = new Location(i, j);
				if(!emptyPlaces.contains(location)){
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








}
