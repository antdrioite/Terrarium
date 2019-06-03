package be.vdab.terarium;

public class Terrarium {
	
	List<Organism> grid;
	
	public void addOrganism(Organism organism) {
		grid.add(organism);
	
	}
	
	
	
	//public Location getXemptyLocations() {
	//	
	//}
	
	
	
	public Terrarium() {
		
		grid = new ArrayList<>;
		Location een = new Location(0,0);
		Location twee = new Location(0,1);
		Location drie = new Location(0,3);
		Location vier = new Location(0,4);
		Location vijf = new Location(3,0);
		Location zes = new Location(3,1);
		
		grid.add(new Plant(twee));
		grid.add(new Herbivoor(een));
		grid.add(new Herbivoor(drie));
		grid.add(new Herbivoor(vier));
		grid.add(new Herbivoor(zes));
		grid.add(new Carnivoor(vijf);)
		
	}



	public Location getEmptyLocations() {
		
		List<Organism> legePlekken = new ArrayList<>;
		
		for (Organism organism : grid) {
			if (!(organism instanceof Organism)) {
				legePlekken.add(organism);	
			}
		}
		return legePlekken;
	}
	
	public Terrarium(List<Organism> grid) {
		super();
		this.grid = grid;
	}

	public Organism getAllOrganisms() {
		
		List<Organism> alleOrganisms = new ArrayList<>;
		
		for(Organism organism : grid) {
			if (organism instanceof Organism) {
				alleOrganisms.add(organism);
			}	
		}
		return alleOrganisms;
	}
	
	
	
	
	
	
	

}
