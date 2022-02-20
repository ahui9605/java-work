
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author leoli
 */
public class main {

    public static void main(String[] args) {
        Ocean ocean = new Ocean();

        //input user name
        Scanner input = new Scanner(System.in);
        System.out.print("Fisherman's name: ");
        String name = input.nextLine();

        Fisherman fisher = new Fisherman(name, ocean);

        //fisher fishes fish ten times
        for (int i = 1; i <= ocean.getOceanList().size(); i++) {
            System.out.println("Fishing... (Please enter)");
            input.nextLine();
            fisher.fish();

            if (i == 10) {
                System.out.println("---------------------------------------");
                //output the final score.
                fisher.result();
                System.out.println("Do you want to continue? (y or n)");
                String answer = input.nextLine();
                if (answer.equals("n")) {
                    break;
                }
            }
        }
        //final result after fishing 100 fish.
        System.out.println("---------------------------------------");
        fisher.result();
    }

}
