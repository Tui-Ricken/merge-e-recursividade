package main;

public class SomaDeCaracterDeUmInteiro {

    public static void main(String[] args) {
        
        int x=somaDigitos(21);
        System.out.println(x);
    }
    public static int somaDigitos(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + somaDigitos(n / 10);
}
}
