
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author leoli
 */
public class Fisherman {

    private String name;
    private Ocean ocean;
    private ArrayList<FishableItem> bucket;

    //it is use to print how many fishes does fisher got in the bucket.
    private int Salmon = 0, GoldenCod = 0, TropicalFish = 0, Boot = 0, Cod = 0;

    public Fisherman(String name, Ocean ocean) {
        this.name = name;
        this.ocean = ocean;
        this.bucket = new ArrayList<>();    //initialize the ArrayList
    }

    public void fish() {
        FishableItem hooked = ocean.pops();
        System.out.println("Start fishing now");
        if (hooked instanceof Cod) {
            System.out.println("You catch Cod! It's only worth 1 point!");
            bucket.add(hooked);
            Cod++;
        } else if (hooked instanceof Salmon) {
            System.out.println("You catch Salmon! Salmon Roll! 3 points!");
            bucket.add(hooked);
            Salmon++;
        } else if (hooked instanceof GoldenCod) {
            System.out.println("You catch Golden Cod! Holy 10 points!");
            bucket.add(hooked);
            GoldenCod++;
        } else if (hooked instanceof TropicalFish) {
            System.out.println("You catch Tropical Fish! Groovy! 5 points");
            bucket.add(hooked);
            TropicalFish++;
        } else if (hooked instanceof Boot) {
            System.out.println("You catch Boot! It's totally worthless!");
            bucket.add(hooked);
            Boot++;
        }

    }

    public void result() {
        System.out.println("Checking the bucket...");

        System.out.println("Cod Total: " + Cod + " - " + Cod * 1 + " pts");
        System.out.println("Salmon Total: " + Salmon + " - " + Salmon * 3 + " pts");
        System.out.println("Tropical Fish Total: " + TropicalFish + " - " + TropicalFish * 5 + " pts");
        System.out.println("Golden Cod Total: " + GoldenCod + " - " + GoldenCod * 10 + " pts");
        System.out.println("Boot Total: " + Boot + " - " + Boot * 0 + " pts");

        int score = (Cod * 1) + (Salmon * 3) + (TropicalFish * 5) + (GoldenCod * 10) + (Boot * 0);
        System.out.println("Score: " + score);
    }

}
