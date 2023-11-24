package Tema2.matricesMemoria;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class PrincipalAlumnos {
    public static final int TAM = 4;
    public static final int INTENTOS = 5;
    public static final char OCULTO = '#';


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
         * La estrategia que seguiremos será la siguiente: Rellenaremos la matriz con los valores de la A a la letra final
         * (que vendrá determinada por A + TAM * TAM / 2) dos veces. Una vez rellenada la matriz, la recorreremos y cambiaremos
         * su valor por otra celda de la matriz obtenida aleatoriamente.
         */



        fillMatrix(matriz);
        printMatrix(matriz);
        randomizeMatrix(matriz);
        printMatrix(matriz);

        // TODO: Aplicar la lógica descrita del juego


        if (checkFinished(matrizVisible)){
            System.out.println("¡Enhorabuena! Has ganado");
        }
        else {
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
     * Rellena la matriz con los valores de la A a la letra final (que vendrá determinada por A + TAM * TAM / 2) dos veces
     * @param matriz
     */
    public static void fillMatrix(char[][] matriz) {
        char letra = 'A';
        /*
        Hago una conversión en la operación para que de caracteres
         */
        char letraFinal =  (char) ((letra + TAM * TAM / 2) - 1);

        //recorremos la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = letra;

                /*
                En este if garantiza que después de colocar la última letra que pueda introducir la variable "letra"
                se reinicie a la letra A para que pueda haber parejas si no sigue introduciendo letras.
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
                int fRandom = (int) (Math.random() * TAM);
                int cRandom = (int) (Math.random() * TAM);

                /*
                aquí intercambiamos los elementos de la matriz ordenada y lo desordenamos, creamos una variable
                auxiliar para que no haya perdida de datos
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
        boolean terminado = false;

        for (int i = 0; i < matrizVisible.length; i++) {
            for (int j = 0; j < matrizVisible.length; j++) {
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