package main;

public class MergeSort {

	public static void main(String[] args) {
		int matriz[][] = { { 2, 1, 4, 5, 3, 7, 8 }, { 2, 1, 4, 5, 3, 7, 9 } };
		mergeSortMatrix(matriz);
		for (int j = 0; j < matriz.length; j++) {
			System.out.println(" ");
			for (int i = 0; i < matriz[j].length; i++) {
				System.out.println(matriz[j][i]);
			}
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

	private static void mergeSortMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			int[] aux = new int[row.length];
			merge(row, aux, 0, row.length - 1);
		}
	}

}