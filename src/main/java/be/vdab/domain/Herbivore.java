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
        if  (neighbourOrganism == null) {
            System.out.println("Moved.");
            return this.move();

        } else if (neighbourOrganism.getClass().equals(Herbivore.class)) {
            System.out.println("Love is in the air!");
            this.getTerrarium().addNewHerbivore(); // Moet dit geen Boolean worden?
            return true;
        } else if (neighbourOrganism.getClass().equals(Plant.class)) {
                this.setLifeForce(this.getLifeForce() + neighbourOrganism.getLifeForce());
                this.getTerrarium().remove(neighbourOrganism);
                return true;

        } else {
            System.out.println("Something wrong.");
            return false;
        }
    }
}
