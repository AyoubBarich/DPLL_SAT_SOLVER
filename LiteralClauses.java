import java.util.HashMap;
import java.util.LinkedList;



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

    public String toString() {
        return "Tableau des clauses en fonction des litéraux  "+this.literalClauses ;
    }

    }
