package be.vdab.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    Terrarium terrarium = new Terrarium();
    Herbivore herbivore1 = new Herbivore(new Location(3,2), 0, terrarium);
    Herbivore herbivore2 = new Herbivore(new Location(2,4), 0, terrarium);
    Herbivore herbivore3 = new Herbivore(new Location(1,4), 0, terrarium);
    Herbivore herbivore4 = new Herbivore(new Location(2,3), 0, terrarium);
    Herbivore herbivore5 = new Herbivore(new Location(2,5), 0, terrarium);
    Herbivore herbivore6 = new Herbivore(new Location(3,4), 0, terrarium);
    Carnivore carnivore1 = new Carnivore(new Location(5,5), 0, terrarium);

    @Test
    public void animal_can_move_up_down_left_right() {
        herbivore1.move();
        assertTrue(herbivore1.getLocation().getX() == 3 || herbivore1.getLocation().getY() == 2);
        assertFalse(herbivore1.getLocation().getX() != 3 && herbivore1.getLocation().getY() != 2);
    }

    @Test
    public void animal_cannot_move_to_occupied_location() {
        herbivore2.move();
        assertFalse(herbivore2.getLocation().equals(herbivore3.getLocation()));
        assertFalse(herbivore2.getLocation().equals(herbivore4.getLocation()));
        assertFalse(herbivore2.getLocation().equals(herbivore5.getLocation()));
        assertFalse(herbivore2.getLocation().equals(herbivore6.getLocation()));
    }

    @Test
    public void animal_cannot_move_out_of_array_bounds() {
        carnivore1.move();
        assertFalse(carnivore1.getLocation().getX() == 6);
        assertFalse(carnivore1.getLocation().getY() == 6);
    }
}