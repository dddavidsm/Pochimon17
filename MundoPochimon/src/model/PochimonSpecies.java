package model;

import java.util.ArrayList;

public class PochimonSpecies {
    private String speciesName;
    private ArrayList<Type> types;

    public PochimonSpecies(String speciesName) {
        this.speciesName = speciesName;
        this.types = new ArrayList<>();
    }

    public String getSpeciesName() { return speciesName; }
    public void setSpeciesName(String speciesName) { this.speciesName = speciesName; }

    public ArrayList<Type> getTypes() { return types; }
    public void setTypes(ArrayList<Type> types) { this.types = types; }
}
