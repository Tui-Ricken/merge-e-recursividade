package main;

public class Atividade10 {
    public static void main(String[] args) {
        int vetorAux[] = novoArray(100000);
        int vetor1[] = vetorAux.clone();
        int vetor2[] = vetorAux.clone();
        int vetor3[] = vetorAux.clone();
        int vetor4[] = vetorAux.clone();
        long tempoInicio, tempoFinal;
        float duracao;

        tempoInicio = System.nanoTime();
        int[] auxiliar = new int[vetor4.length];
        merge(vetor4, auxiliar, 0, vetor4.length - 1);
        tempoFinal = System.nanoTime();
        duracao = (tempoFinal - tempoInicio) / 1000000;
        System.out.println("Merge Sort : "+ duracao+ " ms");

        tempoInicio = System.nanoTime();
        bubbleSort(vetor1);
        tempoFinal = System.nanoTime();
        duracao = (tempoFinal - tempoInicio) / 1000000;
        System.out.println("Bubble Sort : "+ duracao+ " ms");

        tempoInicio = System.nanoTime();
        insertionSort(vetor2);
        tempoFinal = System.nanoTime();
        duracao = (tempoFinal - tempoInicio) / 1000000;
        System.out.println("Insertion Sort : " + duracao + " ms");

        tempoInicio = System.nanoTime();
        selectionSort(vetor3);
        tempoFinal = System.nanoTime();
        duracao = (tempoFinal - tempoInicio) / 1000000;
        System.out.println("Selection Sort : " + duracao + " ms");

    }

    public static int[] novoArray(int x) {
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
