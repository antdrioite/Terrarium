package be.vdab.domain;

public abstract class Animal extends Organism {

    public Animal(Location location, int lifeForce) {
        super(location, lifeForce);
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
        this.setLocation(new Location(newX, newY));
        return true;
    }

    public abstract boolean interactWithEnvironment();
}
