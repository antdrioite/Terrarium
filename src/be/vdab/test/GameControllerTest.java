package be.vdab.test;


import be.vdab.domain.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameControllerTest {

    Terrarium terrarium = new Terrarium();
    GameController controller = new GameController(terrarium);

    @Test
    public void spawnPlants() {
        int sizeBefore = terrarium.getAllOrganisms().size();
        controller.spawnPlants();
        int sizeAfter = terrarium.getAllOrganisms().size();
        assertEquals(sizeBefore +1, sizeAfter);
    }

    @Test
    public void organismsAreActivated() {
        for(Organism organism : terrarium.getAllOrganisms()){
            terrarium.remove(organism);
        }
        terrarium.addOrganism(new Carnivore(new Location(0,0) ,1, terrarium));
        terrarium.addOrganism(new Herbivore(new Location(1,0) ,1, terrarium));
        controller.activateOrganisms();
        assertEquals(1, terrarium.getAllOrganisms().size());
    }

    @Test
    public void printTerrarium() {
        controller.printTerrarium();
    }
}