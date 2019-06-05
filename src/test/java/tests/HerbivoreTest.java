package be.vdab.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HerbivoreTest {
    private Terrarium terrarium;
    private GameController gameController;

    @Before
    public void before() {
        terrarium = new Terrarium();
        gameController = new GameController(terrarium);
    }

    @Test
    public void checkIfHerbivorePairsWithHisRightwardHerbivore() {
        for (Organism organism : terrarium.getAllOrganisms()) {
            terrarium.remove(organism);
        }
        Herbivore herbivore = new Herbivore(new Location(0, 0), 1, terrarium);
        Herbivore herbivoreTwo = new Herbivore(new Location(1, 0), 1, terrarium);
        terrarium.addOrganism(herbivore);
        terrarium.addOrganism(herbivoreTwo);
        int organismsBefore = terrarium.getAllOrganisms().size();
//    gameController.activateOrganisms();
        herbivore.interactWithEnvironment();
        int organismsAfther = terrarium.getAllOrganisms().size();
        assertEquals(-1, Integer.compare(organismsBefore, organismsAfther));
//    assertTrue(-1 == (new Integer.compare(organismsBefore,organismsAfther)));
    }

    @Test
    public void checkIfHerbivoreMovesWhenHisRightwardspotIsEmpty() {
        for (Organism organism : terrarium.getAllOrganisms()) {
            terrarium.remove(organism);
        }
        Herbivore herbivore = new Herbivore(new Location(0, 0), 1, terrarium);
        Herbivore herbivoreTwo = new Herbivore(new Location(2, 0), 1, terrarium);
        terrarium.addOrganism(herbivore);
        terrarium.addOrganism(herbivoreTwo);
        Location locationHerbivoreBeforeActivation = herbivore.getLocation();
        herbivore.interactWithEnvironment();
        Location locationHerbivoreAftherActivation = herbivore.getLocation();
        assertNotEquals(locationHerbivoreBeforeActivation, locationHerbivoreAftherActivation);
    }

    @Test
    public void checkIfHerbivoreEatsRightwardPlantAndGetsItsLifeForce() {
        for(Organism organism : terrarium.getAllOrganisms()){
            terrarium.remove(organism);
        }
        Herbivore herbivore = new Herbivore(new Location(0, 0), 1, terrarium);
        Plant plant = new Plant(new Location(1, 0), 1);
        terrarium.addOrganism(herbivore);
        terrarium.addOrganism(plant);
        herbivore.interactWithEnvironment();
        assertTrue((herbivore.getLifeForce() == 2) && (terrarium.getAllOrganisms().size() == 1));
    }
}
