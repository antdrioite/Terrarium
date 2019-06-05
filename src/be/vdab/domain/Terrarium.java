package be.vdab.domain;

import java.util.ArrayList;
import java.util.List;

public enum Terrarium {

	INSTANCE;
	List<Organism> grid;

	public void addOrganism(Organism organism) {
		grid.add(organism);

	}



	//public Location getXemptyLocations() {
	//	
	//}



	Terrarium() {

		grid = new ArrayList<>();
		Location een = new Location(4,0);
		Location twee = new Location(0,1);
		Location drie = new Location(0,3);
		Location vier = new Location(0,4);
		Location vijf = new Location(3,0);
		Location zes = new Location(3,1);

		grid.add(new Plant(twee, 1));
		grid.add(new Herbivore(een, 0, this));
		grid.add(new Herbivore(drie, 0, this));
		grid.add(new Herbivore(vier, 0, this));
		grid.add(new Herbivore(zes, 0, this));
		grid.add(new Carnivore( vijf, 0, this));

	}



	public List<Location> getEmptyLocations() {


		List<Location> opgevuldePlekken = new ArrayList<>();
		for(Organism organism : grid){
			opgevuldePlekken.add(organism.getLocation());
		}
		List<Location> legePlekken = new ArrayList<>();
		for(int i=0;i<=5;i++){
			for(int j=0;j<=5;j++){
				Location location = new Location(i, j);
				if(!opgevuldePlekken.contains(location)){
					legePlekken.add(location);

				}
			}
		}
		return legePlekken;

	}

	Terrarium(List<Organism> grid) {
		this.grid = grid;
	}

	public List<Organism> getAllOrganisms() {

		List<Organism> alleOrganisms = new ArrayList<>();

		for(Organism organism : grid) {
			if (organism instanceof Organism) {
				alleOrganisms.add(organism);
			}
		}
		return alleOrganisms;
	}

	public void remove(Organism organism){
		grid.remove(organism);
	}








}
