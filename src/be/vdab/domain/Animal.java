package be.vdab.domain;

public abstract class Animal extends Organism{
    public void move(){
    }

    public void interactWithEnviorment() {
    Location  neighbourLocation = new Location(this.getLocation().getxPosition()+1,this.getLocation().getyPosition());
    }
}
