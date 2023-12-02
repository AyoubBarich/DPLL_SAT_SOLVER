import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DPLL {
    public void solve(Formule formule){
        //element constant
        LiteralClauses literalClauses = new LiteralClauses(formule);
        ClauseLiterals clauseLiterals = new ClauseLiterals(formule);

        //Dynamic elements
        ArrayList<Integer> vectEtatClause = formule.vecteurEtatClause();
        ArrayList<Integer> vectLongClause = formule.vecteurLongeurClause();

        Queue<Literal> literalQueue = new ArrayDeque<>();
        Literal fisrtToTest = formule.getFistToTest();
        fisrtToTest.setTruthValue(true);
        formule.affectTruthValue(fisrtToTest,true);
        literalQueue.add(fisrtToTest);
        while (!literalQueue.isEmpty()){
            Literal totest = formule.getFistToTest();



        }


    }

}
