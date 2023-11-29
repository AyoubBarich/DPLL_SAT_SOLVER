import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class StandardParser implements Parser {
    @Override
    public Formule parse(String filePath) throws FileNotFoundException {
        Reader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Stream<String> stream = bufferedReader.lines();
        List<String[]> clauses = stream.filter(line -> line.endsWith("0"))
                .map(str -> str.replaceAll(".$","") )
                .map(s -> s.split("\\s+"))
                .toList();
        ArrayList<Clause> clauses1 = new ArrayList<>();
        for (String[] str : clauses){
            ArrayList<Literal> literals = new ArrayList<>();
            for (String string: Arrays.stream(str).filter(s -> !s.isEmpty()).toList()) {
                    literals.add(new Literal(transformLiteralToIndex(Integer.parseInt(string))));
                }
            if (!literals.isEmpty()) {
                clauses1.add(new Clause(literals));
            }
            }
            return new Formule(clauses1);
        }

    private static int transformLiteralToIndex(int literal){
        return literal >= 0 ? 2*literal : (-literal*2) -1 ;
    }


}
