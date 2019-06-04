package be.vdab.domain;

import java.util.List;

public abstract class Animal extends Organism {
    private Terrarium terrarium;

    public Animal(Location location, int lifeForce, Terrarium terrarium) {
        super(location, lifeForce);
        if(terrarium == null){
            throw new IllegalArgumentException();
        }
        this.terrarium = terrarium;
    }

    public boolean move() {
        int currentX = this.getLocation().getX();
        int currentY = this.getLocation().getY();
        int newX = (int) (Math.random() * (((currentX + 1) - (currentX - 1)) + 1)) + (currentX - 1);
        int newY = currentY;
        if (newX == currentX) {
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
            if (emptyLocation.equals(newLocation)) {
                this.getLocation().setX(newX);
                this.getLocation().setY(newY);
                return true;
            }
        }
        return false;
    }

    public abstract boolean interactWithEnvironment();

    public Terrarium getTerrarium() {
        return terrarium;
    }
}
