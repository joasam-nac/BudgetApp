public class IdHandler {
    private static int counter = 0;

    public static int getNextId() {
        return counter++;
    }

    public static void reset(){
        counter = 0;
    }
}
