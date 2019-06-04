package be.vdab.domain;

import java.util.List;

public class Carnivore extends Animal{

    private Terrarium terrarium;

    public Carnivore(Terrarium terrarium, Location location, int lifeForce) {
        super(location, lifeForce);
        this.terrarium = terrarium;
    }

    @Override
    public boolean interactWithEnvironment() {
        List<Organism> organisms = terrarium.getAllOrganisms();
        Location toTheRight = new Location(getLocation().getX() +1, getLocation().getY());
        for(Organism organism : organisms){
            if(organism.getLocation().equals(toTheRight) && organism.getClass().equals(Herbivore.class)){
                    this.setLifeForce(this.getLifeForce() + organism.getLifeForce());
                    terrarium.remove(organism);
                    return true;
            }
        }
        return false;
    }
}
