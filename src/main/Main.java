package main;

import classes.Landing;
import classes.Person;
import classes.SpaceSuit;
import plants.Grass;
import plants.Flower;
import utils.Color;

public class Main {

    public static void main(String[] args) {
        SpaceSuit spaceSuit = new SpaceSuit(Color.WHITE, 7, 0);
        Flower flower = new Flower(Color.RED, 10);
        Person cosmonauts = new Person("Cosmonauts", spaceSuit);
        Grass grass = new Grass(Color.GREEN, 2);
        cosmonauts.joinStory();
        new Landing("successful");
        cosmonauts.comeOut();
        cosmonauts.shout(3);
        cosmonauts.setName("Travelers");
        cosmonauts.stepOn(grass);
        spaceSuit.openSuit();
        cosmonauts.breath();
        flower.doSmell();
        flower.grow(50);
        cosmonauts.noticeFlower(flower);
        cosmonauts.laugh();
        System.out.println(cosmonauts);
        System.out.println(flower);
        System.out.println(grass);
    }
}