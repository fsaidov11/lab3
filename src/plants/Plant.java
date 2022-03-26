package plants;

import utils.Color;
import utils.DoSmell;
import utils.GetColor;

import java.util.Objects;

public abstract class Plant implements DoSmell, GetColor {
    protected int high;
    protected Color color;

    @Override
    public Color getColor() {
        return color;
    }

    public abstract int getHigh();

    public abstract void grow(int days);
}