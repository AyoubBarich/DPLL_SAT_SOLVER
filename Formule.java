import java.util.ArrayList;

public class Formule {
    private ArrayList<Clause> clauses ;

    public Formule(ArrayList<Clause> _clauses){
        clauses = _clauses;
    }

    public ArrayList<Clause> getClauses() {
        return clauses;
    }
    public void insert(Clause clause){
        clauses.add(clause);
    }

    public ArrayList<Literal> getLiteralsFromFormule(){
        ArrayList<Literal> literaux = new ArrayList<>();
        for (Clause clause : this.getClauses()){
            for (Literal literal : clause.getLiterals()){
                if (!clause.contains(literal)){
                    literaux.add(literal);
                }
            }
        }
        return literaux ;
    }

    @Override
    public String toString() {
        return "Formule{" +
                "clauses=" + clauses +
                '}';
    }
/*    public boolean contains(Clause clause){
        return clauses.contains(clause);

    }*/
}
