package be.vdab.domain;

import java.util.List;

public class GameController {

    Terrarium terrarium;

    public GameController(Terrarium terrarium) {
        this.terrarium = terrarium;
    }

    public void spawnPlants(){
        List<Location> emptyLocations = terrarium.getEmptyLocations();
        int randomNumber = (int) Math.ceil(Math.random() * emptyLocations.size());
        Plant plant = new Plant(emptyLocations.get(randomNumber), 1); //one lifeforce
        terrarium.addOrganism(plant);
    }
    public void activateOrganisms(){
        //then let Carnivores interact with environment
        for(Organism organism : terrarium.getAllOrganisms()){
            if(organism instanceof Carnivore){
                Carnivore carnivore = (Carnivore) organism;
                boolean hasInteracted = carnivore.interactWithEnvironment();
                if(!hasInteracted){
                    carnivore.move();
                }
            }
        }
        //then let Herbivores interact with environment
        for(Organism organism : terrarium.getAllOrganisms()){
            if(organism instanceof Herbivore){
                Herbivore herbivore = (Herbivore) organism;
                boolean hasInteracted = herbivore.interactWithEnvironment();
                if(!hasInteracted){
                    herbivore.move();
                }
            }
        }
    }
    public void printTerrarium(){
        //not very efficient but temporary, size of Terrarium should be variable
        for(int x=0;x<=5;x++){
            for(int y=0;y<=5;y++){
                Location location = new Location(x, y);
                boolean organismFound = false;
                for(Organism organism : terrarium.getAllOrganisms()){
                    if(organism.getLocation().equals(location)){
                        organismFound = true;
                        if(organism instanceof Plant){
                            System.out.print("P\t");
                        }
                        else if(organism instanceof Herbivore){
                            System.out.print("H\t");
                        }
                        else if(organism instanceof Carnivore){
                            System.out.print("C\t");
                        }
                    }
                }
                if(!organismFound){
                    System.out.print(".\t");
                }
            }
            System.out.println();
        }
    }
}
