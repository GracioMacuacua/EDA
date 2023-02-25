package src.ordenacao;

public class MergeSort {

    public static void mergeSort(Object[] a) {
        Comparable[] tmpArray = new Comparable[a.length];
        Comparable[] aAux = (Comparable[]) a;
        mergeSort(aAux, tmpArray, 0, a.length - 1);
    }

    /**
     * Método interno que faz chamadas recursivas
     */
    private static void mergeSort(Comparable[] a, Comparable[] tmpArray,
            int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    /**
     * Metódo interno que ordena duas partes de um sub-array.
     */
    private static void merge(Comparable[] a, Comparable[] tmpArray,
            int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // loop principal
        while (leftPos <= leftEnd && rightPos <= rightEnd)
            if (a[leftPos].compareTo(a[rightPos]) <= 0)
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];

        while (leftPos <= leftEnd)
            tmpArray[tmpPos++] = a[leftPos++];

        while (rightPos <= rightEnd)
            tmpArray[tmpPos++] = a[rightPos++];

        // Copiando o array temporário de volta
        for (int i = 0; i < numElements; i++, rightEnd--)
            a[rightEnd] = tmpArray[rightEnd];
    }

}
