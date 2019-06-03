package be.vdab.domain;

public class Herbivore extends Animal{

    public Herbivore(Location location, int lifeForce) {
        super(location, lifeForce);
    }

    @Override
    public boolean interactWithEnviorment() {
        Location neighbourLocation = new Location(this.getLocation().getxPosition() + 1, this.getLocation().getyPosition());
        Organism neighbourOrganisme = Terrarium.getOrganism(neighbourLocation);
        if (neighbourOrganisme.equals())
    }
}
