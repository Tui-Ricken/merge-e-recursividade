package main;

public class SomaArray {
    public static void main(String[] args){
        int total = 0;
        int[] numeros = {4,3,2,4};
        int x=soma(numeros, 0,numeros.length-1,total);
        System.out.println(x);
    }
    private static int soma(int vetor[],int inicio,int fim,int total){
        System.out.println(fim+"--"+inicio);
        if(inicio<fim){
            total=total+vetor[inicio]+vetor[fim];
            return soma(vetor,inicio+1,fim-1,total);    
        }
        return total;
}
}
