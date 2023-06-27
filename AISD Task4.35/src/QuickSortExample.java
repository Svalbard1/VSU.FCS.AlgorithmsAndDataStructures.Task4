import java.util.Arrays;

public class QuickSortExample {
    public static void main(String[] args) {
        Integer[] data = {5, 3, 9, 4, 8, 1, 6, 2, 7};
        boolean[] fixed = {false, true, false, false, true, false, false, false, false};

        System.out.println("До сортировки: " + Arrays.toString(data));
        sort(data, fixed);
        System.out.println("После сортировки: " + Arrays.toString(data));
    }

    public static <T extends Comparable<T>> void sort(T[] data, boolean[] fixed) {
        quickSort(data, fixed, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] data, boolean[] fixed, int left, int right) {
        if (left < right) { // проверка выхода из рекурсии в случае если сортировать уже ничего не нужно
            int pivotIndex = partition(data, fixed, left, right);
            quickSort(data, fixed, left, pivotIndex - 1);// вывов для левой подгруппы массива
            quickSort(data, fixed, pivotIndex + 1, right);// вызов для правой подгруппы массива
        }
    }

    private static <T extends Comparable<T>> int partition(T[] data, boolean[] fixed, int left, int right) {
        T pivot = data[right]; // опорка это правый элемент всегда
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (data[j].compareTo(pivot) <= 0) {
                i++;
                swap(data, fixed, i, j); // проверяем элемент меньше или равен опорному и если это так ставим его слева
            }
        }
        swap(data, fixed, i + 1, right); // возвращаем опорку на своё место
        return i + 1; // индекс опорки после разделения
    }

    private static <T> void swap(T[] data, boolean[] fixed, int i, int j) { // функцию обмена элементов в массиве
        if (i == j || fixed[i] || fixed[j]) { // проверка на fixed элеметн
            return;
        }
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}



