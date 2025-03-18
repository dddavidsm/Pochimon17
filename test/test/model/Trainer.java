package model;

import java.util.ArrayList;
import java.util.List;
//Clase Trainer
public class Trainer {
 private static int idCounter = 1;

 private String name;
 private int id;
 private int level;
 private int experience;
 private List<String> badges;
 private List<Pochimon> team;

 // Constructor
 public Trainer(String name) {
     this.name = name;
     this.id = idCounter++;
     this.level = 1;
     this.experience = 0;
     this.badges = new ArrayList<>();
     this.team = new ArrayList<>();
 }

 // Getters y setters
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public int getId() {
     return id;
 }

 public int getLevel() {
     return level;
 }

 public int getExperience() {
     return experience;
 }

 public List<String> getBadges() {
     return badges;
 }

 public List<Pochimon> getTeam() {
     return team;
 }

 // Métodos principales
 public void addBadge(String badge) {
     badges.add(badge);
 }

 public void addPochimon(Pochimon pochimon) {
     if (team.size() < 6) {
         team.add(pochimon);
     } else {
         System.out.println("Your team is full!");
     }
 }

 public void removePochimon(Pochimon pochimon) {
     team.remove(pochimon);
 }

 public void gainExperience(int xp) {
     this.experience += xp;
     if (this.experience >= 100) { // Ejemplo: 100 XP para subir de nivel
         levelUp();
     }
 }

 private void levelUp() {
     this.level++;
     this.experience = 0;
     System.out.println(name + " has leveled up to level " + level + "!");
 }
}
