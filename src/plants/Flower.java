package plants;

import exceptions.InputTypeException;
import plants.Plant;
import utils.Color;
import utils.Feelings;

import java.util.Objects;

public class Flower extends Plant {

    public static final int STANDARD_FLOWER_HIGH_CM = 50;
    private int flowerAge;

    public Flower(Color color, int high) {
        this.color = color;
        this.high = high;
        flowerAge = 0;
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
        if (days < 0) {
            throw new InputTypeException("int", " number of days can't be negative");
        }

        class FlowerGrow {
            public int grow(int growingDays) {
                if (growingDays > 30) {
                    System.out.println("and are blossoming between the " + Color.GREEN + " grass ");
                    System.out.println();
                } else {
                    System.out.println(" Flowers are waking up after winter. ");
                }
                return flowerAge + growingDays;
            }
        }

        FlowerGrow flowerGrow = new FlowerGrow();
        flowerAge = flowerGrow.grow(days);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Flower flower = (Flower) o;
        return high == flower.high && color == flower.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color) * 37 +
                Objects.hash(high) * 37;
    }

    @Override
    public String toString() {
        return "Flower {" +
                "color = " + color +
                ", high = " + high +
                '}';
    }
}
