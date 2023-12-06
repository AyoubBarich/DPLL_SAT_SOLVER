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
        Literal nullLit = new Literal(0);
        literalList.add(nullLit);
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
        assignedLiteralList.set(index,1);

    }
    public void changeValueNoMoreAffected(Literal literal){
        int index = literalList.indexOf(literal);
        assignedLiteralList.set(index,0);
    }


    public ArrayList<Clause> getClauses() {
        return clauses;
    }
    public void insert(Clause clause){
        clauses.add(clause);
    }

//    public boolean notSatisfaisable(){
////        if (this.isFormulaSatisfaisaible())
//    }
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
//        ArrayList<Literal> pureLiteral = new ArrayList<>();
//        Literal litNull = new Literal(0);
//        pureLiteral.add(litNull);
//        ArrayList<Literal> literals = this.getLiteralsFromFormule();
//        for (Literal literal : literals) {
//                Literal opposite = literal.getIntegerValue() % 2 == 0 ? new Literal(literal.getIntegerValue()-1) : new Literal( literal.getIntegerValue() +1 );
//                if (!literals.contains(opposite)){
//                    pureLiteral.add(literal);
//                }
//            }
//
//        return pureLiteral;
        ArrayList<Literal> pureLiteral = new ArrayList<>();
        Literal litNull = new Literal(0);
        pureLiteral.add(litNull);
        ArrayList<Literal> literals = this.getLiteralsFromFormule();

        for (Literal literal : literals) {

                for (Clause clause : this.getClauses()) {

                    if ((clause.isSatisfaisable() == null) & (!literals.contains(literal.opposite())) & (!pureLiteral.contains(literal))) {
                        pureLiteral.add(literal);
                    }

                }
            }


        return pureLiteral;
    }


    public Boolean isFormulaSatisfaisaible(){
        ArrayList<Clause> allClauses = this.clauses;
        int trueCounter = 0;

        for (Clause clause : allClauses){
            if(clause.isSatisfaisable() != null) {
                if (clause.isSatisfaisable().equals(false)) {
                    return false;
                } else {
                    trueCounter ++;
                }
            }

        }
        if (trueCounter == allClauses.size()){
            return true;
        }else{
            return null;
        }
    }
    public void desaffectTruthValue(Literal literal){
        literal.setTruthValue(null);
        this.changeValueNoMoreAffected(literal);
        Literal opposite = literal.opposite();

        if(this.literalList.contains(opposite)){
            Literal opo = literalList.get(literalList.indexOf(opposite));
            opo.setTruthValue(null);
            this.changeValueNoMoreAffected(opo);
        }
    }

    public void affectTruthValue(Literal literal, Boolean truthValue){

        literal.setTruthValue(truthValue);
        this.changeValue(literal);
        Literal opposite = literal.opposite();
        if(this.literalList.contains(opposite)){
            Literal opo = literalList.get(literalList.indexOf(opposite));
            opo.setTruthValue(!truthValue);
            this.changeValue(opo);
        }
    }

//    public void removeLiteralAfterAssignment(Literal literal){
//        if (literal.getTruthValue().equals(true)) {
//            int i=0;
//            for (Clause clause : clauses) {
//                if (clause.contains(literal)){
//                    clause.stasfiable =true;
//                    this.vecteurEtatClause().add(i,1);
//                }
//
//                i++;
//            }
//        }
//    }



    public Literal firstSatisfy() {
        ArrayList<Integer> counter = new ArrayList<>();
        ArrayList<Literal> literalsInFormula = getLiteralsFromFormule();
        for (int i = 0; i <= literalsInFormula.size(); i++) {
            counter.add(0);

        }
        for (Literal literal : literalsInFormula) {

            if (assignedLiteralList.get(literalList.indexOf(literal)) == 0 ){

                int index = literalsInFormula.indexOf(literal);
                for (Clause clause : getClauses()) {

                    if((clause.contains(literal.opposite()) & (clause.isSatisfaisable() == null))){
                        counter.set(index, counter.get(index) + 1);
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
                if ((clause.contains(literal.opposite())) & (clause.isSatisfaisable() == null)) {
                    counter.add(index, counter.get(index) + 1);
                }
            }
        }
        }
        return this.literalList.get(counter.indexOf(Collections.max(counter)));


    }


    public Literal assignLiteralFirstFail(boolean condition){

        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();

        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0)){
                this.affectTruthValue(clause.getliteralFromMonoClause(), condition);
                return(clause.getliteralFromMonoClause());
            }
        }


        if(pureLiterals.size() != 1 ){

            if (this.assignedLiteralList.get(this.literalList.indexOf(pureLiterals.get(1))) == 0) {

                pureLiterals.get(1).setTruthValue(condition);
                changeValue(pureLiterals.get(1));
                return (pureLiterals.get(1));
            }
        }

            Literal litFail = this.firstFail();
            this.affectTruthValue(litFail,condition);
            return (litFail);
        }




    public Literal assignLiteralFirstTail(boolean condition){
        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();

        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0) & (clause.isSatisfaisable() == null)) {
                this.affectTruthValue(clause.getliteralFromMonoClause(), condition);
                return clause.getliteralFromMonoClause();
            }

        }

        if(pureLiterals.size() != 1 ){

            if (this.assignedLiteralList.get(this.literalList.indexOf(pureLiterals.get(1))) == 0) {

                pureLiterals.get(1).setTruthValue(condition);
                changeValue(pureLiterals.get(1));
                return (pureLiterals.get(1));
            }
        }

        Literal litSat = this.firstSatisfy();
        this.affectTruthValue(litSat,condition);
        return (litSat);
    }


    public Literal assignLiteralRandom(boolean condition){

        ArrayList<Clause> clauses = this.getClauses();
        ArrayList<Literal> pureLiterals = this.getPureLiterals();
        for (Clause clause : clauses) {
            if (clause.isMono() & (this.assignedLiteralList.get(this.literalList.indexOf(clause.getliteralFromMonoClause())) == 0) & (clause.isSatisfaisable() == null)) {
                this.affectTruthValue(clause.getliteralFromMonoClause(), condition);
                return clause.getliteralFromMonoClause();
            }
        }
        if((pureLiterals.size() != 1) & (this.assignedLiteralList.get(this.literalList.indexOf(pureLiterals.get(1))) == 0)) {

            pureLiterals.get(1).setTruthValue(condition);
            changeValue(pureLiterals.get(1));
            return (pureLiterals.get(1));

//            for (Literal literal : literalList) {
//                if(this.assignedLiteralList.get(this.literalList.indexOf(literal)) == 0) {
//                    this.affectTruthValue(literal, condition);
//                    return literal;
//                }
            }

            for (Clause clause : this.clauses) {

                if (clause.isSatisfaisable() == null) {
                    for (Literal literal : literalList) {
                        if (this.assignedLiteralList.get(this.literalList.indexOf(literal)) == 0) {
                         this.affectTruthValue(literal, condition);
                         return literal;
                        }

                    }
                }
            }
            return new Literal(0);
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

    public ArrayList<Integer> modifValueVecteur(ArrayList<Integer> vector ,Literal literal, Boolean truthValue){
        literal.setTruthValue(truthValue);
        for(Clause clause : this.getClauses()){
           int index = this.getClauses().indexOf(clause);
           if ((clause.contains(literal)) & (clause.isSatisfaisable().equals(true))){
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


//    public Literal heuristique(){return this.getLiteralsFromFormule().get(0);}

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
