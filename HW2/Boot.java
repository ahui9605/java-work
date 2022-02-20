/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leoli
 */
public class Boot extends FishableItem {

    public Boot() {

    }

    @Override
    public void getName() {
        System.out.println(super.name);
    }

    @Override
    public void getPoints() {
        System.out.println(super.points);
    }

    @Override
    public String toString() {
        return "Boot, 0 point";
    }
}
