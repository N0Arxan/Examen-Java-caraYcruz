import java.util.Random;
import java.util.Scanner;

public class Main {


    /**
     * ____PP____
     * <p>
     * 1.Pedir Numero de Rondas *
     * 2.Hacer Tirades de Ordenador *
     * 3.Pedir Tirades de Jugador1,2 *
     * 4.Contar Coincidencias Jgador1,2 con Ordenador *
     * 5.(Compravar y decir el ganador) * y (mostrar difrencies) *
     */

    public static void main(String[] args) {
        //
        int longi = demanarNum();
        char[] tiradesOrdinador = ferTiradesOrdinador(longi);
        //
        System.out.println("**Entera tirades Jugador 1**");
        char[] tiradesJugador1 = demanarTiradesJugador(longi);
        printArray(tiradesJugador1, longi);
        //
        System.out.println("**Entera tirades Jugador 2**");
        char[] tiradesJugador2 = demanarTiradesJugador(longi);
        printArray(tiradesJugador2, longi);
        //
        int CJ1 = contarCoincidencies(tiradesJugador1, tiradesOrdinador, longi); // numero coincidencies jugador 1
        int CJ2 = contarCoincidencies(tiradesJugador2, tiradesOrdinador, longi); // numero coincidencies jugador 2
        //
        int res = comprovarGanador(CJ1, CJ2); //resultad: 0=empate , 1=jugador1 , 2=jugador2
        printDiferencia(tiradesOrdinador, tiradesJugador1, tiradesJugador2, res, longi);

        System.out.println("**Tirades de Ordinador**");
        printArray(tiradesOrdinador, longi);

    }

    /**
     * this function pide enterada numero de rondas
     * que es entre 1,10
     *
     * @return numero de rondas
     */
    public static int demanarNum() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese un numero de tirades: ");
        int num = input.nextInt();
        while (num < 1 || num > 10) {
            System.out.println("Ingrese un numero correcte (1-10): ");
            num = input.nextInt();
        }
        return num;
    }

    /**
     * este funcion crea un tabla de chars random de 'x' y 'o'
     * con longitud de parametro de enterada
     *
     * @param longi que es numero de las rondas
     * @return una tabla de chars random de 'x' y 'o'
     */
    public static char[] ferTiradesOrdinador(int longi) {
        char[] tabla = new char[longi];
        Random r = new Random();
        for (int i = 0; i < longi; i++) {
            int valor = r.nextInt(2);
            tabla[i] = valor == 0 ? 'o' : 'x';
        } //holi :)
        return tabla;
    }

    /**
     * este funcion pide (n)veces valors enter 'x' y 'o'
     * y los pone dentro de una tabla con conservar el order
     *
     * @param longi que es longitud de la tabla returnada
     * @return una tabla de chars random de 'x' y 'o'
     */
    public static char[] demanarTiradesJugador(int longi) {
        char[] tabla = new char[longi];
        Scanner input = new Scanner(System.in);
        input.useDelimiter("");

        int i = 0;
        while (i < longi) {
            System.out.print(i + 1 + ".Ingrese un x/o: ");
            char valor = input.nextLine().charAt(0);
            if (valor == 'x' || valor == 'o') {
                tabla[i] = valor;
                i++;
            } else {
                System.out.println("Invalid enterada");
            }
        }
        return tabla;
    }

    /**
     * en este funcion sse supone que las dos tablas de enterada
     * son con la misma mida y contamos las difernencias en cada
     * posicion
     *
     * @param tabla1 una tabla de chars
     * @param tabla2 una tabla de chars
     * @param longi  la mida de las tablas
     * @return CJX = numero de diferncies
     */
    public static int contarCoincidencies(char[] tabla1, char[] tabla2, int longi) {
        int count = 0;
        for (int i = 0; i < longi; i++) {
            if (tabla1[i] == tabla2[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * este funcion recibe dos int y los compara y dice
     * cual es mas mayor ha ganado
     *
     * @param CJ1 numero de conicidencias 1
     * @param CJ2 numero de conicidencias 2
     * @return un numero(1,2,3) que 1 = ganador es jugador 1 ; 2 = ganador es jugador 2 ; 0= empate
     */
    public static int comprovarGanador(int CJ1, int CJ2) {
        if (CJ1 > CJ2) {
            System.out.println("Ganador es Jugador1 amb " + CJ1 + " Coincidencies");
            return 1;
        } else {
            if (CJ2 > CJ1) {
                System.out.println("Ganador es Jugador2 amb " + CJ2 + " Coincidencies");
                return 2;
            } else {
                System.out.println("ES UN EMPATE");
                return 0;
            }
        }
    }

    /**
     * este funcion dependiendo de la resultad de partido si es
     * necesario mostrara las difrencias de tabla de tirades de gandor
     * con la tabla de ordenador
     *
     * @param tablaO que debe ser tirades ordenador
     * @param tabla1 que debe ser tirades de jugador 1
     * @param tabla2 que debe ser tirades de jugador 2
     * @param res    que es el resultado de funcion comprovarGanador()
     * @param longi  longitud de las tablas
     */
    public static void printDiferencia(char[] tablaO, char[] tabla1, char[] tabla2, int res, int longi) {
        if (res == 1) {
            System.out.print("amb diferncies en posiciones : ");
            for (int i = 0; i < longi; i++) {
                if (tablaO[i] != tabla1[i]) {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
        } else {
            if (res == 2) {
                System.out.print("amb diferncies en posiciones : ");
                for (int i = 0; i < longi; i++) {
                    if (tablaO[i] != tabla2[i]) {
                        System.out.print(i + 1 + " ");
                    }
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }

    /**
     * este funcion recibe una tabla con su mida y
     * lo imprime linealmente
     *
     * @param tabla array
     * @param longi int
     */
    public static void printArray(char[] tabla, int longi) {
        for (int i = 0; i < longi; i++) {
            System.out.print(tabla[i] + " ");
        }
        System.out.println();
    }

}


