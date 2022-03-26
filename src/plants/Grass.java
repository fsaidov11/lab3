package plants;

import exceptions.InputTypeException;
import utils.Color;
import utils.Feelings;

import java.util.Objects;

public class Grass extends Plant {

    private final Color color;
    private int high;

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
        if (days < 0) {
            throw new InputTypeException("int", "number of days can't be negative");
        }
    }

    @Override
    public void doSmell() {
        System.out.println(" smelling " + Feelings.FRESH + "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Grass grass = (Grass) o;
        return high == grass.high && color == grass.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color) * 37 +
                Objects.hash(high) * 37;
    }

    @Override
    public String toString() {
        return "Grass {" +
                "color = " + color +
                ", high = " + high +
                '}';
    }
}