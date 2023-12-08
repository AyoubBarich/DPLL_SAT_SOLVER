import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PigeonGenrator {


    public PigeonGenrator(int n) throws IOException {


        int i, k;  // pigeons i, k
        int j;     // hole j
        System.out.println("Number of pigeon holes");

        FileWriter fileWriter = new FileWriter(String.format("./Pigeon/Pigeon%d.cnf",n));

        // DIMACS header
        fileWriter.write(String.format("p cnf %d %d\n", (n+1) * n, (n+1) + n * (n * (n+1) / 2)));

        // n+1 clauses which say that a pigeon has to be placed in some hole
        for (i=1; i <= n+1; i++) {
            for (j=1; j <= n; j++)
                fileWriter.write(String.format("%d ", n*(i-1)+j));
            fileWriter.write("0\n");
        }

        // for each hole we have a set of clauses ensuring that only one single
        // pigeon is placed into that hole
        for (j=1; j <= n; j++)
            for (i=1; i <= n; i++)
                for (k=i+1; k <= n+1; k++)
                    fileWriter.write(String.format("-%d -%d 0\n", n*(i-1)+j, n*(k-1)+j));

        fileWriter.close();
    }

}

