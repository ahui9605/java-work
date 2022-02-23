
import java.util.ArrayList;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author Zehui Liu
 * @date February 22, 2022
 *
 * This is the ocean class that generate a particular area of ocean to allow
 * fisherman to fish. Ocean generates limited number of fish and resources.
 */
import java.util.Random;

public class Ocean {

    private ArrayList<FishableItem> oceanList;

    public Ocean() {
        this.oceanList = new ArrayList<>();
        addFishes();
    }

    /**
     * This method will automatically add some fish in the oceanList
     *
     */
    public void addFishes() {
        // a loop that add five kind of fishes into the ArrayList oceanList.
        for (int i = 0; i < 30; i++) {
            this.oceanList.add(new Boot());
            this.oceanList.add(new Cod());

            if (i < 20) {
                this.oceanList.add(new Salmon());
            }
            if (i < 15) {
                this.oceanList.add(new TropicalFish());
            }
            if (i < 5) {
                this.oceanList.add(new GoldenCod());
            }
        }
        // shuffle for providing "randomness" in the oceanList.
        Collections.shuffle(oceanList);
    }

    /**
     * This method will generate a random number as an index number to determine
     * which fish can give to fisherman in an ArrayList, oceanList.
     *
     * @return pop, return a fish from randomNum picked.
     */
    public FishableItem pops() {
        Random rand = new Random();

        //random number depends on the size of the oceanList make sure it is not out of bound index
        int randomNum = rand.nextInt(oceanList.size() - 1);
        FishableItem fish = oceanList.get(randomNum);
        oceanList.remove(randomNum);
        return fish;
    }
}
