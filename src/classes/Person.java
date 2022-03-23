package classes;

import com.sun.istack.internal.Nullable;
import plants.Grass;
import plants.Flower;
import utils.Feelings;
import utils.Location;

import java.util.Objects;

public class Person extends Human {

    private String name;
    private Location location;
    private Clothes clothes;
    private static final int OXYGEN_NORMAL_AMOUNT = 10;


    public Person(String name, Clothes clothes) {
        super(name, clothes);
    }

    @Override
    public boolean isComfortable() {
        return clothes != null &&
                clothes.getSize() > 6 &&
                clothes.getSize() < 10;
    }

    @Override
    public void checkLocation() {
        System.out.println(location);
    }

    public void setLocation(@Nullable Location location) {
        this.location = location;
    }

    @Override
    public void comeOut() {
        System.out.println("The " + name + " left the " + Location.Cabin + " one by one and, ");
    }

    @Override
    public void shout(int times) {
        System.out.println("holding hands shouted \"Hurrah\" " + times + " times. ");
    }

    @Override
    public void noticeFlower(Flower flower) {
        if (flower.getHigh() < Flower.STANDARD_FLOWER_HIGH_CM) {
            System.out.println(getName() + " are " + Feelings.AMAZED + " that both grass and flowers were " + Feelings.SURPRISINGLY + " tiny and undersized ");
            System.out.println(" In order to see the flowers, one have to squat down.");
        }
    }

    @Override
    public void laugh() {
        System.out.println(" The situation made " + getName() + " laugh.");
    }

    public void breath() {
        if (clothes != null) {
            if (clothes instanceof SpaceSuit) {
                SpaceSuit spaceSuit = (SpaceSuit) clothes;
                if (!spaceSuit.isSuitOpened()) {
                    if (spaceSuit.hasOxygen()) {
                        int receivedOxygen = spaceSuit.getOxygen(OXYGEN_NORMAL_AMOUNT);
                        System.out.println("Got non - fresh oxygen from spacesuit");
                        if (receivedOxygen >= OXYGEN_NORMAL_AMOUNT) {
                            //мы получили нужный объём кислорода
                            return;
                        } else {
                            System.out.println("Oxygen was not enough.");
                            spaceSuit.openSuit();
                        }
                    } else {
                        System.out.println("No oxygen left in spacesuit.");
                        spaceSuit.openSuit();
                    }
                }
            }
        }
        System.out.println("Breathing fresh air.");
    }

    public void stepOn(@Nullable Grass grass) {
        System.out.println(name + " stepping on " + grass.getColor() + " grass, ");
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "name = " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

