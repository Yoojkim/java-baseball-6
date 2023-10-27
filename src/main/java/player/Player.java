package player;

public interface Player {
    public static final int SIZE = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;
    public static final char START_NUMBER = '0';
    public static final int EXIST_SIZE = 10;

    public abstract void setNumbers();
}
