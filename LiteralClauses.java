import java.util.HashMap;
import java.util.LinkedList;


public class LiteralClauses {

    public HashMap<Literal, LinkedList<Clause>> makeHashMap(Formule formule) {
        HashMap<Literal, LinkedList<Clause>> literalClauses = new HashMap<>();
        LinkedList<Clause> clauseDuLiteral = new LinkedList<>() ;
        for (Literal literal : formule.getClause().getLiterals()) {
            for (Clause clause : formule.getClause()) {
                if (!clauseDuLiteral.contains(clause)) {
                    clauseDuLiteral.add(clause);
                }
            }

            literalClauses.put(literal,clauseDuLiteral);

            }
        return literalClauses;
        }

    }
}