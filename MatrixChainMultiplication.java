
import java.util.*;

public class MatrixChainMultiplication {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1]; // dimensions array
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        // Input dimensions
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter row and col size of A" + i + ": ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Validate compatibility
            if (i > 1 && p[i - 1] != row) {
                System.out.println("Matrix dimension mismatch! Multiplication not possible.");
                return;
            }
            if (i == 1) p[0] = row;
            p[i] = col;
        }

        // Matrix Chain Order (Dynamic Programming)
        for (int l = 2; l <= n; l++) { // l = chain length
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        // Print M-table
        System.out.println("\nM Table:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((m[i][j] == 0 ? 0 : m[i][j]) + " ");
            }
            System.out.println();
        }

        // Print S-table
        System.out.println("\nS Table:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("\nOptimal parenthesization: ");
        printOptimalParens(s, 1, n);
        System.out.println();

        System.out.println("The optimal ordering of the given matrices requires " + m[1][n] + " scalar multiplications.");
    }

    // Recursive function to print optimal parenthesization
    static void printOptimalParens(int[][] s, int i, int j) {
        if (i == j)
            System.out.print("A" + i);
        else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
