package classes;

import exceptions.InputTypeException;
import utils.Feelings;
import utils.Location;
import utils.OxygenProvider;
import utils.Color;

import java.util.Objects;

public class SpaceSuit extends Clothes implements OxygenProvider {


    class OxygenStorage {
        private int oxygenSize = 0;

        OxygenStorage(int oxygenSize) {
            this.oxygenSize = oxygenSize;
        }

        public boolean isEmpty() {
            return oxygenSize < 0;
        }

        public int getOxygenSize() {
            return oxygenSize;
        }

        public int getOxygen(int requestedOxygenSize) {
            int providedOxygenSize = Math.min(requestedOxygenSize, oxygenSize);
            oxygenSize -= providedOxygenSize;
            return providedOxygenSize;
        }
    }

    static class SuitVoiceCommander {
        private static String PREFIX = "SuitVoiceCommander: ";

        enum VoiceCommand {
            OPEN_SUIT,
            CLOSE_SUIT,
            UNDEFINED_COMMAND
        }

        public VoiceCommand analyzeCommand(String command) {
            if (command.startsWith("open")) {
                System.out.println(PREFIX + "open suit command was detected");
                return VoiceCommand.OPEN_SUIT;
            }
            if (command.startsWith("close")) {
                System.out.println(PREFIX + "close suit command was detected");
                return VoiceCommand.CLOSE_SUIT;
            }
            System.out.println(PREFIX + "voice command can not be detected");
            return VoiceCommand.UNDEFINED_COMMAND;
        }
    }

    protected Color color;
    protected int size;
    private OxygenStorage oxygenStorage;
    private int oxygenSize;
    private boolean isSuitOpened = false;
    private SuitVoiceCommander suitVoiceCommander;
    private static String PREFIX = "SpaceSuit: ";

    public SpaceSuit(Color color, int size, int oxygenSize) {
        this.color = color;
        this.size = size;
        oxygenStorage = new OxygenStorage(oxygenSize);
        suitVoiceCommander = new SuitVoiceCommander();
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException();
        }
        this.color = color;
    }

    @Override
    public boolean hasOxygen() {
        return !oxygenStorage.isEmpty();
    }

    @Override
    public int getOxygen(int requestedOxygenSize) {
        if (requestedOxygenSize < 0) {
            throw new InputTypeException("int", "Space suit can only give oxygen");
        }

        if (isSuitOpened) {
            return 0;
        }
        return oxygenStorage.getOxygen(requestedOxygenSize);
    }

    public void voiceCommand(String command) {

        switch (suitVoiceCommander.analyzeCommand(command)) {
            case CLOSE_SUIT:
                closeSuit();
                break;
            case OPEN_SUIT:
                openSuit();
                break;
            case UNDEFINED_COMMAND:
                System.out.println(PREFIX + "Undefined command type");
                break;
        }
    }

    public void openSuit() {
        isSuitOpened = true;
        System.out.println(PREFIX + "Opening space suit.");
        System.out.println("It is so " + Feelings.NICE + " to be " + Location.Out + " without space suit. ");
    }

    public void closeSuit() {
        isSuitOpened = false;
        System.out.println(PREFIX + "Closing spacesuit.");
    }

    public boolean isSuitOpened() {
        return isSuitOpened;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceSuit spaceSuit = (SpaceSuit) o;
        return size == spaceSuit.size && color == spaceSuit.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color) * 37 +
                Objects.hash(size) * 37;
    }

    @Override
    public String toString() {
        return "SpaceSuit{" +
                "color=" + color +
                ", size=" + size +
                ", oxygenSize=" + oxygenStorage.getOxygenSize() +
                ", isSuitOpened=" + isSuitOpened +
                '}';
    }
}