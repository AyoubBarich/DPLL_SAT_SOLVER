import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class Formule {
    private ArrayList<Clause> clauses ;
    public ArrayList<Literal> literalList;

    public ArrayList<Integer> assignedLiteralList ;

    public Formule(ArrayList<Clause> _clauses){
        clauses = _clauses;
        literalList = new ArrayList<>();
        literalList.add(null);
        for (Literal literal : this.getLiteralsFromFormule()){
            literalList.add(literal);
        }
        assignedLiteralList = new ArrayList<>();
        assignedLiteralList.add(1);
        for (Literal literal : this.getLiteralsFromFormule()){
            assignedLiteralList.add(0);
        }
    }
    public void changeValue(Literal literal){
        int index = literalList.indexOf(literal);
        assignedLiteralList.add(index,1);
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
        this.changeValue(literal);
        //literal.hasBeenAffected=true;
        // On cherche s'il existe dans la formule son négatif:
        removeLiteralAfterAssignment(literal);
        int value = literal.getIntegerValue();

        ArrayList<Literal> literals = this.getLiteralsFromFormule();
        for (Literal elementOfLiterals : literals) {
            if (value % 2 == 0) {
                if (elementOfLiterals.getIntegerValue() == value - 1) {
                    elementOfLiterals.setTruthValue(!literalTruthValue);
                    this.changeValue(elementOfLiterals);
                    //removeLiteralAfterAssignment(elementOfLiterals);
                }
            } else {
                if (elementOfLiterals.getIntegerValue() == value + 1) {
                    elementOfLiterals.setTruthValue(!literalTruthValue);
                    this.changeValue(elementOfLiterals);
                    //removeLiteralAfterAssignment(elementOfLiterals);
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


    public Literal firstSatisfy() {
        ArrayList<Integer> counter = new ArrayList<>();
        ArrayList<Literal> literalsInFormula = getLiteralsFromFormule();
        for (int i = 0; i <= literalsInFormula.size(); i++) {
            counter.add(0);
        }
        for (Literal literal : literalsInFormula) {
            if (assignedLiteralList.get(literalList.indexOf(literal)) ==0 ){
                int index = literalsInFormula.indexOf(literal);
                for (Clause clause : getClauses()) {
                    if ((clause.contains(literal))|(clause.contains(literal.opposite()))) {
                        counter.add(index, counter.get(index) + 1);
                    }
                }
            }
        }
        return literalsInFormula.get(counter.indexOf(Collections.max(counter)));

    }

    public Literal firstFail(){


        ArrayList<Integer> counter = new ArrayList<>();

        for (int i = 0; i <= this.literalList.size(); i++) {
            counter.add(0);
        }
        for (Literal literal : this.literalList) {
            if((literal.getIntegerValue()%2 == 1) & (assignedLiteralList.get(literalList.indexOf(literal)) == 0)){
            int index = this.literalList.indexOf(literal);
            for (Clause clause : getClauses()) {
                if (clause.contains(literal.opposite())) {
                    counter.add(index, counter.get(index) + 1);
                }
            }
        }
        }
        return this.literalList.get(counter.indexOf(Collections.max(counter)));


    }


    public void assignTrueFirstFail(){

        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();

        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0)){
                this.affectTruthValue(clause.getliteralFromMonoClause(), true);
                break;
            }
        }
        if((pureLiterals.size() != 0)&(this.assignedLiteralList.get(this.literalList.indexOf(pureLiterals.getFirst())) == 0)){
            pureLiterals.getFirst().setTruthValue(true);
            changeValue(pureLiterals.getFirst());
        }
        else {
            this.affectTruthValue(this.firstFail(),true);
        }
    }

    public void assignFalseFirstFail(){

        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();
        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0)) {
                this.affectTruthValue(clause.getliteralFromMonoClause(), false);
                break;
            }
        }
        if((pureLiterals.size() != 0)&(this.assignedLiteralList.get(this.literalList.indexOf(pureLiterals.getFirst())) == 0)){
            pureLiterals.getFirst().setTruthValue(false);
            changeValue(pureLiterals.getFirst());
        }
        else {
            this.affectTruthValue(this.firstFail(),false);
        }
    }

    public void assignTrueFirstTail(){
        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();

        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0)) {
                this.affectTruthValue(clause.getliteralFromMonoClause(), true);
                break;
            }
            break;
        }
        if((pureLiterals.size() != 0) & (this.assignedLiteralList.get(literalList.indexOf(pureLiterals.getFirst())) == 0)){
            pureLiterals.getFirst().setTruthValue(true);
            changeValue(pureLiterals.getFirst());

        }
        else {
            this.affectTruthValue(this.firstSatisfy(),true);
        }
    }

    public void assignFalseFirstTail(){

        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();
        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0)) {
                this.affectTruthValue(clause.getliteralFromMonoClause(), false);
                break;
            }
        }
        if((pureLiterals.size() != 0) & (this.assignedLiteralList.get(literalList.indexOf(pureLiterals.getFirst())) == 0)){
            pureLiterals.getFirst().setTruthValue(false);
            changeValue(pureLiterals.getFirst());
        }
        else {
            this.affectTruthValue(this.firstSatisfy(),false);
        }
    }

    public void assignTrueRandom(){

        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();
        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0)) {
                this.affectTruthValue(clause.getliteralFromMonoClause(), true);
                break;
            }
        }
        if((pureLiterals.size() != 0) & (this.assignedLiteralList.get(literalList.indexOf(pureLiterals.getFirst())) == 0)){
            pureLiterals.getFirst().setTruthValue(true);
            changeValue(pureLiterals.getFirst());
        }
        else {
            for (Literal literal : literalList) {
                if(this.assignedLiteralList.get(this.literalList.indexOf(literal)) == 0) {
                    this.affectTruthValue(this.getLiteralsFromFormule().get(0), true);
                    break;
                }
            }
        }
    }

    public void assignFalseRandom() {

        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();
        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0)) {
                this.affectTruthValue(clause.getliteralFromMonoClause(), false);
                break;
            }
        }
        if ((pureLiterals.size() != 0) & (this.assignedLiteralList.get(literalList.indexOf(pureLiterals.getFirst())) == 0)) {
            pureLiterals.getFirst().setTruthValue(false);
            changeValue(pureLiterals.getFirst());
        } else {
            for (Literal literal : literalList) {
                if (this.assignedLiteralList.get(this.literalList.indexOf(literal)) == 0) {
                    this.affectTruthValue(this.getLiteralsFromFormule().get(0), false);
                    break;
                }
            }
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
