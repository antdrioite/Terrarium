package tests;


import be.vdab.domain.GameController;
import be.vdab.domain.Terrarium;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void activateOrganisms() {
//        controller.spawnPlants();
    }

    @Test
    public void printTerrarium() {
        controller.printTerrarium();
    }
}