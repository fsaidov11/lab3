package classes;

import java.util.Objects;

public class Landing {

    abstract class Lander {
        abstract void land();
    }

    private String result;
    private Lander lander;

    public Landing(String result) {
        this.result = result;

        lander = new Lander() {
            @Override
            void land() {
                System.out.println("Landing was " + result);
            }
        };

        lander.land();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object()) * 37;
    }

    @Override
    public String toString() {
        return getClass() + " " + result;
    }
}