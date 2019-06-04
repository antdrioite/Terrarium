package be.vdab.domain;

public class Herbivore extends Animal{

    public Herbivore(Location location, int lifeForce) {
        super(location, lifeForce);
    }

    @Override
    public boolean interactWithEnvironment() {
        return true;
    }
}
