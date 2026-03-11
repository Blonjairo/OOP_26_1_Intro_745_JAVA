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
        int rot = posiciones % n;
        int[] rotado = new int[n];
        for(int i = 0; i < n; i++) rotado[(i + rot) % n] = arreglo[i];
        return rotado;
    }

    public int contarCaracteres(String cadena) {
        return cadena.length();
    }

    public String invertirCadena(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }

    public boolean esPalindromo(String cadena) {
        String s = cadena.toLowerCase().replaceAll("[^a-z0-9]", "");
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }

    public int contarPalabras(String cadena) {
        if(cadena == null || cadena.trim().length() == 0) return 0;
        return cadena.trim().split("[\\s]+").length;
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
        int pos = correo.indexOf("@");
        if(pos <= 0) return false;
        if(correo.indexOf("@", pos + 1) != -1) return false;
        String dominio = correo.substring(pos + 1);
        if(!dominio.contains(".") || dominio.startsWith(".") || dominio.endsWith(".")) return false;
        int ultimoPunto = dominio.lastIndexOf(".");
        if(dominio.substring(ultimoPunto + 1).length() < 2) return false;
        return true;
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

    public String jugarPiedraPapelTijeraLagartoSpock(String eleccion) {
        String[] jugadas = {"piedra", "papel", "tijera", "lagarto", "spock"};
        String maquina = jugadas[new Random().nextInt(jugadas.length)];
        String e = eleccion.toLowerCase();
        if(e.equals(maquina)) return "empate";
        boolean gane = false;
        if(e.equals("piedra") && (maquina.equals("tijera") || maquina.equals("lagarto"))) gane = true;
        else if(e.equals("papel") && (maquina.equals("piedra") || maquina.equals("spock"))) gane = true;
        else if(e.equals("tijera") && (maquina.equals("papel") || maquina.equals("lagarto"))) gane = true;
        else if(e.equals("lagarto") && (maquina.equals("papel") || maquina.equals("spock"))) gane = true;
        else if(e.equals("spock") && (maquina.equals("piedra") || maquina.equals("tijera"))) gane = true;
        return gane ? "ganaste" : "perdiste";
    }

    public String pptls2(String[] game) {
        String jug1 = game[0].toLowerCase();
        String jug2 = game[1].toLowerCase();
        if(jug1.equals(jug2)) return "tie";
        boolean j1gana = false;
        if(jug1.equals("piedra") && (jug2.equals("tijera") || jug2.equals("lagarto"))) j1gana = true;
        else if(jug1.equals("papel") && (jug2.equals("piedra") || jug2.equals("spock"))) j1gana = true;
        else if(jug1.equals("tijera") && (jug2.equals("papel") || jug2.equals("lagarto"))) j1gana = true;
        else if(jug1.equals("lagarto") && (jug2.equals("papel") || jug2.equals("spock"))) j1gana = true;
        else if(jug1.equals("spock") && (jug2.equals("piedra") || jug2.equals("tijera"))) j1gana = true;
        return j1gana ? "Player 1" : "Player 2";
    }

    public double areaCirculo(double radio) {
        return Math.PI * radio;
    }

    public String zoodiac(int day, int month) {
        if(month < 1 || month > 12 || day < 1 || day > 31) return "Invalid Date";
        if((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Aries";
        if((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Tauro";
        if((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "Geminis";
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
