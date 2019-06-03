package be.vdab.domain;

public class GameController {

    Terrarium terrarium;

    public GameController(Terrarium terrarium) {
        this.terrarium = terrarium;
    }

    public void spawnPlants(){
        List<Location> emptyLocations = terrarium.getEmptyLocations();
        randomNumber = (int) Math.ceil(Math.random() * emptyLocations.size());
        Plant plant = new Plant(emptyLocations.get(randomNumber), 1); //one lifeforce
        terrarium.add(plant);
    }
    public void activateOrganisms(){
        for(Organism organism : terrarium.getAllOrganisms){
            if(organism instanceof Carnivore.class){
                organism.move();
                organism.interactWithEnvironment();
            }
        }
        for(Organism organism : terrarium.getAllOrganisms){
            if(organism instanceof Herbivore.class){
                organism.move();
                organism.interactWithEnvironment();
            }
        }
    }
    public void printTerrarium(){
        //not very efficient but temporary
        for(int i=0;i>5;i++){
            for(int j=0;j>5;j++){
                for(Organism organism : terrarium.getAllOrganisms){
                    if(organism.getLocation().getX() == i && organism.getLocation().getY() == j){
                        if(organism instanceof Plant.class){
                            System.out.print("P");
                        }
                        else if(organism instanceof Herbivore.class){
                            System.out.print("H");
                        }
                        else if(organism instanceof Carnivore.class){
                            System.out.print("C");
                        }
                    }
                    else{
                        System.out.print(".");
                    }
                }

            }
            System.out.println();
        }
    }
}
