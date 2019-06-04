package be.vdab.test;

import be.vdab.domain.Carnivore;
import be.vdab.domain.Location;
import be.vdab.domain.Plant;
import be.vdab.domain.Terrarium;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlantTest {
    Terrarium terrarium = new Terrarium();
    Plant plant = new Plant(new Location(2,2), 1);

    @Before
    public void before(){
        terrarium.addOrganism(plant);
    }


    @Test(expected = IllegalArgumentException.class)
    public void plantCannotBeCreatedWithNullLocation(){
        Plant Plant = new Plant(null, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void plantCannotBeCreatedWithNegativeLifeForce(){
        Plant Plant = new Plant(new Location(2, 1), -1);
    }
}