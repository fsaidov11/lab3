package plants;

import utils.Color;
import utils.GetColor;


public abstract class Ground implements GetColor {

    protected Color color;

    @Override
    public Color getColor() {
        return Color.BROWN;
    }
}
