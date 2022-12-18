package utils;

public interface OxygenProvider {
    boolean hasOxygen();

    int getOxygen(int requestedOxygenSize);
}
