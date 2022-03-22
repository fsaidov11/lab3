package classes;

import utils.Feelings;
import utils.Location;
import utils.OxygenProvider;
import utils.Color;

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
        System.out.println(" With space suit. ");
    }

    public void closeSuit() {
        isSuitOpened = false;
        System.out.println("It is so " + Feelings.NICE + " to be " + Location.Out + " without space suit. ");
    }

    public boolean isSuitOpened() {
        return isSuitOpened;
    }
}
