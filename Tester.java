import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) throws IOException {
        Literal x = new Literal(1,"x");
        Literal _x = new Literal(2,"x");
        Literal z =  new Literal(3,"z");
        Literal _z = new Literal(4,"z");
        Clause un = new Clause(new ArrayList<>(List.of(x,_x)));
        Clause deux = new Clause(new ArrayList<>(List.of(z,_z)));
        Clause trois = new Clause(5,"m");
        Formule formule = new Formule(new ArrayList<>(List.of(un,deux,trois)));

        System.out.println("Litéraux d'une formule" + formule.getLiteralsFromFormule());
        System.out.println("Clauses d'une formule" + formule.getClauses()); 
        LiteralClauses literalClauses = new LiteralClauses(formule);
        System.out.println(literalClauses);
        ClauseLiterals clauseLiterals = new ClauseLiterals(formule);
        System.out.println(clauseLiterals);
    }
}
