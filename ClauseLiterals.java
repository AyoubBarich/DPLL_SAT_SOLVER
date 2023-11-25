import java.util.HashMap;
import java.util.LinkedList;

public class ClauseLiterals {

    public HashMap<Clause, LinkedList<Literal>> clauseLiterals;
    public ClauseLiterals(Formule formule){
        this. clauseLiterals = this.getClauseLiterals(formule);
    }

    public HashMap<Clause, LinkedList<Literal>> getClauseLiterals(Formule formule) {
        HashMap<Clause, LinkedList<Literal>> clauseLiterals = new HashMap<>();


        for (Clause clause : formule.getClauses()){
            LinkedList<Literal> literalDeLaClause = new LinkedList<>() ;
            for (Literal literal : clause.getLiterals()){
                if (clause.contains(literal) & (!literalDeLaClause.contains(literal))){
                    literalDeLaClause.add(literal);
                }
            }

            clauseLiterals.put(clause,literalDeLaClause);
        }
        return clauseLiterals;
    }
}