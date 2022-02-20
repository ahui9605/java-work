/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leoli
 */
public abstract class FishableItem {

    protected String name;
    protected int points;

    public FishableItem() {

    }

    public FishableItem(String name, int points) {
        this.name = name;
        this.points = points;
    }

    //abstract method that can be override by other fish classes.
    public abstract void getName();

    public abstract void getPoints();

    @Override
    public abstract String toString();

}
