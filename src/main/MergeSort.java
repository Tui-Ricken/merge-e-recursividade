package main;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		System.out.println("Início");
		int vetor[] = { 2,1,4,5,3,7,8 };
		int auxiliar[] = new int[vetor.length];
		merge(vetor, auxiliar, 0, vetor.length-1);
		System.out.println(Arrays.toString(vetor));
		
	}

	private static void merge(int vetor[], int auxiliar[], int inicio, int fim) {
		if (inicio < fim) {
			
			int meio = (inicio + fim) / 2;
			System.out.println("MERGE i:"+inicio+" m:"+meio);
			merge(vetor, auxiliar, inicio, meio);
			System.out.println("MERGE m:"+(meio+1)+" f:"+fim);
			merge(vetor, auxiliar, meio + 1, fim);
			intercalacao(vetor, auxiliar, inicio, meio, fim);
		}
	}

	private static void intercalacao(int[] vetor, int[] auxiliar, int inicio,
			int meio, int fim) {
		System.out.println("Intercalação i:"+inicio+" m:"+meio+" f:"+fim);
		for (int x = inicio; x <= fim; x++) {
			auxiliar[x] = vetor[x];
		}
		int esquerda = inicio;
		int direita = meio + 1;

		for (int x = inicio; x <= fim; x++) {
			if (esquerda > meio) {
				System.out.println("não existe esquerda");
				vetor[x] = auxiliar[direita++];
			} else if (direita > fim) {
				System.out.println("não existe direita");
				vetor[x] = auxiliar[esquerda++];
			} else if (auxiliar[esquerda] < auxiliar[direita]) {
				System.out.println("copiando da esquerda");
				vetor[x] = auxiliar[esquerda++];
			} else {
				System.out.println("copiando da direita");
				vetor[x] = auxiliar[direita++];
			}
		}
System.out.println(Arrays.toString(vetor));
	}

}