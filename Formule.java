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
    public boolean isEmpty(){return clauses.isEmpty() ;}

    public ArrayList<Literal> getLiteralsFromFormule(){
        ArrayList<Literal> literaux = new ArrayList<>();
        for (Clause clause : this.clauses){
            for (Literal literal : clause.getLiterals()){
                if (!literaux.contains(literal)){
                    literaux.add(literal);
                }
            }
        }
        return literaux ;
    }

    public ArrayList<Literal> getPureLiterals(){
        ArrayList<Literal> pureLiteral = new ArrayList<>();
        ArrayList<Literal> literals = this.getLiteralsFromFormule();
        for (Literal literal : literals) {
                Literal opposite = literal.getIntegerValue() % 2 == 0 ? new Literal(literal.getIntegerValue()-1) : new Literal( literal.getIntegerValue() +1 );
                if (!literals.contains(opposite)){
                    pureLiteral.add(literal);
                }
            }

        return pureLiteral;
    }

    public boolean isFormulaSatisfaisaible(){
        ArrayList<Clause> allClauses = this.clauses;
        for (Clause clause : allClauses){
            if (!clause.isSatisfaisable() == true){
                return false;
            }
        }
        return true;
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
