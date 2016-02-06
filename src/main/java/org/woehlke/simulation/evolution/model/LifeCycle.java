package org.woehlke.simulation.evolution.model;

/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 23:12:31
 */
public class LifeCycle {

    private int fat;
    private int age;
    private int hunger;
    private final int MAX_FAT = 2000;
    private final int MAX_HUNGER = 1000;
    private final int FULL_AGE = 200;
    private final int FAT_MINIMUM_FOR_SEX = 800;
    private final int FAT_AT_BIRTH = 500;
    private final int FAT_PER_FOOD = 25;
    private final int OLD_AGE = 800;
    private final int MAX_AGE = 1000;

    public LifeCycle() {
        hunger = 0;
        age = 0;
        fat = FAT_AT_BIRTH;
    }

    public LifeCycle(int fatAtBirth) {
        hunger = 0;
        age = 0;
        fat = fatAtBirth;
    }

    public boolean move() {
        age++;
        if (fat > 0) {
            fat--;
            return true;
        } else {
            hunger++;
            return false;
        }
    }

    public void haveSex() {
        fat /= 2;
        age = 0;
    }

    public boolean isPregnant() {
        return (age >= FULL_AGE) && (fat >= FAT_MINIMUM_FOR_SEX);
    }

    public boolean isDead() {
        return (hunger >= MAX_HUNGER) || (age >= MAX_AGE);
    }

    public void eat(int food) {
        if (fat + food* FAT_PER_FOOD <= MAX_FAT) {
            fat += food* FAT_PER_FOOD;
        }  else {
            fat = MAX_FAT;
        }
    }

    public int getFat() {
        return fat;
    }

    public LifeCycleStatus getLifeCycleStatus(){
        if(fat==0 && hunger>=0){
            return LifeCycleStatus.HUNGRY;
        }
        if(age<FULL_AGE){
            if(fat< FAT_MINIMUM_FOR_SEX){
                return LifeCycleStatus.YOUNG;
            } else {
                return LifeCycleStatus.YOUNG_AND_FAT;
            }
        } else {
            if (age<OLD_AGE) {
                return LifeCycleStatus.FULL_AGE;
            } else {
                if (age < MAX_AGE) {
                    return LifeCycleStatus.OLD;
                } else {
                    return LifeCycleStatus.DEAD;
                }
            }
        }
    }
}