package be.vdab.domain;

import java.util.List;

public class Carnivore extends Animal{


    public Carnivore(Location location, int lifeForce, Terrarium terrarium) {
        super(location, lifeForce, terrarium);
    }

    @Override
    public boolean interactWithEnvironment() {
        List<Organism> organisms = this.getTerrarium().getAllOrganisms();
        Location toTheRight = new Location(getLocation().getX() +1, getLocation().getY());
        if(toTheRight.getX() > 5){
            toTheRight.setX(0);
        }
        boolean hasInteracted = false;
        for(Organism organism : organisms){
            //check if there's an organism to the right
            if(organism.getLocation().equals(toTheRight)){
                //eat it if Herbivore
                if(organism.getClass().equals(Herbivore.class)){
                    eat((Herbivore) organism);
                    hasInteracted = true;
                }
                //fight it if Carnivore
                else if(organism.getClass().equals(Carnivore.class)){
                    fight((Carnivore) organism);
                    hasInteracted = true;
                }
            }
        }
        if(!hasInteracted){
            System.out.println("C moved");
            this.move();
            return false;
        }
        return true;
    }


    private void eat(Herbivore herbivore){
        this.setLifeForce(this.getLifeForce() + herbivore.getLifeForce());
        this.getTerrarium().remove(herbivore);
    }

    private void fight(Carnivore enemy){
        if(enemy.getLifeForce() == this.getLifeForce()){
            //do nothing
        }
        else if(enemy.getLifeForce() > this.getLifeForce()){
            enemy.setLifeForce(enemy.getLifeForce() + this.getLifeForce());
            this.getTerrarium().remove(this);
        }
        else if(enemy.getLifeForce() < this.getLifeForce()){
            this.setLifeForce(enemy.getLifeForce() + this.getLifeForce());
            this.getTerrarium().remove(enemy);
        }
    }
}


