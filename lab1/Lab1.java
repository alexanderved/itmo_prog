public class Lab1 {
    static int[] createArrayZ() {
        final int MAX_VALUE = 19;
        final int MIN_VALUE = 6;
        final int ARRAY_Z_LENGTH = MAX_VALUE - MIN_VALUE + 1;

        int[] z = new int[ARRAY_Z_LENGTH];
        for (int i = 0; i < ARRAY_Z_LENGTH; ++i) {
            z[i] = MAX_VALUE - i;
        }

        return z;
    }

    static float[] createArrayX() {
        final float MAX_VALUE = 3.0f;
        final float MIN_VALUE = -12.0f;
        final int ARRAY_X_LENGTH = 14;

        float[] x = new float[ARRAY_X_LENGTH];
        for (int i = 0; i < ARRAY_X_LENGTH; ++i) {
            x[i] = (float)Math.random() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE;
        }

        return x;
    }

    static boolean contains(int[] arr, int val) {
        for (int el : arr) {
            if (val == el) {
                return true;
            }
        }

        return false;
    }

    static float calculateZ1Element(int z, float x) {
        final int Z_VALUE_CASE1 = 15;
        final int[] Z_VALUE_CASE2 = {7, 8, 9, 12, 13, 16, 17};

        if (z == Z_VALUE_CASE1) {
            return (float)Math.cos(Math.pow(
                Math.pow(x, 2.0 / x) * (1.0 - Math.atan((x - 4.5) / 15.0)), 3.0));
        } else if (contains(Z_VALUE_CASE2, z)) {
            return (float)Math.tan(Math.log(Math.pow(Math.cos(x), 2.0)));
        } else {
            return 3.0f * (float)(Math.log(Math.acos((x - 4.5) / 15.0) / 2.0) + 1.0);
        }
    }

    static float[][] createArrayZ1(int[] z, float[] x) {
        final int MATRIX_DIM = 14;

        float[][] z1 = new float[MATRIX_DIM][MATRIX_DIM];
        for (int i = 0; i < MATRIX_DIM; ++i) {
            for (int j = 0; j < MATRIX_DIM; ++j) {
                z1[i][j] = calculateZ1Element(z[i], x[j]);
            }
        }

        return z1;
    }

    static void printMatrix(float[][] z1) {
        System.out.println("[");
        for (float[] row : z1) {
            System.out.printf("\t[% 5.2f", row[0]);
            for (int i = 1; i < row.length; ++i) {
                System.out.printf(", % 7.2f", row[i]);
            }
            System.out.println("],");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] z = createArrayZ();
        float[] x = createArrayX();
        float[][] z1 = createArrayZ1(z, x);
        printMatrix(z1);
    }
}