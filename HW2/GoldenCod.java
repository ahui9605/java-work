/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author Zehui Liu
 * @date February 22, 2022 
 * A subclass inherits from FishableItem class
 */
public class GoldenCod extends FishableItem {

    public GoldenCod() {
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
        return "Golden Cod, 10 points";
    }
}
