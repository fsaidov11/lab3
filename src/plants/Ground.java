package plants;

import utils.Color;
import utils.GetColor;

import java.util.Objects;

public abstract class Ground implements GetColor {

    protected Color color;

    @Override
    public Color getColor() {
        return Color.BROWN;
    }
}