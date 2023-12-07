import java.util.ArrayList;
import java.util.List;

public class Clause {
    private ArrayList<Literal> literals ;
//    public boolean stasfiable;


    public Clause(ArrayList<Literal> _literals){
/*        super(_literals.get(0).getIntegerValue(),_literals.get(0).getVariableName());*/
        literals = _literals;

    }

    public Clause(int integerValue) {
        Literal literal = new Literal(integerValue);
        literal.setProprety(LiteralProprety.MONO);
        literals = new ArrayList<>(List.of(literal));
    }

/*

    public Clause(int integerValue, String variableName) {
        s*/
/*uper(integerValue,variableName);*//*

        super.setProprety(LiteralProprety.MONO);
        literals = new ArrayList<>(List.of(super.getClone()));

    }
*/
    public ArrayList<Literal> getLiterals() {
        return literals;
    }
    public void insert(Literal literal){
        literals.add(literal);
    }
    public void delete(Literal literal){ literals.remove(literal);}

    public boolean contains(Literal literal){
        return  literals.contains(literal);
    }

    public Boolean isSatisfaisable() {
        System.out.println(this);
        ArrayList<Literal> allLiterals = literals;
        int falseCounter = 0;
        for (Literal literal : allLiterals) {

            if (literal.getTruthValue() != null) {
                if (literal.getTruthValue()) {
                    return true;
                } else if (!literal.getTruthValue()) {
                    falseCounter++;
                    System.out.println(false);
                }
            }
        }
        if (falseCounter == allLiterals.size()) {
            return false;
        } else {
            return null;

        }
    }

    public boolean isMono(){
        if (this.literals.size() == 1){
            return true;
        }
        else{
            int counter = 0;
            for (Literal literals :this.getLiterals()){
                if (literals.getTruthValue() == null){
                    counter ++;
                }
            }
            if (counter == 1){
                return true;
            }
            return false;
        }
    }

    public Literal getLiteralFromNewMonoClause(){
        Literal litMono = new Literal(0);
        for (Literal literal : this.getLiterals()){
            if (literal.getTruthValue()==null){
                litMono = literal;
            }
        }
        return litMono;
    }
    public int size(){return this.literals.size();}

    public Literal getliteralFromMonoClause(){
        Literal litMono = new Literal(0);
        if (this.size() ==1) {
            return this.getLiterals().get(0);
        }else {

            for (Literal literal : this.getLiterals()) {
                if (literal.getTruthValue() == null) {

                    return literal;

                }
            }
        }
        return litMono;

    }

    @Override
    public String toString()
    {
        /* Construct a single string for the entire clause */
        StringBuilder clause;

        if(literals.size() == 1)
        {
            /* Pretty-print the one clause */
            clause = new StringBuilder(literals.get(0).toString());
        }
        else
        {
            clause = new StringBuilder("(" + literals.get(0).toString());

            /* Add the pretty-print version of each clause to the string */
            for(int i = 1 ; i < literals.size() ; i++)
            {
                clause.append(" V ").append(literals.get(i).toString());
            }

            clause.append(")");
        }
        return clause.toString();

    }
}
