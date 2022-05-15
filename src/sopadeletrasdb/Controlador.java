package sopadeletrasdb;

import javax.swing.JTextArea;

public class Controlador {
    //-------------------------------------------------------------------------
    //DEVUELVE UN NÚMERO ENTRE 0 Y limite-1

    public static int azar(int limite) {
        return (int) Math.floor(Math.random() * limite);
    }
    //------------------------------------------------------------------------- 

    public static void mostrarMatriz(String[][] M, JTextArea a) {
        for (int f = 0; f < M.length; f++) { //M.length = rows 
            mostrarFila(M, f,a);
        }
    }
    //------------------------------------------------------------------------- 

    public static void mostrarFila(String[][] M, int f,JTextArea a) {
        int columnas = M[0].length;// Vemos la longitud de la primera fila
        for (int c = 0; c < columnas; c++) {
            a.append(M[f][c]+ "  ");
            System.out.print(M[f][c] + " ");

        }
        System.out.println();
         a.append("\n");
    }
    //-------------------------------------------------------------------------
    //Coloca la palabra almacenada en word de izquierda a derecha 

    public static boolean colocarPalabra0(String[] word) {
        //Seleccionar una fila al azar de 0 a número de M.length-1
        int f = azar(M.length);
        //Seleccionar una columna al azar de 0 a número de columnas menos la longitud de word
        int L = word.length;
        int c = azar(M[0].length - L + 1);

        boolean PERMITIDO = true;
        for (int t = 0; t < L; t++) {
            //Si el hueco está ocupado por una letra distinta de la que quiero colocar
            if ((H[f][c + t] == 1) && (M[f][c + t] != word[t])) {
                PERMITIDO = false;
            }
        }
        if (PERMITIDO) {
            //Colocamos la palabra en la matriz M
            for (int t = 0; t < L; t++) {
                M[f][c + t] = word[t];
                H[f][c + t] = 1;
            }
        }
        return PERMITIDO;

    }
    //-------------------------------------------------------------------------
    //Coloca la palabra almacenada en word top-down

    public static boolean colocarPalabra2(String[] word) {
        //Seleccionar una fila al azar de 0 a número de filas menos la longitud de word 
        int L = word.length;
        int f = azar(M.length - L + 1);
        //Seleccionar una columna al azar de 0 a número de M[0].length-1 que es el numero de columnas -1
        int c = azar(M[0].length);
        //Colocamos la palabra en la matriz M
        boolean PERMITIDO = true;
        for (int t = 0; t < L; t++) {
            if ((H[f + t][c] == 1) && (M[f + t][c] != word[t])) {
                PERMITIDO = false;
            }
        }
        if (PERMITIDO) {
            for (int t = 0; t < L; t++) {
                M[f + t][c] = word[t];
                H[f + t][c] = 1;
            }
        }
        return PERMITIDO;
    }
    //-------------------------------------------------------------------------
    //Coloca la palabra almacenada en word de derecha a izquierda 

    public static boolean colocarPalabra4(String[] word) {
        int f = azar(M.length);
        int L = word.length;
        int c = azar(M[0].length - L + 1);

        //Colocamos la palabra en la matriz M
        boolean PERMITIDO = true;
        for (int t = 0; t < L; t++) {
            if ((H[f][c + t] == 1) && (M[f][c + t] != word[L - t - 1])) {
                PERMITIDO = false;
            }
        }
        if (PERMITIDO) {
            for (int t = 0; t < L; t++) {
                M[f][c + t] = word[L - t - 1]; //coloca la palabra al revés
                H[f][c + t] = 1;
            }
        }
        return PERMITIDO;
    }
    //--------------------------------------------------------------------------
    //Coloca la palabra almacenada en word down-top

    public static boolean colocarPalabra6(String[] word) {
        int L = word.length;
        int f = azar(M.length - L + 1);

        int c = azar(M[0].length);
        //Colocamos la palabra en la matriz M
        boolean PERMITIDO = true;
        for (int t = 0; t < L; t++) {
            if ((H[f + t][c] == 1) && (!M[f + t][c].equals(word[L - t - 1]))) {
                PERMITIDO = false;
            }
        }
        if (PERMITIDO) {

            for (int t = 0; t < L; t++) {
                M[f + t][c] = word[L - t - 1];
                H[f + t][c] = 1;
            }
        }
        return PERMITIDO;
    }
    //------------------------------------------------------------------------- 
    //Coloca la palabra almacenada en word SE

    public static boolean colocarPalabra1(String[] word) {
        int L = word.length;
        int f = azar(M.length);
        int c = azar(M[0].length);
        //Colocamos la palabra en la matriz M
        boolean PERMITIDO = true;
        for (int t = 0; t < L; t++) {
            //si me salgo de los límites del array
            if ((f + t >= M.length) || (c + t >= M[0].length)) {
                PERMITIDO = false;
            } else { //si el hueco está ocupado por una letra distinta de la quiero colocar
                if ((H[f + t][c + t] == 1) && (!M[f + t][c + t].equals(word[t]))) {
                    PERMITIDO = false;
                }
            }
        }
        if (PERMITIDO) {
            for (int t = 0; t < L; t++) {
                M[f + t][c + t] = word[t];
                H[f + t][c + t] = 1;
            }
        }
        return PERMITIDO;
    }
    //-------------------------------------------------------------------------
    //Coloca la palabra almacenada en word SE

    public static boolean colocarPalabra5(String[] word) {
        int L = word.length;
        int f = azar(M.length);
        int c = azar(M[0].length);
        //Colocamos la palabra en la matriz M
        boolean PERMITIDO = true;
        for (int t = 0; t < L; t++) {
            //si me salgo de los límites del array
            if ((f + t >= M.length) || (c + t >= M[0].length)) {
                PERMITIDO = false;
            } else { //si el hueco está ocupado por una letra distinta de la quiero colocar
                if ((H[f + t][c + t] == 1) && (!M[f + t][c + t].equals(word[L - t - 1]))) {
                    PERMITIDO = false;
                }
            }
        }
        if (PERMITIDO) {
            for (int t = 0; t < L; t++) {
                M[f + t][c + t] = word[L - t - 1];
                H[f + t][c + t] = 1;
            }
        }
        return PERMITIDO;
    }
    //-------------------------------------------------------------------------
    //Coloca la palabra almacenada en word SE

    public static boolean colocarPalabra3(String[] word) {
        int L = word.length;
        int f = azar(M.length);
        int c = azar(M[0].length);
        //Colocamos la palabra en la matriz M
        boolean PERMITIDO = true;
        for (int t = 0; t < L; t++) {
            //si me salgo de los límites del array
            if ((f + t >= M.length) || (c - t < 0)) {
                PERMITIDO = false;
            } else { //si el hueco está ocupado por una letra distinta de la quiero colocar
                if ((H[f + t][c - t] == 1) && (!M[f + t][c - t].equals(word[t]))) {
                    PERMITIDO = false;
                }
            }
        }
        if (PERMITIDO) {
            for (int t = 0; t < L; t++) {
                M[f + t][c - t] = word[t];
                H[f + t][c - t] = 1;
            }
        }
        return PERMITIDO;
    }
    //-------------------------------------------------------------------------
    //Coloca la palabra almacenada en word SE

    public static boolean colocarPalabra7(String[] word) {
        int L = word.length;
        int f = azar(M.length);
        int c = azar(M[0].length);
        //Colocamos la palabra en la matriz M
        boolean PERMITIDO = true;
        for (int t = 0; t < L; t++) {
            //si me salgo de los límites del array
            if ((f + t >= M.length) || (c - t < 0)) {
                PERMITIDO = false;
            } else { //si el hueco está ocupado por una letra distinta de la quiero colocar
                if ((H[f + t][c - t] == 1) && (!M[f + t][c - t].equals(word[L - t - 1]))) {
                    PERMITIDO = false;
                }
            }
        }
        if (PERMITIDO) {
            for (int t = 0; t < L; t++) {
                M[f + t][c - t] = word[L - t - 1];
                H[f + t][c - t] = 1;
            }
        }
        return PERMITIDO;
    }
    //------------------------------------------------------------------------- 

    public static void colocarTodas(String palabras) {
        String[] palabra = palabras.split(",");
        int orientacion;
        String[] word;
        int longPalabra = palabra.length;
        int cuenta = 0;
        boolean COLOCADO = false;
        do {
            word = palabra[cuenta].split("");
            orientacion = azar(8);
            COLOCADO = false;
            switch (orientacion) {
                case 0:
                    COLOCADO = colocarPalabra0(word);
                    break;
                case 1:
                    COLOCADO = colocarPalabra1(word);
                    break;
                case 2:
                    COLOCADO = colocarPalabra2(word);
                    break;
                case 3:
                    COLOCADO = colocarPalabra3(word);
                    break;
                case 4:
                    COLOCADO = colocarPalabra4(word);
                    break;
                case 5:
                    COLOCADO = colocarPalabra5(word);
                    break;
                case 6:
                    COLOCADO = colocarPalabra6(word);
                    break;
                case 7:
                    COLOCADO = colocarPalabra7(word);
                    break;
            }
            if (COLOCADO) {
                cuenta++;
            }
        } while (cuenta < longPalabra);
    }
    //--------------------------------------------------------------------------

    public static void inicializaMatrices() {
        String cadena = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String[] letra;
        letra = cadena.split("");
        int f, c;
        for (f = 0; f < M.length; f++) { //M.length = rows
            //Rellena de letras al azar la fila f
            for (c = 0; c < M[0].length; c++) {//M[0].length = cols
                M[f][c] = letra[azar(27)];
                H[f][c] = 0;
            }
        }
    }
    //--------------------------------------------------------------------------
    public void mostrarResultado() {
        for (int f = 0; f < M.length; f++) { 
            for (int c = 0; c < M[0].length; c++) {
                if (H[f][c] != 1) {
                    M[f][c] = " ";
                }
            }
        }
    }
    
    static String[][] M; //Variable global 
    static int[][] H; //Variable global array de huecos

}
