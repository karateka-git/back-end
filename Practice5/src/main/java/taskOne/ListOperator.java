package taskOne;
import java.util.List;

public class ListOperator<T extends Comparable<T>> {
    private T max;

    private int compareTo(final T element) {
        return max.compareTo(element);
    }

    public T max(final List<T> list, final int start, final int finish) {
        max = list.get(start);
        for (int i = start; i <= finish; i++) {
            if (0 > compareTo(list.get(i))) {
                max = list.get(i);
            }
        }
        return max;
    }


    public void changeElementsPosition(final List<T> list, final int numberOne, final int numberTwo) {
        T firstElement;
        T secondElement;

        firstElement = list.get(numberOne);
        secondElement = list.get(numberTwo);

        list.set(numberOne, secondElement);
        list.set(numberTwo, firstElement);
    }

    public String toString(final List<T> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (T element: list) {
            stringBuilder.append(element.toString()).append(' ');

        }
        return stringBuilder.toString();
    }
}
