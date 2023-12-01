import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tester {
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

    public static void main(String[] args) throws IOException {
/*        Literal x = new Literal(1);
        Literal _x = new Literal(2);
        Literal z =  new Literal(3);
        Literal _z = new Literal(4);
        Literal y = new Literal(5);
        Literal _y = new Literal(6);
        Clause un = new Clause(new ArrayList<>(List.of(x,z,_y)));
        Clause deux = new Clause(new ArrayList<>(List.of(z,x,y)));
        Literal troisLit = new Literal(7);
        Clause trois = new Clause(new ArrayList<>(List.of(troisLit)));
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

        System.out.println(formule);
        System.out.println(formule.getPureLiterals());
        assert (formule.getPureLiterals().equals(new ArrayList<>(List.of(x,z,new Literal(7)))));
        assert (x.getProprety().equals(LiteralProprety.PUR));
        assert (trois.getProprety().equals(LiteralProprety.MONO));

    }
    @Test
    public void isSatisfaisableTest(){
        Literal A = new Literal(9);
        A.setTruthValue(false);
        System.out.println(A.getTruthValue());
        Literal Y = new Literal(11);
        Y.setTruthValue(true);
        Literal O = new Literal(13);
        O.setTruthValue(false);
        Literal U = new Literal(15);
        U.setTruthValue(true);
        Literal B = new Literal(17);
        B.setTruthValue(true);

        Clause b = new Clause(new ArrayList<>(List.of(A,Y,O)));
        Clause g = new Clause(new ArrayList<>(List.of(U,B)));

        Formule ilGère = new Formule(new ArrayList<>(List.of(b,g)));
        System.out.println(ilGère);
        System.out.println(b.isSatisfaisable());
        assert(b.isSatisfaisable() == true);
        assert(g.isSatisfaisable() == true);
        assert(ilGère.isFormulaSatisfaisaible() == true);


    }

    @Test
    public void affectTrurhValueTest(){
        Literal t = new Literal(19);
        Literal _t = new Literal(20);
        Literal b =  new Literal(21);
        Literal _b = new Literal(22);
        Literal o = new Literal(23);
        Literal _o = new Literal(24);

        Clause tuGèresLaFougère = new Clause(new ArrayList<>(List.of(b,o,t,_o)));
        Clause weLoveCow = new Clause(new ArrayList<>(List.of(_t,_b)));

        Formule formule1 = new Formule(new ArrayList<>(List.of(tuGèresLaFougère,weLoveCow)));
        formule1.affectTruthValue(t,true);
        assert(t.getTruthValue() == true);
        assert(_t.getTruthValue() == false);

    }
    @Test
    public void getClauseValueTest(){
        Literal t = new Literal(19);
        Literal _t = new Literal(20);
        Literal b =  new Literal(21);
        Literal _b = new Literal(22);
        Literal o = new Literal(23);
        Literal _o = new Literal(24);

        Clause tuGèresLaFougère = new Clause(new ArrayList<>(List.of(b,o,t,_o)));
        Clause weLoveCow = new Clause(new ArrayList<>(List.of(_t,_b)));

        Formule formule1 = new Formule(new ArrayList<>(List.of(tuGèresLaFougère,weLoveCow)));
        assert(formule1.getClauseValue(tuGèresLaFougère) == 0);
        assert(formule1.getClauseValue(weLoveCow) == 1);
    }

}
