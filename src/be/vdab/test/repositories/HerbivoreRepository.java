package be.vdab.test.repositories;

import be.vdab.domain.Location;
import be.vdab.domain.Terrarium;

public interface HerbivoreRepository {

    public void Herbivore(Location location, int lifeForce, Terrarium terrarium);

    boolean interactWithEnvironment();
}

