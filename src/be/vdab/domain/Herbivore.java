package be.vdab.domain;

import com.sun.java.util.jar.pack.Instruction;

public class Herbivore extends Animal{

    public Herbivore(Location location, int lifeForce) {
        super(location, lifeForce);
    }

    @Override
    public boolean interactWithEnviorment() {
        return true;
    }
}
