package model;
import java.util.ArrayList;

public class Pochimon extends ElementAbs implements ICatchable {
    private PochimonSpecies species;
    private ArrayList<Move> moves;
    private Type type;

    public Pochimon(String name, int level, PochimonSpecies species, Type type) {
        super(name, 0, level, 100); // Exp fictícia
        this.species = species;
        this.type = type;
        this.moves = new ArrayList<>();
    }

    public PochimonSpecies getSpecies() { return species; }
    public void setSpecies(PochimonSpecies species) { this.species = species; }

    public ArrayList<Move> getMoves() { return moves; }
    public void setMoves(ArrayList<Move> moves) { this.moves = moves; }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    public void attackFoe(Pochimon target) {
        System.out.println(getName() + " ataca a " + target.getName());
    }

    public void evolve() {
        System.out.println(getName() + " està evolucionant!");
    }

    public boolean tryToCatch() {
        return Math.random() < getCaptureRate();
    }

    public double getCaptureRate() {
        return 0.5;
    }
}
