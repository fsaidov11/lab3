package classes;

import java.util.Objects;

public class Landing {

    private String result;

    public Landing(String result)
    {
        this.result = result;
        System.out.println("Landing was " + result);
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