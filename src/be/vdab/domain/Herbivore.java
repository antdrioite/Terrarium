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
        for (Organism organism : organisms) {
            if (organism.getLocation().equals(organismToMyRight)) {
                neighbourOrganism = organism;
            }
        }
        switch (neighbourOrganism) {
            case neighbourOrganism.getClass().equals(Plant.class):
                this.setLifeForce(this.getLifeForce() + neighbourOrganism.getLifeForce());
                this.getTerrarium().remove(neighbourOrganism);
                return true;
            case neighbourOrganism.getClass().equals(Herbivore.class):
                System.out.println("Love is in the air!");
                Terrarium.addNewHerbivore();
                return true;
            case neighbourOrganism == null:
                return this.move();
            default:
                return false;
        }
    }
}
