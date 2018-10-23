import array.PairSummater;
import myexception.ArraySummaterException;

public class Main {
    private static int[] mas = { 17, 14, 13, 15};
    public static void main(final String[] args) {
        PairSummater ps = new PairSummater();
        try {
            System.out.println(ps.sum(mas));
        } catch (ArraySummaterException e) {
            System.out.println(e.getMessage());
        }
    }
}
