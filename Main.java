import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Literal x = new Literal(1);
        Literal _x = new Literal(2);
        Literal z =  new Literal(3);
        Literal _z = new Literal(4);
        Clause xor_x = new Clause(new ArrayList<>(List.of(x,_x)));
        Clause zor_z = new Clause(new ArrayList<>(List.of(z,_z)));
        Clause mono = new Clause(5);
        Formule formule = new Formule(new ArrayList<>(List.of(xor_x,zor_z,mono)));

        System.out.println(formule.getLiteralsFromFormule());
        System.out.println(formule.getClauses());
        LiteralClauses literalClauses = new LiteralClauses(formule);
        System.out.println(literalClauses);
        ClauseLiterals clauseLiterals = new ClauseLiterals(formule);
        System.out.println(clauseLiterals);
    }
}
