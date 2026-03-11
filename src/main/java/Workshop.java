import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Workshop {

    public int sumarDosNumeros(int a, int b) {
        return a + b;
    }

    public int mayorDeTresNumeros(int a, int b, int c) {
        // primero comparo a con b
        int tmp;
        if(a > b){
            tmp = a;
        } else {
            tmp = b;
        }
        // ahora comparo el mayor con c
        if(c > tmp){
            tmp = c;
        }
        return tmp;
    }

    public int[] tablaMultiplicar(int numero, int limite) {
        int arr[] = new int[limite];
        int i = 0;
        while(i < limite){
            arr[i] = numero * (i+1);
            i++;
        }
        return arr;
    }

    public long factorial(int n) {
        // el profe dijo que si es negativo toca lanzar la excepcion
        if(n < 0){
            throw new IllegalArgumentException("numero negativo no tiene factorial");
        }
        long res = 1;
        for(int i = 2; i <= n; i++){
            res *= i;
        }
        return res;
    }

    public boolean esPrimo(int numero) {
        if(numero <= 1) return false;
        if(numero == 2) return true;
        // recorro desde 2 hasta numero-1 buscando divisores
        for(int i = 2; i <= numero-1; i++){
            if(numero % i == 0){
                return false;
            }
        }
        return true;
    }

    public int[] serieFibonacci(int n) {
        if(n < 0) throw new IllegalArgumentException("no puede ser negativo");
        int[] fib = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                fib[0] = 0;
            } else if(i == 1){
                fib[1] = 1;
            } else {
                fib[i] = fib[i-1] + fib[i-2];
            }
        }
        return fib;
    }

    public int sumaElementos(int[] arreglo) {
        int total = 0;
        for(int i = 0; i < arreglo.length; i++){
            total += arreglo[i];
        }
        return total;
    }

    public double promedioElementos(int[] arreglo) {
        // sumo todo y divido, casteo a double para que no pierda decimales
        int sum = 0;
        for(int x : arreglo){
            sum += x;
        }
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
            if(arreglo[i] < min){
                min = arreglo[i];
            }
        }
        return min;
    }

    public boolean buscarElemento(int[] arreglo, int elemento) {
        boolean encontrado = false;
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i] == elemento){
                encontrado = true;
            }
        }
        return encontrado;
    }

    public int[] invertirArreglo(int[] arreglo) {
        int n = arreglo.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = arreglo[n-1-i];
        }
        return res;
    }

    // ordenar con burbuja, vi un video en youtube de esto
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
                if(lista.get(j) == arreglo[i]){
                    yaEsta = true;
                    break;
                }
            }
            if(!yaEsta){
                lista.add(arreglo[i]);
            }
        }
        int[] resultado = new int[lista.size()];
        for(int i = 0; i < lista.size(); i++){
            resultado[i] = lista.get(i);
        }
        return resultado;
    }

    public int[] combinarArreglos(int[] arreglo1, int[] arreglo2) {
        int tam = arreglo1.length + arreglo2.length;
        int[] nuevo = new int[tam];
        for(int i = 0; i < arreglo1.length; i++){
            nuevo[i] = arreglo1[i];
        }
        for(int i = 0; i < arreglo2.length; i++){
            nuevo[arreglo1.length + i] = arreglo2[i];
        }
        return nuevo;
    }

    public int[] rotarArreglo(int[] arreglo, int posiciones) {
        // si el arreglo esta vacio retorno lo mismo
        if(arreglo.length == 0) return arreglo;
        int n = arreglo.length;
        int[] rotado = new int[n];
        for(int i = 0; i < n; i++){
            int nuevaPos = (i + posiciones) % n;
            rotado[i] = arreglo[nuevaPos];
        }
        return rotado;
    }

    public int contarCaracteres(String cadena) {
        return cadena.length();
    }

    public String invertirCadena(String cadena) {
        String al_reves = "";
        for(int i = cadena.length()-1; i >= 0; i--){
            al_reves += cadena.charAt(i);
        }
        return al_reves;
    }

    public boolean esPalindromo(String cadena) {
        // ignorar mayusculas segun el test
        String s = cadena.toLowerCase();
        String rev = invertirCadena(s);
        if(s.equals(rev)){
            return true;
        }
        return false;
    }

    public int contarPalabras(String cadena) {
        if(cadena == null || cadena.trim().length() == 0) return 0;
        String[] w = cadena.trim().split("\\s+");
        return w.length;
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
        // indexOf ya hace esto, si no esta retorna -1
        return cadena.indexOf(subcadena);
    }

    public boolean validarCorreoElectronico(String correo) {
        if(correo == null || correo.length() == 0) return false;

        // tiene que tener @
        int posArroba = correo.indexOf("@");
        if(posArroba == -1) return false;

        // tiene que haber algo antes del @
        if(posArroba == 0) return false;

        String despuesArroba = correo.substring(posArroba + 1);

        // tiene que haber un punto despues del @
        if(!despuesArroba.contains(".")) return false;

        // el punto no puede ser al final
        if(despuesArroba.endsWith(".")) return false;

        return true;
    }

    public double promedioLista(List<Integer> lista) {
        if(lista == null || lista.size() == 0) return 0.0;
        int suma = 0;
        for(int i = 0; i < lista.size(); i++){
            suma += lista.get(i);
        }
        return (double) suma / lista.size();
    }

    public String convertirABinario(int numero) {
        return Integer.toBinaryString(numero);
    }

    public String convertirAHexadecimal(int numero) {
        // toHexString lo da en minuscula, hay que pasarlo a mayus
        return Integer.toHexString(numero).toUpperCase();
    }

    public String jugarPiedraPapelTijeraLagartoSpock(String eleccion) {
        String[] jugadas = {"piedra", "papel", "tijera", "lagarto", "spock"};
        Random r = new Random();
        String maquina = jugadas[r.nextInt(jugadas.length)];

        //System.out.println("maquina eligio: " + maquina);

        if(eleccion.equals(maquina)) return "empate";

        boolean gane = false;
        if(eleccion.equals("piedra") && (maquina.equals("tijera") || maquina.equals("lagarto"))) gane = true;
        else if(eleccion.equals("papel") && (maquina.equals("piedra") || maquina.equals("spock"))) gane = true;
        else if(eleccion.equals("tijera") && (maquina.equals("papel") || maquina.equals("lagarto"))) gane = true;
        else if(eleccion.equals("lagarto") && (maquina.equals("papel") || maquina.equals("spock"))) gane = true;
        else if(eleccion.equals("spock") && (maquina.equals("piedra") || maquina.equals("tijera"))) gane = true;

        if(gane) return "ganaste";
        return "perdiste";
    }

    public String pptls2(String[] game) {
        String jug1 = game[0];
        String jug2 = game[1];

        if(jug1.equals(jug2)) return "empate";

        boolean j1gana = false;
        if(jug1.equals("piedra") && (jug2.equals("tijera") || jug2.equals("lagarto"))) j1gana = true;
        else if(jug1.equals("papel") && (jug2.equals("piedra") || jug2.equals("spock"))) j1gana = true;
        else if(jug1.equals("tijera") && (jug2.equals("papel") || jug2.equals("lagarto"))) j1gana = true;
        else if(jug1.equals("lagarto") && (jug2.equals("papel") || jug2.equals("spock"))) j1gana = true;
        else if(jug1.equals("spock") && (jug2.equals("piedra") || jug2.equals("tijera"))) j1gana = true;

        if(j1gana) return "jugador1";
        else return "jugador2";
    }

    public double areaCirculo(double radio) {
        // formula del area pi*r^2
        return Math.PI * (radio * radio);
    }

    public String zoodiac(int day, int month) {
        String signo = "";

        if((month == 3 && day >= 21) || (month == 4 && day <= 19)) signo = "Aries";
        else if((month == 4 && day >= 20) || (month == 5 && day <= 20)) signo = "Tauro";
        else if((month == 5 && day >= 21) || (month == 6 && day <= 20)) signo = "Geminis";
        else if((month == 6 && day >= 21) || (month == 7 && day <= 22)) signo = "Cancer";
        else if((month == 7 && day >= 23) || (month == 8 && day <= 22)) signo = "Leo";
        else if((month == 8 && day >= 23) || (month == 9 && day <= 22)) signo = "Virgo";
        else if((month == 9 && day >= 23) || (month == 10 && day <= 22)) signo = "Libra";
        else if((month == 10 && day >= 23) || (month == 11 && day <= 21)) signo = "Escorpio";
        else if((month == 11 && day >= 22) || (month == 12 && day <= 21)) signo = "Sagitario";
        else if((month == 12 && day >= 22) || (month == 1 && day <= 19)) signo = "Capricornio";
        else if((month == 1 && day >= 20) || (month == 2 && day <= 18)) signo = "Acuario";
        else if((month == 2 && day >= 19) || (month == 3 && day <= 20)) signo = "Piscis";
        else signo = "Desconocido";

        return signo;
    }
}
