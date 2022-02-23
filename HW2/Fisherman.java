
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author Zehui Liu
 * @date February 22, 2022
 *
 * This is the fisherman class, use this method to interact with fisherman to
 * fish and print the result
 */
public class Fisherman {

    private String name;
    private ArrayList<FishableItem> bucket;
    private Ocean ocean;

    public Fisherman(String name, Ocean ocean) {
        this.bucket = new ArrayList<>();    //initialize the bucket as an empty ArrayList
        this.name = name;
        this.ocean = ocean;
    }

    /**
     * A method is ready to invoke when fisherman want to fish. When fisherman
     * get a fish, it will use if and else statement to check what kind of fish
     * he get.
     *
     */
    public void fish() {
        System.out.println("Start fishing now");

        FishableItem hooked = ocean.pops();
        if (hooked instanceof Cod) {
            System.out.println("You catch Cod! It's only worth 1 point!");
            bucket.add(hooked);
        } else if (hooked instanceof Salmon) {
            System.out.println("You catch Salmon! Salmon Roll! 3 points!");
            bucket.add(hooked);
        } else if (hooked instanceof GoldenCod) {
            System.out.println("You catch Golden Cod! Holy 10 points!");
            bucket.add(hooked);
        } else if (hooked instanceof TropicalFish) {
            System.out.println("You catch Tropical Fish! Groovy! 5 points");
            bucket.add(hooked);
        } else if (hooked instanceof Boot) {
            System.out.println("You catch Boot! It's totally worthless!");
            bucket.add(hooked);
        }
    }

    /**
     * Invoke this method to check the bucket first by using instanceof
     * operator, then print details on how many point of each fish and the total
     * score.
     *
     */
    public void result() {

        //these varibales are use to record how many fish does fisher get. 
        int Salmon = 0, GoldenCod = 0, TropicalFish = 0, Boot = 0, Cod = 0;

        //check the bucket by using for loop and instanceof for comparison.
        System.out.println("Checking the bucket...");
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i) instanceof Cod) {
                Cod++;
            } else if (bucket.get(i) instanceof GoldenCod) {
                GoldenCod++;
            } else if (bucket.get(i) instanceof TropicalFish) {
                TropicalFish++;
            } else if (bucket.get(i) instanceof Salmon) {
                Salmon++;
            } else if (bucket.get(i) instanceof Boot) {
                Boot++;
            }
        }

        //calculate and print the point on each fish and total score
        int Cod_points = Cod * 1;
        int Salmon_points = Salmon * 3;
        int Tropical_points = TropicalFish * 5;
        int GoldenCod_points = GoldenCod * 10;
        int total_score = Cod_points + Salmon_points + Tropical_points + GoldenCod_points;

        System.out.println("Cod Total: " + Cod + " - " + Cod_points + " pts");
        System.out.println("Salmon Total: " + Salmon + " - " + Salmon_points + " pts");
        System.out.println("Tropical Fish Total: " + TropicalFish + " - " + Tropical_points + " pts");
        System.out.println("Golden Cod Total: " + GoldenCod + " - " + GoldenCod_points + " pts");
        System.out.println("Boot Total: " + Boot + " - " + Boot * 0 + " pts");
        System.out.println("Score: " + total_score);
    }

}
