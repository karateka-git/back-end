package array;

import myexception.ArraySummaterException;

final class SimpleSummater implements IArraySummater {

    public SimpleSummater() {}

    public int sum(final int[] array) throws ArraySummaterException {
        int sumElement = 0;
        for (int element : array) {
            sumElement += element;
        }
        return sumElement;
    }
}
