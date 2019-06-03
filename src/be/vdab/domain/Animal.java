package be.vdab.domain;

public abstract class Animal extends Organism {

    public Animal(Location location, int lifeForce) {
        super(location, lifeForce);
    }

    public void move() {
        Location currentLocation = this.getLocation();

    }

    public abstract boolean interactWithEnviorment();
}
