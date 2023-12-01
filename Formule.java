import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

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
                    if(!literal.getProprety().equals(LiteralProprety.MONO)) { literal.setProprety(LiteralProprety.PUR);}
                    pureLiteral.add(literal);
                }
            }

        return pureLiteral;
    }


    public boolean isFormulaSatisfaisaible(){
        ArrayList<Clause> allClauses = this.clauses;
        boolean condition = true;
        for (Clause clause : allClauses){
            if (condition) {
                condition = Boolean.logicalAnd(condition,clause.isSatisfaisable());
            }
        }
        return condition;
    }


    public void affectTruthValue(Literal literal, Boolean literalTruthValue) {
        // On définit la valeur du litéral
        literal.setTruthValue(literalTruthValue);
        literal.hasBeenAffected=true;
        // On cherche s'il existe dans la formule son négatif:
        removeLiteralAfterAssignment(literal);
        int value = literal.getIntegerValue();

        ArrayList<Literal> literals = this.getLiteralsFromFormule();
        for (Literal elementOfLiterals : literals) {
            if (value % 2 == 0) {
                if (elementOfLiterals.getIntegerValue() == value - 1) {
                    elementOfLiterals.setTruthValue(!literalTruthValue);
                    removeLiteralAfterAssignment(elementOfLiterals);
                }
            } else {
                if (elementOfLiterals.getIntegerValue() == value + 1) {
                    elementOfLiterals.setTruthValue(!literalTruthValue);
                    removeLiteralAfterAssignment(elementOfLiterals);
                }
            }

        }
    }
    public void removeLiteralAfterAssignment(Literal literal){
        if (literal.getTruthValue()) {
            int i=0;
            for (Clause clause : clauses) {
                if (clause.contains(literal)){
                    clause.stasfiable =true;
                    this.vecteurEtatClause().add(i,1);
                }

                i++;
            }
        }
    }

    public void Assign(){

    }

    public Literal firstSastify() {
        ArrayList<Integer> counter = new ArrayList<>();
        ArrayList<Literal> literalsInFormula = getLiteralsFromFormule();
        for (int i = 0; i <= literalsInFormula.size(); i++) {
            counter.add(0);
        }
        for (Literal literal : literalsInFormula) {
            int index = literalsInFormula.indexOf(literal);
            for (Clause clause : getClauses()) {
                if ((clause.contains(literal))|(clause.contains(literal.opposite()))) {
                    counter.add(index, counter.get(index) + 1);
                }
            }
        }
        return literalsInFormula.get(counter.indexOf(Collections.max(counter)));

    }

    public Literal firstFail(){

        ArrayList<Literal> literalsInFormula = getLiteralsFromFormule();
        ArrayList<Integer> counter = new ArrayList<>();
        for (int i = 0; i <= literalsInFormula.size(); i++) {
            counter.add(0);
        }
        for (Literal literal : literalsInFormula) {
            if(literal.getIntegerValue()%2 == 1){
            int index = literalsInFormula.indexOf(literal);
            for (Clause clause : getClauses()) {
                if (clause.contains(literal.opposite())) {
                    counter.add(index, counter.get(index) + 1);
                }
            }
        }
        }
        return literalsInFormula.get(counter.indexOf(Collections.max(counter)));


    }


    public void assignTrueFirstFail(){
        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();
        for (Clause clause : clauses) {
            if (clause.isMono()) {
                clause.getliteralFromMonoClause().setTruthValue(true);
                break;
            }
        }
        if(pureLiterals.size() != 0){
            pureLiterals.getFirst().setTruthValue(true);
        }
        else {
            this.firstFail().setTruthValue(true);
        }
    }


    public ArrayList<Integer> vecteurEtatClause(){
        ArrayList<Integer> vec = new ArrayList<>();
        for(Clause clause : this.getClauses()){
            vec.add(0);
        }
        return vec;
    }
    public ArrayList<Integer> vecteurLongeurClause(){
        ArrayList<Integer> vec = new ArrayList<>();
        for(Clause clause : this.getClauses()){
            vec.add(clause.size());
        }
        return vec;

    }

    public ArrayList<Integer> modifValueVecteur(ArrayList<Integer> vector ,Literal literal, boolean truthValue){
        literal.setTruthValue(truthValue);
        for(Clause clause : this.getClauses()){
           int index = this.getClauses().indexOf(clause);
           if ((clause.contains(literal)) & (clause.isSatisfaisable())){
               vector.add(index, literal.getIntegerValue());
           }
        }
        return vector;
    }

    public Literal getMono(){
        for (Clause clause :this.getClauses()){
            if (clause.isMono()){return  clause.getliteralFromMonoClause();}
        }
        return null;

    }
    public Literal getFistToTest(){
        return this.getMono()==null?this.getPureLiterals().isEmpty()?this.heuristique():getPureLiterals().get(0):this.getMono();
    }
    public Literal heuristique(){return this.getLiteralsFromFormule().get(0);}

    public int getClauseValue(Clause clause){
        int index = this.clauses.indexOf(clause);
        return index ;
    }


    @Override
    public String toString() {
        return "Formule{" +
                "clauses=" + clauses +
                '}';
    }

    public Formule assignTrue() {
        return null;
    }

    public Formule assignFalse() {
        return null;
    }
/*    public boolean contains(Clause clause){
        return clauses.contains(clause);

    }*/
}
