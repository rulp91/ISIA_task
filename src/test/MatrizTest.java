package test;

import matrices.DimensionesIncompatibles;
import matrices.Matriz;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrizTest {

    @org.junit.jupiter.api.Test
    void getDimensionTest() {
        Matriz m = new Matriz(3, 2, true);
        Assertions.assertAll(() -> assertEquals(2, m.getDimension().width),
                () -> assertEquals(3, m.getDimension().height));
    }

    @org.junit.jupiter.api.Test
    void sumarDosMatricesTest() {
        Matriz m1 = new Matriz(3, 3, false);
        Matriz m2 = new Matriz(3, 3, false);
    }

    @org.junit.jupiter.api.Test
    void multiplicarDosMatricesDimensionesIncompatiblesTest() {
        Matriz m1 = new Matriz(3, 2, false);
        Matriz m2 = new Matriz(3, 3, false);
        Exception exception = assertThrows(DimensionesIncompatibles.class, () -> Matriz.multiplicarDosMatrices(m1, m2));
        assertEquals("Las dimensiones no son válidas para la multiplicación", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void multiplicarDosMatricesTest() {
        List<int[]> l1 = Arrays.asList(new int[]{1, -1, 1}, new int[]{2, 2, 3}, new int[]{-2, -3, -1});
        Matriz m1 = new Matriz(l1);
        List<int[]> l2 = Arrays.asList(new int[]{1, 0, 4}, new int[]{0, 2, 5}, new int[]{1, 3, 0});
        Matriz m2 = new Matriz(l2);
        List<int[]> l3 = Arrays.asList(new int[]{2, 1, -1}, new int[]{5, 13, 18}, new int[]{-3, -9, -23});
        Matriz m3 = new Matriz(l3);

        try {
            Matriz mTest = Matriz.multiplicarDosMatrices(m1, m2);
            assertEquals(m3, mTest);
        }catch (Exception exception){
            assertEquals("Las dimensiones no son válidas para la multiplicación", exception.getMessage());
        }

    }

    @org.junit.jupiter.api.Test
    void invertirMatriz() {
    }
}