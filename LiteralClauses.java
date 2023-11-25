import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class LiteralClauses {

    public HashMap<Literal, LinkedList<Clause>> makeHashMap(Formule formule) {
        HashMap<Literal, LinkedList<Clause>> literalClauses = new HashMap<>();
        LinkedList<Clause> clauseDuLiteral = new LinkedList<>() ;

        for (Clause clause : formule.getClauses()) {
            for (literal)
                if (!clauseDuLiteral.contains(clause)) {
                    clauseDuLiteral.add(clause);
                }
            }

            literalClauses.put(literal,clauseDuLiteral);


        return literalClauses;
        }

    }
}