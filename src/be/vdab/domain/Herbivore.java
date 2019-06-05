package be.vdab.domain;

import java.util.List;

public class Herbivore extends Animal {

    public Herbivore(Location location, int lifeForce, Terrarium terrarium) {
        super(location, lifeForce, terrarium);
    }

    @Override
    public boolean interactWithEnvironment() {
        Organism neighbourOrganism = null;
        List<Organism> organisms = this.getTerrarium().getAllOrganisms();
        Location organismToMyRight = new Location(getLocation().getX() + 1, getLocation().getY());


        return true;
        }
    }

