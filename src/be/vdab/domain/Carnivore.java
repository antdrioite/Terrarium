package be.vdab.domain;

import java.util.List;

public class Carnivore extends Animal{


    public Carnivore(Location location, int lifeForce, Terrarium terrarium) {
        super(location, lifeForce, terrarium);
    }

    @Override
    public boolean interactWithEnvironment() {
        List<Organism> organisms = this.getTerrarium().getAllOrganisms();
        Location toTheRight = new Location(getLocation().getX() +1, getLocation().getY());
        for(Organism organism : organisms){
            if(organism.getLocation().equals(toTheRight) && organism.getClass().equals(Herbivore.class)){
                    this.setLifeForce(this.getLifeForce() + organism.getLifeForce());
                    this.getTerrarium().remove(organism);
                    return true;
            }
        }
        return false;
    }
}
