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
        //first make all organisms moe
        for(Organism organism : terrarium.getAllOrganisms()){
            organism.move();
        }
        //then let Carnivores interact with environment
        for(Organism organism : terrarium.getAllOrganisms()){
            if(organism instanceof Carnivore.class){
                organism.interactWithEnvironment();
            }
        }
        //then let Herbivores interact with environment
        for(Organism organism : terrarium.getAllOrganisms()){
            if(organism instanceof Herbivore.class){
                organism.interactWithEnvironment();
            }
        }
    }
    public void printTerrarium(){
        //not very efficient but temporary, size of Terrarium should be variable
        for(int i=0;i>5;i++){
            for(int j=0;j>5;j++){
                for(Organism organism : terrarium.getAllOrganisms()){
                    if(organism.getLocation().getX() == i && organism.getLocation().getY() == j){
                        if(organism instanceof Plant.class){
                            System.out.print("P\t");
                        }
                        else if(organism instanceof Herbivore.class){
                            System.out.print("H\t");
                        }
                        else if(organism instanceof Carnivore.class){
                            System.out.print("C\t");
                        }
                    }
                    else{
                        System.out.print(".\t");
                    }
                }

            }
            System.out.println();
        }
    }
}
