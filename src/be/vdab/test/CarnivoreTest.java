package be.vdab.test;

import be.vdab.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarnivoreTest {

    Terrarium terrarium = new Terrarium();
    Carnivore carnivore = new Carnivore(new Location(1, 1), 2, terrarium);

    @Before
    public void before(){
        terrarium.addOrganism(carnivore);
    }

    @Test
    public void carnivoreEatsHerbivoresToTheRight(){
        Herbivore herbivore = new Herbivore(new Location(2, 1), 1, terrarium);
        terrarium.addOrganism(herbivore);
        int numOrganismsBeforeMeal = terrarium.getAllOrganisms().size();
        carnivore.interactWithEnvironment();
        int numOrganismsAfterMeal = terrarium.getAllOrganisms().size();
        assertEquals(numOrganismsBeforeMeal -1, numOrganismsAfterMeal);
    }

    @Test
    public void carnivoreDoesNotEatPlants(){
        Plant plant = new Plant(new Location(2, 1), 1);
        terrarium.addOrganism(plant);
        int numOrganismsBeforeMeal = terrarium.getAllOrganisms().size();
        carnivore.interactWithEnvironment();
        int numOrganismsAfterMeal = terrarium.getAllOrganisms().size();
        assertEquals(numOrganismsBeforeMeal, numOrganismsAfterMeal);
    }

    @Test
    public void carnivoreDoesNotEatHerbivoresToTheLeftTopOrBottom(){
        Herbivore herbivore1 = new Herbivore(new Location(1, 2), 1, terrarium);
        Herbivore herbivore2 = new Herbivore(new Location(0, 1), 1, terrarium);
        Herbivore herbivore3 = new Herbivore(new Location(1, 0), 1, terrarium);
        terrarium.addOrganism(herbivore1);
        terrarium.addOrganism(herbivore2);
        terrarium.addOrganism(herbivore3);

        int numOrganismsBeforeMeal = terrarium.getAllOrganisms().size();
        carnivore.interactWithEnvironment();
        int numOrganismsAfterMeal = terrarium.getAllOrganisms().size();
        assertEquals(numOrganismsBeforeMeal, numOrganismsAfterMeal);

    }

    @Test
    public void carnivoreMovesIfThereIsNoMeal(){
        Plant plant = new Plant(new Location(2, 1), 1);
        terrarium.addOrganism(plant);
        boolean willNotMove = carnivore.interactWithEnvironment();
        assertTrue(!willNotMove);
    }

    @Test
    public void carnivoreTakesLifeForceOfHerbivore(){
        Herbivore herbivore = new Herbivore(new Location(2, 1), 1, terrarium);
        terrarium.addOrganism(herbivore);
        int lifeForceBeforeMeal = carnivore.getLifeForce();
        carnivore.interactWithEnvironment();
        int lifeForceAfterMeal = carnivore.getLifeForce();
        assertNotEquals(lifeForceBeforeMeal, lifeForceAfterMeal);
        assertEquals(lifeForceAfterMeal, lifeForceBeforeMeal +1);
    }

    @Test
    public void carnivoreDefeatsWeakerCarnivoresToTheRightAndTakesTheirLifeForce(){
        Carnivore weakerCarnivore = new Carnivore(new Location(2, 1), 1, terrarium);
        terrarium.addOrganism(weakerCarnivore);
        int lifeForceBeforeFight = carnivore.getLifeForce();
        int numOrganismsBeforeFight = terrarium.getAllOrganisms().size();
        carnivore.interactWithEnvironment();
        int lifeForceAfterFight = carnivore.getLifeForce();
        int numOrganismsAFterFight = terrarium.getAllOrganisms().size();
        assertEquals(lifeForceBeforeFight + 1, lifeForceAfterFight);
        assertEquals(numOrganismsBeforeFight -1, numOrganismsAFterFight);
    }
    @Test
    public void carnivoreIsDefeatedByStrongerCarnivoresToTheRightTheyTakeItsLifeForce(){
        Carnivore strongerCarnivore = new Carnivore(new Location(2, 1), 3, terrarium);
        terrarium.addOrganism(strongerCarnivore);
        int lifeForceBeforeFight = strongerCarnivore.getLifeForce();
        int numOrganismsBeforeFight = terrarium.getAllOrganisms().size();
        carnivore.interactWithEnvironment();
        int lifeForceAfterFight = strongerCarnivore.getLifeForce();
        int numOrganismsAFterFight = terrarium.getAllOrganisms().size();
        assertEquals(lifeForceBeforeFight + 2, lifeForceAfterFight);
        assertEquals(numOrganismsBeforeFight -1, numOrganismsAFterFight);
    }

    @Test
    public void carnivoresEvenlyMatchedDontFight(){
        Carnivore evenlyMatchedCarnivore = new Carnivore(new Location(2, 1), 2, terrarium);
        terrarium.addOrganism(evenlyMatchedCarnivore);
        int lifeForceBeforeFight = carnivore.getLifeForce();
        int numOrganismsBeforeFight = terrarium.getAllOrganisms().size();
        carnivore.interactWithEnvironment();
        int lifeForceAfterFight = carnivore.getLifeForce();
        int numOrganismsAFterFight = terrarium.getAllOrganisms().size();
        assertEquals(lifeForceBeforeFight, lifeForceAfterFight);
        assertEquals(numOrganismsBeforeFight, numOrganismsAFterFight);
    }

    @Test
    public void carnivoresOnLastColumnInteractWithOrganismsOnFirstColumn(){
        Carnivore carnivoreOnLastColumn = new Carnivore(new Location(5, 0), 2, terrarium);
        Herbivore herbivore = new Herbivore(new Location(0, 0), 1, terrarium);
        terrarium.addOrganism(carnivoreOnLastColumn);
        terrarium.addOrganism(herbivore);
        int numOrganismsBeforeMeal = terrarium.getAllOrganisms().size();
        carnivoreOnLastColumn.interactWithEnvironment();
        int numOrganismsAfterMeal = terrarium.getAllOrganisms().size();
        assertEquals(numOrganismsBeforeMeal -1, numOrganismsAfterMeal);

        Carnivore carnivoreOnFirstColumn = new Carnivore(new Location(0,0), 1, terrarium );
        terrarium.addOrganism(carnivoreOnFirstColumn);
        int numOrganismsBeforeFight = terrarium.getAllOrganisms().size();
        carnivoreOnLastColumn.interactWithEnvironment();
        int numOrganismsAfterFight = terrarium.getAllOrganisms().size();
        assertEquals(numOrganismsBeforeFight -1, numOrganismsAfterFight);


    }

    @Test(expected = IllegalArgumentException.class)
    public void carnivoreCannotBeCreatedWithNullLocation(){
        Carnivore carnivore = new Carnivore(null, 1, terrarium);
    }
    @Test(expected = IllegalArgumentException.class)
    public void carnivoreCannotBeCreatedWithNegativeLifeForce(){
        Carnivore carnivore = new Carnivore(new Location(2, 1), -1, terrarium);
    }
    @Test(expected = IllegalArgumentException.class)
    public void carnivoreCannotBeCreatedWithNullTerrarium(){
        Carnivore carnivore = new Carnivore(new Location(2, 1), 1, null);
    }

}