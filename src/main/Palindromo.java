package main;

public class Palindromo {
    public static void main(String[] args) {
        String palavra = "arara";
        System.out.println(palindromo(palavra, 0, palavra.length() - 1));
    }

    private static boolean palindromo(String palavra, int inicio, int fim) {
        System.out.println(inicio+"--"+fim);
        
        if (inicio < fim) {
            if (palavra.charAt(inicio) == palavra.charAt(fim)) {
                return palindromo(palavra, inicio+1, fim-1);
            }else{
                return false;
            }

        }
        return true;
    }
}
;