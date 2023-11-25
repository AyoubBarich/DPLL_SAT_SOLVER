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
