package be.vdab.domain;

public class Carnivore extends Animal{

    public Carnivore(Location location, int lifeForce) {
        super(location, lifeForce);
    }

    @Override
    public boolean interactWithEnvironment() {
        Location neighbourLocation = new Location(this.getLocation().getX()+1,this.getLocation().getY());
        Organism neighbour = 
    }
}
