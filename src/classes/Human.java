package classes;


import plants.Flower;

public abstract class Human {
    private String name;
    private Clothes clothes;

    public Human(String name, Clothes clothes) {
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
        this.name = name;
    }

    public abstract boolean isComfortable();

}
