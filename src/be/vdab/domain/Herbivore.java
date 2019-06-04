package be.vdab.domain;

public class Herbivore extends Animal{

    public Herbivore(Location location, int lifeForce, Terrarium terrarium) {
        super(location, lifeForce, terrarium);
    }

    @Override
    public boolean interactWithEnvironment() {
        return true;
    }
}
