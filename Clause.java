import java.util.ArrayList;
import java.util.List;

public class Clause {
    private ArrayList<Literal> literals ;


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
    public boolean contains(Literal literal){
        return  literals.contains(literal);
    }
}
