package main;

public class MergeSortObject {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa(21, "Maria");
        Pessoa pessoa2 = new Pessoa(20, "Joao");
        Pessoa pessoas[] = { pessoa1, pessoa2 };
        Pessoa auxiliar[] = new Pessoa[pessoas.length];
        mergeObjeto(pessoas, auxiliar, 0, pessoas.length - 1);
        for (int i = 0; i < pessoas.length; i++) {
            if (i < pessoas.length - 1) {
                System.out.print("{(" + pessoas[i].nome + ",");
                System.out.print(pessoas[i].idade + "),");
            }else{
                System.out.print("(" + pessoas[i].nome + ",");
                System.out.print(pessoas[i].idade + ")}");
            }
        }
    }

    private static void mergeObjeto(Pessoa vetor[], Pessoa auxiliar[], int inicio, int fim) {
        if (inicio < fim) {

            int meio = (inicio + fim) / 2;
            //System.out.println("MERGE i:" + inicio + " m:" + meio);
            mergeObjeto(vetor, auxiliar, inicio, meio);
           //System.out.println("MERGE m:" + (meio + 1) + " f:" + fim);
            mergeObjeto(vetor, auxiliar, meio + 1, fim);
            intercalacao(vetor, auxiliar, inicio, meio, fim);
        }
    }

    private static void intercalacao(Pessoa[] vetor, Pessoa[] auxiliar, int inicio,
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
            } else if (auxiliar[esquerda].idade < auxiliar[direita].idade) {

                vetor[x] = auxiliar[esquerda++];
            } else {

                vetor[x] = auxiliar[direita++];
            }
        }

    }
}
