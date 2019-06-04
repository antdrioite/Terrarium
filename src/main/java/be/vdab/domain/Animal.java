package be.vdab.domain;

import java.util.List;

public abstract class Animal extends Organism {
    private Terrarium terrarium;

    public Animal(Location location, int lifeForce, Terrarium terrarium) {
        super(location, lifeForce);
        this.terrarium = terrarium;
    }

    public boolean move() {
        boolean foundEmptyLocation = false;
        int currentX = this.getLocation().getX();
        int currentY = this.getLocation().getY();
        while (!foundEmptyLocation) {
            int newX = (int) (Math.random() * (((currentX + 1) - (currentX - 1)) + 1)) + (currentX - 1);
            int newY = currentY;
            while ((newX == currentX) && (newY == currentY)) {
                newY = (int) (Math.random() * (((currentY + 1) - (currentY - 1)) + 1)) + (currentY - 1);
            }
            if (newX > 5) {
                newX = 0;
            }
            if (newY > 5) {
                newY = 0;
            }
            Location newLocation = new Location(newX, newY);
            List<Location> emptyLocations = terrarium.getEmptyLocations();
            for (Location emptyLocation : emptyLocations) {
                if (emptyLocation.equals(newLocation) && !(newLocation.equals(this.getLocation()))) {
                    this.setLocation(newLocation);
                    foundEmptyLocation = true;
                }
            }
        }
        return true;
    }

    public abstract boolean interactWithEnvironment();
}
