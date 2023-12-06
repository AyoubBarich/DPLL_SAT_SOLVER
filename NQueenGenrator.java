import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class NQueenGenrator {

    static int N ;
    static int clauses = 0;
    static char[][] board = new char[N][N];
    static FileWriter fileWriter;
    public NQueenGenrator(int n){
        N = n;

        try {
            System.out.println(N);
            fileWriter = new FileWriter("./QueenGen/coding"+N+".cnf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void diagonalDown(int x, int y) throws IOException {
        int i, j;
        for (; x < N - 1 && y < N - 1; x++, y++)
            for (i = x + 1, j = y + 1; i < N && j < N; i++, j++) {
                fileWriter.write("-" + queen(x, y) + " -" + queen(i, j) + " 0\n");
                clauses++;
            }
    }

    static void diagonalUp(int x, int y) throws IOException {
        int i, j;
        for (; x > 0 && y < N - 1; x--, y++)
            for (i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
                fileWriter.write("-" + queen(x, y) + " -" + queen(i, j) + " 0\n");
                clauses++;
            }
    }

    static int queen(int x, int y) {
        return x * N + y + 1;
    }

    static int row(int c) {
        return (c - 1) / N;
    }

    static int col(int c) {
        return (c - 1) % N;
    }

    public void generate() throws IOException {
        int i, j, q, k;

        for (k = 0; k < N; k++) {
            for (i = 0; i < N - 1; i++)
                for (j = i + 1; j < N; j++) {
                    fileWriter.write("-" + queen(k, i) + " -" + queen(k, j) + " 0\n");
                    clauses++;
                    fileWriter.write("-" + queen(i, k) + " -" + queen(j, k) + " 0\n");
                    clauses++;
                }

            for (i = 0; i < N; i++)
                fileWriter.write(queen(k, i) + " ");
            fileWriter.write("0\n");
            clauses++;
        }

        for (i = 0; i < N - 1; i++)
            diagonalDown(0, i);
        for (i = 1; i < N - 1; i++)
            diagonalDown(i, 0);
        for (i = 1; i < N; i++)
            diagonalUp(i, 0);
        for (i = 1; i < N - 1; i++)
            diagonalUp(N - 1, i);

        fileWriter.close();

    }
    public  String getFilePath(){
        return  String.format("./QueenGen/coding%d.cnf",N);
    }

}
