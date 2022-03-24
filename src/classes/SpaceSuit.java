package classes;

import utils.Feelings;
import utils.Location;
import utils.OxygenProvider;
import utils.Color;

import java.util.Objects;

public class SpaceSuit extends Clothes implements OxygenProvider {
    protected Color color;
    protected int size;
    private int oxygenSize;
    private boolean isSuitOpened = false;

    public SpaceSuit(Color color, int size, int oxygenSize) {
        this.color = color;
        this.size = size;
        this.oxygenSize = oxygenSize;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean hasOxygen() {
        return oxygenSize > 0;
    }

    @Override
    public int getOxygen(int requestedOxygenSize) {
        //TODO check input
        if (isSuitOpened) {
            return 0;
        }
        int providedOxygenSize = Math.min(requestedOxygenSize, oxygenSize);
        oxygenSize -= providedOxygenSize;
        return providedOxygenSize;
    }

    public void openSuit() {
        isSuitOpened = true;
        System.out.println("Opening space suit.");
        System.out.println("It is so " + Feelings.NICE + " to be " + Location.Out + " without space suit. ");
    }

    public void closeSuit() {
        isSuitOpened = false;
        System.out.println("Closing spacesuit.");
    }

    public boolean isSuitOpened() {
        return isSuitOpened;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceSuit spaceSuit = (SpaceSuit) o;
        return size == spaceSuit.size && color == spaceSuit.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color) * 37 +
                Objects.hash(size) * 37;
    }

    @Override
    public String toString() {
        return "SpaceSuit{" +
                "color=" + color +
                ", size=" + size +
                ", oxygenSize=" + oxygenSize +
                ", isSuitOpened=" + isSuitOpened +
                '}';
    }
}
