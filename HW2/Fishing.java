
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author Zehui Liu
 * @date February 22, 2022
 *
 * This is This is the main class to call other classes, start to fish ten times
 * and then display the result
 */
public class Fishing {

    public static void main(String[] args) {
        Ocean ocean = new Ocean();

        //input user name and initialize the fisher with the user name and the ocean where he located at
        Scanner input = new Scanner(System.in);
        System.out.print("Fisherman's name: ");
        String name = input.nextLine();
        Fisherman fisher = new Fisherman(name, ocean);

        //an for loop to continue to fish ten times
        for (int i = 1; i <= 10; i++) {
            System.out.print("Fishing... (Please enter)");
            input.nextLine();
            fisher.fish();

        }
        fisher.result();
    }
}
