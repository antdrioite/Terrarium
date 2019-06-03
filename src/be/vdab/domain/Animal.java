package be.vdab.domain;

public abstract class Animal extends Organism {

    public Animal(Location location, int lifeForce) {
        super(location, lifeForce);
    }

    public boolean move() {
        return true;
    }

    public abstract boolean interactWithEnviorment();
}
