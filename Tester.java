import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tester {
    public static void main(String[] args) throws IOException {
/*        Literal x = new Literal(1);
        Literal _x = new Literal(2);
        Literal z =  new Literal(3);
        Literal _z = new Literal(4);
        Literal y = new Literal(5);
        Literal _y = new Literal(6);
        Clause un = new Clause(new ArrayList<>(List.of(x,z,_y)));
        Clause deux = new Clause(new ArrayList<>(List.of(z,x,y)));
        Clause trois = new Clause(7);
        Formule formule = new Formule(new ArrayList<>(List.of(un,deux,trois)));

        System.out.println("Litéraux d'une formule" + formule.getLiteralsFromFormule());
        System.out.println("Clauses d'une formule" + formule.getClauses()); 
        LiteralClauses literalClauses = new LiteralClauses(formule);
        System.out.println(literalClauses);
        ClauseLiterals clauseLiterals = new ClauseLiterals(formule);
        System.out.println(clauseLiterals);*/
        StandardParser parser = new StandardParser();
        System.out.println(parser.parse("./Inputs/bench-sat/5.cnf"));
    }
    @Test
    public void getLitterateursTest(){
        Literal x = new Literal(1);
        Literal _x = new Literal(2);
        Literal z =  new Literal(3);
        Literal _z = new Literal(4);
        Literal y = new Literal(5);
        Literal _y = new Literal(6);
        Clause un = new Clause(new ArrayList<>(List.of(x,z,_y)));
        Clause deux = new Clause(new ArrayList<>(List.of(z,x,y)));
        Clause trois = new Clause(7);
        Formule formule = new Formule(new ArrayList<>(List.of(un,deux,trois)));
        System.out.println(formule);
        System.out.println(formule.getPureLiterals());
        assert (formule.getPureLiterals().equals(new ArrayList<>(List.of(x,z,new Literal(7)))));

    }


}
