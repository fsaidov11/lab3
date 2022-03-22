package classes;

import utils.GetColor;
import utils.Color;

public abstract class Clothes implements GetColor {
    protected Color color;
    private int size;

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
