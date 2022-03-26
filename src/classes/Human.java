package classes;


import exceptions.FirstClothesException;
import exceptions.InputTypeException;
import plants.Flower;

import java.util.Objects;

public abstract class Human {
    protected String name;
    protected Clothes clothes;

    public Human(String name, Clothes clothes) throws FirstClothesException {
        if (clothes == null) {
            throw new FirstClothesException("Human can't be nacked");
        }
        this.clothes = clothes;
        this.name = name;
    }


    public void joinStory() {
        System.out.println(this.name + " joined the story");
    }

    public abstract void checkLocation();

    public abstract void comeOut();

    public abstract void shout(int times);

    public abstract void noticeFlower(Flower flower);

    public abstract void laugh();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InputTypeException("String", "name of Human can't be null or empty");
        }
        this.name = name;
    }

    public abstract boolean isComfortable();

}
