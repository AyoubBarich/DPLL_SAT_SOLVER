import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class LiteralClauses {


    public HashMap<Literal, LinkedList<Clause>> literalClauses ;

    public LiteralClauses(Formule formule){
         this.literalClauses = this.getLiteralClauses(formule);
    }
    public HashMap<Literal, LinkedList<Clause>> getLiteralClauses(Formule formule) {
        HashMap<Literal, LinkedList<Clause>> literalClauses = new HashMap<>();


        for (Literal literal : formule.getLiteralsFromFormule()) {
            LinkedList<Clause> clauseDuLiteral = new LinkedList<>() ;
            for (Clause clause : formule.getClauses()){
                if (clause.contains(literal) & (!clauseDuLiteral.contains(clause))){
                    clauseDuLiteral.add(clause);
                }
            }

            literalClauses.put(literal,clauseDuLiteral);
        }



        return literalClauses;
        }

    }
