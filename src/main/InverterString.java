package main;

public class InverterString {
    public static void main(String[] args) {
        String palavra = "oval";
        inverter(palavra,0,palavra.length()-1);
        
    }
    public static String inverter(String palavra, int inicio,int fim) { 
        char[] letras = palavra.toCharArray();
        char[] letrasInvertidas = new char[letras.length];
        if (inicio<letras.length && fim>=0) {
            letrasInvertidas[inicio]=letras[fim];
            System.out.print(letrasInvertidas[inicio]);
            return inverter(palavra,inicio+1,fim-1);
        }
        return "";
}
}
