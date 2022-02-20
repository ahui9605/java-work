
import java.util.ArrayList;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author leoli
 */
import java.util.Random;

public class Ocean {

    private ArrayList<FishableItem> oceanList;
    ArrayList<Integer> record = new ArrayList();

    public Ocean() {
        this.oceanList = new ArrayList<>();
        addFishes();
    }

    /**
     * This method will automatically add specific number of fishes into the
     * ocean, oceanList
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
    }

    /**
     * This method will generate a random number as an index number to determine
     * which fish can give to fisherman in the ArrayList oceanList. It will
     * shuffle fishes first and let randomNum to pick
     *
     * @return pop, return a fish from randomNum picked.
     */
    public FishableItem pops() {
        Random rand = new Random();

        //random number depends on the size of the oceanList make sure it is not out of bound index
        int randomNum = rand.nextInt(oceanList.size() - 1);

        //fish are constantly moving, User shuffle to keep the fishes index moving around.
        Collections.shuffle(oceanList);
        FishableItem fish = oceanList.get(randomNum);
        oceanList.remove(randomNum);
        return fish;
    }

    public ArrayList<FishableItem> getOceanList() {
        return oceanList;
    }
}

//    public boolean randomNumUsed(int randomNum) {
//        for (int i = 0; i < record.size(); i++) {
//            if (record.get(i) == randomNum) {
//                return true;
//            } else if (record.get(i) != randomNum) {
//                record.add(randomNum);
//                return false;
//            }
//        }
//        return false;
////    }
//

