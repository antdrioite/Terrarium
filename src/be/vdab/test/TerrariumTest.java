package be.vdab.test;

import be.vdab.domain.Terrarium;
import be.vdab.domain.Organism;
import be.vdab.domain.Herbivore;
import be.vdab.domain.Plant;
import be.vdab.domain.Location;
import org.junit.Test;

import static org.junit.Assert.*;

public class TerrariumTest {


    @Test
    public void add2OrganismToTheSameLocation() {
        Terrarium tester = new Terrarium();
        int x, y;
        x = 5;
        y = 2;
        Location testLocation = new Location(x, y);

        //Herbivore one = new Herbivore(testLocation, 6, tester );
        Plant one = new Plant(testLocation, 4);
        Plant two = new Plant(testLocation, 5);
        tester.addOrganism(two);
        tester.addOrganism(one);
        //assertEquals(tester.addOrganism(one), tester.addOrganism(two));


    }

    //addOrganism
    //addNewHerbivore
    //getEmptyLocations
    //remove
}