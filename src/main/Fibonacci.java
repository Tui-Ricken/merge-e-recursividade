package main;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        System.out.println("Digite o numero da sequencia que vc quer em fibonacci: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibonacci = generateFibonacci(n);
        for (int i = 0; i < fibonacci.length; i++) {
            System.out.print(fibonacci[i] + " ");
        }

    }
    public static int[] generateFibonacci(int n) {
        int[] fibonacci = new int[n];
        if (n > 0) {
            fibonacci[0] = 0;
        }
        if (n > 1) {
            fibonacci[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        System.out.println("Numero "+ fibonacci[fibonacci.length-1] + " ta na sequencia de fibonacci na casa: "+ fibonacci.length);
        return fibonacci;
    }
}
