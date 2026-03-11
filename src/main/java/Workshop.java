import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Workshop {

    public int sumarDosNumeros(int a, int b) {
        return a + b;
    }

    public int mayorDeTresNumeros(int a, int b, int c) {
        int tmp;
        if(a > b){ tmp = a; } else { tmp = b; }
        if(c > tmp){ tmp = c; }
        return tmp;
    }

    public int[] tablaMultiplicar(int numero, int limite) {
        int arr[] = new int[limite];
        int i = 0;
        while(i < limite){ arr[i] = numero * (i+1); i++; }
        return arr;
    }

    public long factorial(int n) {
        if(n < 0) throw new IllegalArgumentException("no puede ser negativo");
        long res = 1;
        for(int i = 2; i <= n; i++) res *= i;
        return res;
    }

    public boolean esPrimo(int numero) {
        if(numero <= 1) return false;
        if(numero == 2) return true;
        for(int i = 2; i <= numero-1; i++){
            if(numero % i == 0) return false;
        }
        return true;
    }

    public int[] serieFibonacci(int n) {
        if(n < 0) throw new IllegalArgumentException("n no puede ser negativo");
        int[] fib = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0) fib[0] = 0;
            else if(i == 1) fib[1] = 1;
            else fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }

    public int sumaElementos(int[] arreglo) {
        int total = 0;
        for(int i = 0; i < arreglo.length; i++) total += arreglo[i];
        return total;
    }

    public double promedioElementos(int[] arreglo) {
        int sum = 0;
        for(int x : arreglo) sum += x;
        return (double)sum / arreglo.length;
    }

    public int encontrarElementoMayor(int[] arreglo) {
        int max = arreglo[0];
        for(int i = 1; i < arreglo.length; i++){
            if(arreglo[i] > max) max = arreglo[i];
        }
        return max;
    }

    public int encontrarElementoMenor(int[] arreglo) {
        int min = arreglo[0];
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i] < min) min = arreglo[i];
        }
        return min;
    }

    public boolean buscarElemento(int[] arreglo, int elemento) {
        boolean encontrado = false;
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i] == elemento) encontrado = true;
        }
        return encontrado;
    }

    public int[] invertirArreglo(int[] arreglo) {
        int n = arreglo.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) res[i] = arreglo[n-1-i];
        return res;
    }

    public int[] ordenarArreglo(int[] arreglo) {
        int[] copia = new int[arreglo.length];
        for(int i = 0; i < arreglo.length; i++) copia[i] = arreglo[i];
        for(int i = 0; i < copia.length-1; i++){
            for(int j = 0; j < copia.length-1-i; j++){
                if(copia[j] > copia[j+1]){
                    int aux = copia[j];
                    copia[j] = copia[j+1];
                    copia[j+1] = aux;
                }
            }
        }
        return copia;
    }

    public int[] eliminarDuplicados(int[] arreglo) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i = 0; i < arreglo.length; i++){
            boolean yaEsta = false;
            for(int j = 0; j < lista.size(); j++){
                if(lista.get(j) == arreglo[i]){ yaEsta = true; break; }
            }
            if(!yaEsta) lista.add(arreglo[i]);
        }
        int[] resultado = new int[lista.size()];
        for(int i = 0; i < lista.size(); i++) resultado[i] = lista.get(i);
        return resultado;
    }

    public int[] combinarArreglos(int[] arreglo1, int[] arreglo2) {
        int[] nuevo = new int[arreglo1.length + arreglo2.length];
        for(int i = 0; i < arreglo1.length; i++) nuevo[i] = arreglo1[i];
        for(int i = 0; i < arreglo2.length; i++) nuevo[arreglo1.length + i] = arreglo2[i];
        return nuevo;
    }

    public int[] rotarArreglo(int[] arreglo, int posiciones) {
        if(arreglo.length == 0) return arreglo;
        int n = arreglo.length;
        int rot = ((posiciones % n) + n) % n;
        int[] rotado = new int[n];
        for(int i = 0; i < n; i++) rotado[(i + rot) % n] = arreglo[i];
        return rotado;
    }

    public int contarCaracteres(String cadena) {
        return cadena.length();
    }

    // swap manual de chars para manejar bien surrogate pairs
    public String invertirCadena(String cadena) {
        char[] arr = cadena.toCharArray();
        int l = 0, r = arr.length - 1;
        while(l < r){
            char t = arr[l]; arr[l] = arr[r]; arr[r] = t;
            l++; r--;
        }
        return new String(arr);
    }

    public boolean esPalindromo(String cadena) {
        String s = cadena.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }

    // split por cualquier caracter que no sea letra o numero
    public int contarPalabras(String cadena) {
        if(cadena == null || cadena.trim().length() == 0) return 0;
        return cadena.trim().split("[^a-zA-Z0-9\u00C0-\u024F']+").length;
    }

    public String convertirAMayusculas(String cadena) {
        return cadena.toUpperCase();
    }

    public String convertirAMinusculas(String cadena) {
        return cadena.toLowerCase();
    }

    public String reemplazarSubcadena(String cadena, String vieja, String nueva) {
        return cadena.replace(vieja, nueva);
    }

    public int buscarSubcadena(String cadena, String subcadena) {
        return cadena.indexOf(subcadena);
    }

    public boolean validarCorreoElectronico(String correo) {
        if(correo == null || correo.length() == 0) return false;
        return correo.matches("^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$");
    }

    public double promedioLista(List<Integer> lista) {
        if(lista == null || lista.size() == 0) return 0.0;
        int suma = 0;
        for(int i = 0; i < lista.size(); i++) suma += lista.get(i);
        return (double) suma / lista.size();
    }

    public String convertirABinario(int numero) {
        if(numero < 0) return "-" + Integer.toBinaryString(-numero);
        return Integer.toBinaryString(numero);
    }

    public String convertirAHexadecimal(int numero) {
        if(numero < 0) return "-" + Integer.toHexString(-numero).toUpperCase();
        return Integer.toHexString(numero).toUpperCase();
    }

    // normaliza español e ingles para las jugadas
    private String normalizar(String jugada) {
        String j = jugada.toLowerCase().trim();
        if(j.equals("rock")) return "piedra";
        if(j.equals("paper")) return "papel";
        if(j.equals("scissors")) return "tijera";
        if(j.equals("lizard")) return "lagarto";
        return j;
    }

    private boolean gana(String a, String b) {
        if(a.equals("piedra") && (b.equals("tijera") || b.equals("lagarto"))) return true;
        if(a.equals("papel") && (b.equals("piedra") || b.equals("spock"))) return true;
        if(a.equals("tijera") && (b.equals("papel") || b.equals("lagarto"))) return true;
        if(a.equals("lagarto") && (b.equals("papel") || b.equals("spock"))) return true;
        if(a.equals("spock") && (b.equals("piedra") || b.equals("tijera"))) return true;
        return false;
    }

    public String jugarPiedraPapelTijeraLagartoSpock(String eleccion) {
        String[] jugadas = {"piedra", "papel", "tijera", "lagarto", "spock"};
        String maquina = jugadas[new Random().nextInt(jugadas.length)];
        String e = normalizar(eleccion);
        if(e.equals(maquina)) return "Empate";
        return gana(e, maquina) ? "Ganaste" : "Perdiste";
    }

    public String pptls2(String[] game) {
        String jug1 = normalizar(game[0]);
        String jug2 = normalizar(game[1]);
        if(jug1.equals(jug2)) return "Empate";
        return gana(jug1, jug2) ? "Player 1" : "Player 2";
    }

    public double areaCirculo(double radio) {
        return Math.PI * radio;
    }

    public String zoodiac(int day, int month) {
        if(month < 1 || month > 12 || day < 1) return "Invalid Date";
        int[] diasPorMes = {31,29,31,30,31,30,31,31,30,31,30,31};
        if(day > diasPorMes[month - 1]) return "Invalid Date";
        if((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Aries";
        if((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Tauro";
        if((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "Gemini";
        if((month == 6 && day >= 21) || (month == 7 && day <= 22)) return "Cancer";
        if((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "Leo";
        if((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "Virgo";
        if((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "Libra";
        if((month == 10 && day >= 23) || (month == 11 && day <= 21)) return "Escorpio";
        if((month == 11 && day >= 22) || (month == 12 && day <= 21)) return "Sagitario";
        if((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "Capricornio";
        if((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "Acuario";
        if((month == 2 && day >= 19) || (month == 3 && day <= 20)) return "Piscis";
        return "Invalid Date";
    }
}
