package be.vdab.test.repositories;

import be.vdab.domain.Location;
import be.vdab.domain.Terrarium;

public class HerbivoreRepositoryStub implements HerbivoreRepository {

    @Override
    public void Herbivore(Location location, int lifeForce, Terrarium terrarium) {
        Location test = new Location(location.getX(), location.getY());
        int lifeforce = lifeForce;
        Terrarium testVeld = new Terrarium();
        testVeld = terrarium;

    }

    @Override
    public boolean interactWithEnvironment() {
        boolean value = true;
        return value;

    }


}
