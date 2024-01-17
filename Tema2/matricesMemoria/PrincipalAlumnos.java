package Tema2.matricesMemoria;

import java.util.Scanner;

public class PrincipalAlumnos {
    public static final int TAM = 4;
    public static final int INTENTOS = 5;
    public static final char OCULTO = '#';

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        char[][] matriz = new char[TAM][TAM];
        boolean[][] matrizVisible = new boolean[TAM][TAM];

        /*
        matrizVisible es una matriz de booleanos que nos servirá para saber si una celda está visible u oculta.
        Por defecto, todas las celdas estarán ocultas, por lo que inicializamos la matriz a false.
         */
        ocultarTodaLaMatriz(matrizVisible);
        printVisibleMatrix(matriz, matrizVisible);

        /*
         * La estrategia que seguiremos será la siguiente: Rellenaremos la matriz con los valores de la "A" a la letra final
         * (que vendrá determinada por A + TAM * TAM / 2) dos veces. Una vez rellenada la matriz, la recorreremos y cambiaremos
         * su valor por otra celda de la matriz obtenida aleatoriamente.
         */

        fillMatrix(matriz);
        //printMatrix(matriz);
        randomizeMatrix(matriz);
        //printMatrix(matriz);

        // TODO: Aplicar la lógica descrita del juego

        /*
        Creo una variable de la constante INTENTOS porque como las constantes tienen un valor fijo
        a la hora de modificar el número de intentos que tiene el jugador no es posible.
         */

        int numIntentos = INTENTOS;

        /*
        Creo un bucle que dure hasta que todas las celdas estén todas true o que te quedes sin intentos
         */
        while(!checkFinished(matrizVisible) && numIntentos > 0){

            /*
            creamos la entrada del usuario para que introduzca la primera coordenada
             */
            int f1 = MiEntradaSalida.leerEnteroEnRango(0, TAM - 1);;
            int c1 = MiEntradaSalida.leerEnteroEnRango(0, TAM - 1);;

            /*
            Aquí hago que la primera casilla que selecciona el usuario se muestre
             */
            matrizVisible[f1][c1] = true;
            printVisibleMatrix(matriz, matrizVisible);

            /*
            la segunda coordenada
             */
            int f2 = MiEntradaSalida.leerEnteroEnRango(0, TAM - 1);;
            int c2 = MiEntradaSalida.leerEnteroEnRango(0, TAM - 1);;


            /*
            En este if verifico si las dos letras que ha seleccionado el usuario son parejas o no
             */
            if (matriz[f1][c1] == matriz[f2][c2]){
                /*
                Si son pareja dejo las dos casillas en true para que se quede descubierta
                 */
                System.out.println("La pareja coincide");

                matrizVisible[f1][c1] = true;
                matrizVisible[f2][c2] = true;
                printVisibleMatrix(matriz, matrizVisible);

            }else {

                System.out.println("La pareja NO coincide, vuelve a intentarlo");
                /*
                Si la pareja no coincide resto un intento
                 */
                numIntentos--;

                /*
                muestro la letra de la casilla que ha seleccionado
                 */
                matrizVisible[f2][c2] = true;
                printVisibleMatrix(matriz, matrizVisible);

                /*
                te muestra un mensaje de los intentos que te queda y volvemos a ocultar las casillas
                 */
                System.out.println("Este es el tablero actual. Te quedan " + numIntentos + " intentos");
                matrizVisible[f1][c1] = false;
                matrizVisible[f2][c2] = false;
                printVisibleMatrix(matriz, matrizVisible);
            }
        }

        /*
        En este if si están todas las casillas en true ha ganado la partida, si no lo ha conseguido ha perdido
         */
        if (checkFinished(matrizVisible)) {
            System.out.println("¡Enhorabuena! Has ganado");
        } else {
            System.out.println("¡Vaya! Has perdido. Vuelve a jugar otra vez.");
        }
    }

    /**
     * Imprime la matriz por pantalla
     * @param matriz
     */
    private static void printMatrix(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%2C ", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
    }

    /**
     * Imprime la matriz visible por pantalla, mostrando las celdas ocultas con el valor de la constante OCULTO
     * @param matriz
     * @param matrizVisible
     */
    private static void printVisibleMatrix(char[][] matriz, boolean[][] matrizVisible) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (matrizVisible[i][j]){
                    System.out.print(matriz[i][j] + "  ");
                }else {
                    System.out.print(OCULTO + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
    }

    /**
     * Rellena la matriz con los valores de la A a la letra final (que vendrá determinada por A + TAM * TAM / 2)
     * dos veces
     * @param matriz
     */
    public static void fillMatrix(char[][] matriz) {
        char letra = 'A';
        /*
        Hago una conversión en la operación para que de caracteres
         */
        char letraFinal =  (char) ((letra + TAM * TAM / 2) - 1);

        //recorro la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = letra;

                /*
                En este if garantiza que haya parejas, si letra es igual a letraFinal que representa la última letra
                que debe colocarse en la matriz se reinicia y la variable letra vuelve a valer "A" y rellena hasta
                el final si no sigue rellenando con letras.
                 */
                if (letra == letraFinal){
                    letra = 'A';
                }else {
                    letra++;
                }
            }
        }
    }

    /**
     * Desordena la matriz
     * @param matriz
     */
    private static void randomizeMatrix(char[][] matriz) {
        // Una vez rellena la matriz, la desordenamos
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                /*
                creamos la variable fila y columna Random para desordenar las filas y columnas de la matriz
                y como Math.random es un double y lo convertimos porque lo que queremos
                es un entero para seleccionar la fila y columna
                 */
                int fRandom = (int) (Math.random() * matriz.length);
                int cRandom = (int) (Math.random() * matriz.length);

                /*
                aquí intercambiamos los elementos de la matriz ordenada y lo desordenamos, creamos una variable
                auxiliar para que no haya pérdida de datos
                 */
                char aux = matriz[i][j];
                matriz[i][j] = matriz[fRandom][cRandom];
                matriz[fRandom][cRandom] = aux;
            }
        }
    }

    /**
     * Hace que todas las celdas de la matriz sean false (ocultas)
     * @param matrizVisible
     */
    private static void ocultarTodaLaMatriz(boolean[][] matrizVisible) {
        /*
        recorro la matriz y ponemos todos los valores false porque al principio del juego la matriz empieza
        todas las casillas false.
         */
        for (int i = 0; i < matrizVisible.length; i++) {
            for (int j = 0; j < matrizVisible[i].length; j++) {
                matrizVisible[i][j] = false;
            }
        }
    }

    /**
     * Comprueba si todas las celdas de la matriz son true (visibles)
     * @param matrizVisible
     * @return
     */
    private static boolean checkFinished(boolean[][] matrizVisible) {
        /*
        creo una variable que compruebe que el juego ha terminado
         */
        boolean terminado = false;

        for (int i = 0; i < matrizVisible.length; i++) {
            for (int j = 0; j < matrizVisible.length; j++) {
                /*
                si la matriz tiene alguna casilla falsa, terminado da false si la matriz tiene todas las casillas
                true terminado da true
                 */
                if (!matrizVisible[i][j]){
                    terminado = false;
                }else{
                    terminado = true;
                }
            }
        }
        return terminado;
    }
}