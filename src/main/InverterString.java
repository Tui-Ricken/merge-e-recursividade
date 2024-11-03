package main;

public class InverterString {
    public static void main(String[] args) {
        String palavra = "oval";
        StringBuilder palavra2 = new StringBuilder(palavra);
        String inverter = inverter(palavra, palavra2, 0, palavra.length() - 1);
        System.out.println(inverter);
    }

    public static String inverter(String palavra, StringBuilder palavra2, int inicio, int fim) { 
        if(inicio>palavra.length() && fim<0){
            return "";
        }else{
        palavra2.setCharAt(fim, palavra.charAt(inicio));
        return inverter(palavra, palavra2, inicio+1, fim-1);
        }   
}
}
