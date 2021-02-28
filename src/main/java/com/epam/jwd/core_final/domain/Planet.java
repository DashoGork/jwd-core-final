package com.epam.jwd.core_final.domain;

/**
 * Expected fields:
 * <p>
 * location could be a simple class Point with 2 coordinates
 */
public class Planet extends AbstractBaseEntity{
    private int i;
    private int j;

    public Planet(String name, int i, int j){
        super.setName(name);
        this.i=i;
        this.j=j;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + super.getName() + '\'' +
                ", i=" + i +
                ", j=" + j +
                '}';
    }

    public double distanceBetween(Planet planet){
        return (Math.sqrt((planet.i-this.i)*(planet.i-this.i)+(planet.j-this.j)*(planet.j-this.j)));
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
