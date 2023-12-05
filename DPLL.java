import java.util.*;

public class DPLL {
    public void solve(Formule formule){
        //element constant
     /*   LiteralClauses literalClauses = new LiteralClauses(formule);
        ClauseLiterals clauseLiterals = new ClauseLiterals(formule);

        //Dynamic elements
        ArrayList<Integer> vectEtatClause = formule.vecteurEtatClause();
        ArrayList<Integer> vectLongClause = formule.vecteurLongeurClause();

        Queue<Literal> literalQueue = new ArrayDeque<>();
        Literal fisrtToTest = formule.getFistToTest();
        fisrtToTest.setTruthValue(true);
        formule.affectTruthValue(fisrtToTest,true);
        literalQueue.add(fisrtToTest);
        while (!literalQueue.isEmpty()){Literal totest = formule.getFistToTest();}*/
        Stack<Literal> literalStack = new Stack<>();
        while (formule.assignedLiteralList.contains(0)) {
            System.out.println(formule.assignedLiteralList);
/*            if (formule.isFormulaSatisfaisaible())
            {
                break;
            }*/
            Literal firstLiteral = formule.getFistToTest();
            formule.affectTruthValue(firstLiteral, true);
            literalStack.add(firstLiteral);
            while (!literalStack.isEmpty()) {
                Literal literal = literalStack.pop();
                formule.affectTruthValue(literal, !literal.getTruthValue());
/*            if (formule.isFormulaSatisfaisaible()){
                break;}*/
            }
        }
    }

}
