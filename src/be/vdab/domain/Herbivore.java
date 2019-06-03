package be.vdab.domain;

import com.sun.java.util.jar.pack.Instruction;

public class Herbivore extends Animal{

    public Herbivore(Location location, int lifeForce) {
        super(location, lifeForce);
    }

    @Override
    public boolean interactWithEnviorment() {
        Location neighbourLocation = new Location(this.getLocation().getxPosition() + 1, this.getLocation().getyPosition());
        Organism neighbourOrganisme = Terrarium.getOrganism(neighbourLocation);
        switch (neighbourOrganisme){
            case neighbourOrganisme.equals(Plant):
                this.setLifeForce(this.getLifeForce()+neighbourLocation.)
        }

                (neighbourOrganisme.equals())
    }
}
