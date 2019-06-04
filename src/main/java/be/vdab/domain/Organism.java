package be.vdab.domain;

public abstract class Organism {
    private Location location;
    private int lifeForce;

    public Organism(Location location, int lifeForce) {
        this.location = location;
        this.lifeForce = lifeForce;
    }

    public Location getLocation() {
        return location;
    }

    public int getLifeForce() {
        return lifeForce;
    }

    public void setLifeForce(int lifeForce) {
        this.lifeForce = lifeForce;
    }
}
