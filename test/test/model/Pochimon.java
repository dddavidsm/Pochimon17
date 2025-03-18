package model;

public class Pochimon {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private String type;
    private String evolution;
    
    public Pochimon(String name, int level, int maxHp, int attack, int defense, String type, String evolution) {
        this.name = name;
        this.level = level;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.type = type;
        this.evolution = evolution;
    }
    
    public double getCaptureRate(int trainerLevel, int trainerNumberOfBadges) {
        double captureRate = (trainerLevel * 1.5) + (trainerNumberOfBadges * 5);
        return Math.max(1, Math.min(99, captureRate));
    }
    
    public boolean tryToCatch(int trainerLevel, int trainerNumberOfBadges) {
        double captureRate = getCaptureRate(trainerLevel, trainerNumberOfBadges);
        int randomValue = (int) (Math.random() * 100) + 1;
        return randomValue <= captureRate;
    }
    
    public void evolve() {
        if (evolution != null && !evolution.isEmpty()) {
            this.name = evolution;
        }
    }
    
    public void heal(int amount) {
        if (amount > 0 && hp < maxHp) {
            hp = Math.min(maxHp, hp + amount);
        }
    }
    
    public void takeDamage(int amount) {
        if (amount > 0 && hp > 0) {
            hp = Math.max(0, hp - amount);
        }
    }
    
    public double calculateEffectivenessMultiplier(Move move) {
        
        return 1.0;
    }
    
    private double calculateDamage(Pochimon enemy, Move move) {
        double attackStat = move.isSpecial() ? this.attack : this.defense;
        double defenseStat = move.isSpecial() ? enemy.defense : enemy.attack;
        double effectiveness = calculateEffectivenessMultiplier(move);
        double stab = move.getType().equals(this.type) ? 1.5 : 1.0;
        return (((2 * this.level / 5.0) + 2) * move.getPowerPoints() * (attackStat / defenseStat) * effectiveness * stab) / 50.0 + 2;
    }
    
    public void attackFoe(Pochimon enemy, Move move) {
        double damage = calculateDamage(enemy, move);
        enemy.takeDamage((int) damage);
    }
    
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public String getType() {
        return type;
    }

    public String getEvolution() {
        return evolution;
    }
}