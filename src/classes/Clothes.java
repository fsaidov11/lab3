package classes;

import exceptions.InputTypeException;
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
        if (color == null) {
            throw new InputTypeException("Color", "Color null can't be set as clothes color");
        }
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "color=" + color +
                ", size=" + size +
                '}';
    }
}