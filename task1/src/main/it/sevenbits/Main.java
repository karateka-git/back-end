package main.it.sevenbits;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        double MaxInterval = 0;
        Interval ArrayInterval[] = new Interval[5];

        ArrayInterval[0] = new Interval(new Point(3,2), new Point(7,8));
        ArrayInterval[1] = new Interval(new Point(4,1), new Point(10, 15));
        ArrayInterval[2] = new Interval(new Point(2,3), new Point(6, 11));
        ArrayInterval[3] = new Interval(new Point(1,5), new Point(12, 10));
        ArrayInterval[4] = new Interval(new Point(5,4), new Point(15, 11));

        for (Interval element: ArrayInterval) {
            i++;
            System.out.format("Длина отрезка %d = %f%n", i, element.getSegment());
            if (MaxInterval < element.getSegment()) {
                MaxInterval = element.getSegment();
            }
        }
        System.out.format("Максимальная длина = %f", MaxInterval);
    }
}
