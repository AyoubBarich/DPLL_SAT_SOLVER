import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) throws IOException {
        Literal x = new Literal(1,"x");
        Literal _x = new Literal(2,"x");
        Literal z =  new Literal(3,"z");
        Literal _z = new Literal(4,"z");
        Clause xor_x = new Clause(new ArrayList<>(List.of(x,_x)));
        Clause zor_z = new Clause(new ArrayList<>(List.of(z,_z)));
        Clause mono = new Clause(5,"m");
        Formule formule = new Formule(new ArrayList<>(List.of(xor_x,zor_z,mono)));

        System.out.println(formule.getLiteralsFromFormule());
        System.out.println(formule.getClauses());
        LiteralClauses literalClauses = new LiteralClauses(formule);
        System.out.println(literalClauses);
        ClauseLiterals clauseLiterals = new ClauseLiterals(formule);
        System.out.println(clauseLiterals);
    }
}
