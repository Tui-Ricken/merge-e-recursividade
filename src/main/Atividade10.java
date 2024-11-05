package main;

public class Atividade10 {
    public static void main(String[] args) {
        
        int vetor1[] = generateArray(1000000);
        int vetor2[] = generateArray(1000000);
        int vetor3[] = generateArray(1000000);
        int vetor4[] = generateArray(1000000);
        long startTime, endTime;
        float duration;

        startTime = System.nanoTime();
        int[] auxiliar = new int[vetor4.length];
        merge(vetor4, auxiliar, 0, vetor4.length - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.printf("Merge Sort took: "+ duration+ " ms");

        startTime = System.nanoTime();
        bubbleSort(vetor1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.printf("Bubble Sort took: ", duration+ " ms");

        startTime = System.nanoTime();
        insertionSort(vetor2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("Insertion Sort took: " + duration + " ms");

        startTime = System.nanoTime();
        selectionSort(vetor3);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("Selection Sort took: " + duration + " ms");

    }

    public static int[] generateArray(int x) {
        int[] array = new int[x];
        for (int i = 0; i < x; i++) {
            array[i] = (int) (Math.random() * x);
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    private static void merge(int vetor[], int auxiliar[], int inicio, int fim) {
        if (inicio < fim) {

            int meio = (inicio + fim) / 2;
            // System.out.println("MERGE i:"+inicio+" m:"+meio);
            merge(vetor, auxiliar, inicio, meio);
            // System.out.println("MERGE m:"+(meio+1)+" f:"+fim);
            merge(vetor, auxiliar, meio + 1, fim);
            intercalacao(vetor, auxiliar, inicio, meio, fim);
        }
    }

    private static void intercalacao(int[] vetor, int[] auxiliar, int inicio,
            int meio, int fim) {

        for (int x = inicio; x <= fim; x++) {
            auxiliar[x] = vetor[x];
        }
        int esquerda = inicio;
        int direita = meio + 1;

        for (int x = inicio; x <= fim; x++) {
            if (esquerda > meio) {
                vetor[x] = auxiliar[direita++];
            } else if (direita > fim) {

                vetor[x] = auxiliar[esquerda++];
            } else if (auxiliar[esquerda] < auxiliar[direita]) {

                vetor[x] = auxiliar[esquerda++];
            } else {

                vetor[x] = auxiliar[direita++];
            }
        }

    }
}
