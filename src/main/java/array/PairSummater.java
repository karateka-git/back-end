package array;

import myexception.ArraySummaterException;

public class PairSummater implements IArraySummater {
    public PairSummater() {};
    public int sum(final int[] array) throws ArraySummaterException {
        if (array.length % 2 > 0) {
            throw new ArraySummaterException("Array length is not a multiple of 2");
        }
        int maxPair = 0;
        for (int i = 0; i < array.length; i += 2) {
            int onePair = array[i] + array[i + 1];
            if (onePair > maxPair) {
                maxPair = onePair;
            }
        }
        return maxPair;
    }
}
