/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Zehui Liu
 * @date February 22, 2022
 *
 * An abstract class included some abstract methods that can be override by
 * other fish classes.
 */
public abstract class FishableItem {

    protected String name;
    protected int points;

    protected FishableItem() {

    }

    protected FishableItem(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public abstract void getName();

    public abstract void getPoints();

    @Override
    public abstract String toString();

}
