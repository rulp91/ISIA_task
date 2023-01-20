/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrices;

import java.awt.Dimension;
import java.util.Random;

/**
 * @author galvez
 */
public class Matriz {
    private final int[][] datos;

    public Matriz(int filas, int columnas, boolean inicializarAleatorio) {
        datos = new int[columnas][];
        for (int i = 0; i < columnas; i++) {
            datos[i] = new int[filas];
            Random rnd = new Random();
            if (inicializarAleatorio)
                for (int j = 0; j < filas; j++)
                    datos[i][j] = rnd.nextInt(100);
        }
    }

    public Matriz(Dimension d, boolean inicializarAleatorio) {
        this(d.height, d.width, inicializarAleatorio);
    }

    public Matriz(int filas, int columnas) {
        this(filas, columnas, false);
    }

    public Dimension getDimension() {
        return new Dimension(datos.length, datos[0].length);
    }

    public static Matriz sumarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles {
        if (!a.getDimension().equals(b.getDimension()))
            throw new DimensionesIncompatibles("La suma de matrices requiere matrices de las mismas dimensiones");
        int i, j, filasA, columnasA;
        filasA = a.getDimension().height;
        columnasA = a.getDimension().width;
        Matriz matrizResultante = new Matriz(filasA, columnasA, false);
        for (j = 0; j < filasA; j++) {
            for (i = 0; i < columnasA; i++) {
                matrizResultante.datos[i][j] += a.datos[i][j] + b.datos[i][j];
            }
        }
        return matrizResultante;
    }

    public static Matriz invertirMatriz(Matriz origen) {

        int filasA = origen.getDimension().height;
        int columnasA = origen.getDimension().width;
        Matriz matrizResultante = new Matriz(columnasA, filasA);

        for (int i = 0; i < columnasA; i++)
            for (int j = 0; j < filasA; j++)
                matrizResultante.datos[j][i] = origen.datos[i][j];

        return matrizResultante;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[\n");
        for (int i = 0; i < getDimension().width; i++) {
            ret.append("(");
            for (int j = 0; j < getDimension().height; j++) {
                ret.append(String.format("%3d", datos[i][j]));
                if (j != getDimension().height - 1) ret.append(", ");
            }
            ret.append(")");
            if (i != getDimension().width - 1) ret.append(",");
            ret.append("\n");
        }
        ret.append("]\n");
        return ret.toString();
    }
}
