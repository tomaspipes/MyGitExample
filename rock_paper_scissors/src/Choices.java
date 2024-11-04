package src;
import java.util.Random;


public enum Choices {
    T,
    R,
    P;

    private static final Choices[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Choices getRandomValue() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
