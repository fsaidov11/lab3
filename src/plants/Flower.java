package plants;

import plants.Plant;
import utils.Color;
import utils.Feelings;

public class Flower extends Plant {

    public static final int STANDARD_FLOWER_HIGH_CM = 50;

    public Flower(Color color, int high) {
        this.color = color;
        this.high = high;

    }

    @Override
    public void doSmell() {
        System.out.println("Flowers smell so " + Feelings.PLEASANT);
    }

    @Override
    public int getHigh() {
        return high;
    }

    @Override
    public void grow(int days) {
        if (days > 30) {
            System.out.println("and are blossoming between the " + Color.GREEN + " grass ");
            System.out.println();
        } else {
            System.out.println(" Flowers are waking up after winter. ");
        }
    }
}
