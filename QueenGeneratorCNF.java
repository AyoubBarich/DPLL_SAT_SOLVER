import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class QueenGeneratorCNF {

        private static int N; // Default value
        private static int clauses = 0;
        private static char[][] board = new char[N][N];

        private static FileWriter fileWriter;

        private static void diagonalDown(int x, int y) throws IOException {
            int i, j;
            for (; x < N - 1 && y < N - 1; x++, y++)
                for (i = x + 1, j = y + 1; i < N && j < N; i++, j++) {
                    fileWriter.write(String.format("-%d -%d 0\n", queen(x, y), queen(i, j)));
                    clauses++;
                }
        }

        private static void diagonalUp(int x, int y) throws IOException {
            int i, j;
            for (; x > 0 && y < N - 1; x--, y++)
                for (i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
                    fileWriter.write(String.format("-%d -%d 0\n", queen(x, y), queen(i, j)));
                    clauses++;
                }
        }

        private static int queen(int x, int y) {
            return x * N + y + 1;
        }

        private static int row(int c) {
            return (c - 1) / N;
        }

        private static int col(int c) {
            return (c - 1) % N;
        }

        public static void generate(int N) throws IOException {
            fileWriter = new FileWriter(String.format("./QueenGen/coding%d.cnf",N));

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N - 1; i++)
                    for (int j = i + 1; j < N; j++) {
                        fileWriter.write(String.format("-%d -%d 0\n", queen(k, i), queen(k, j)));
                        clauses++;
                        fileWriter.write(String.format("-%d -%d 0\n", queen(i, k), queen(j, k)));
                        clauses++;
                    }

                for (int i = 0; i < N; i++)
                    fileWriter.write(queen(k, i) + " ");
                fileWriter.write("0\n");
                clauses++;
            }

            for (int i = 0; i < N - 1; i++)
                diagonalDown(0, i);
            for (int i = 1; i < N - 1; i++)
                diagonalDown(i, 0);
            for (int i = 1; i < N; i++)
                diagonalUp(i, 0);
            for (int i = 1; i < N - 1; i++)
                diagonalUp(N - 1, i);

            fileWriter.close();
}
    public  String getFilePath(){
        return  String.format("./QueenGen/coding%d.cnf",N);
    }
}
