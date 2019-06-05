package be.vdab.test;

import be.vdab.domain.Terrarium;
import be.vdab.domain.Organism;
import be.vdab.domain.Herbivore;
import be.vdab.domain.Plant;
import be.vdab.domain.Location;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TerrariumTest {

    private Terrarium testPlek;

    @Before
    public void before() {
        testPlek = new Terrarium();
    }

    @Test
    public void add2OrganismToTheSameLocation() {

        int x, y;
        x = 5;
        y = 2;
        Location testLocation = new Location(x, y);

        //Herbivore one = new Herbivore(testLocation, 6, tester );
        Plant one = new Plant(testLocation, 4);
        Plant two = new Plant(testLocation, 5);
        testPlek.addOrganism(two);
        testPlek.addOrganism(one);
        List<Organism> toonVeld = new ArrayList<>();
        toonVeld = testPlek.getAllOrganisms();
        for (Organism dier : toonVeld) {
            System.out.println(dier.getLocation());
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void addOrganismOutOfBound() {
        int x, y;
        x = 35;
        y = 45;
        Location outOfBoundLocation = new Location(x, y);

        Plant one = new Plant(outOfBoundLocation, 1);
        //zou een fout moeten geven
        testPlek.addOrganism(one);

    }

    @Test(expected = IllegalArgumentException.class)
    public void AddOrganismOnNegativeLocation() {
        int x, y;
        x = -5;
        y = -5;
        Location negativeLocation = new Location(x, y);
        Plant one = new Plant(negativeLocation, 1);
        testPlek.addOrganism(one);

    }

    //addOrganism
    //addNewHerbivore
    //getEmptyLocations
    //remove


    @Test
    public void leegTerrarium() {
        assertTrue(this.maakTerrariumLeeg());
    }

    public boolean maakTerrariumLeeg() {
        List<Organism> allemaal = new ArrayList<>();
        boolean isLeeg = true;
        allemaal = testPlek.getAllOrganisms();

        for (Organism alle : allemaal) {
            if (alle != null) {
                testPlek.remove(alle);
            }
        }
        isLeeg = true;
        return isLeeg;
    }


}