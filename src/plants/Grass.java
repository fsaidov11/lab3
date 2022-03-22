package plants;

import utils.Color;
import utils.Feelings;

public class Grass extends Plant {

    private final Color color;

    public Grass(Color color, int high) {
        this.color = color;
        this.high = high;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getHigh() {
        return high;
    }

    @Override
    public void grow(int days) {

    }

    @Override
    public void doSmell() {
        System.out.println(" smelling " + Feelings.FRESH + "");
    }
}
