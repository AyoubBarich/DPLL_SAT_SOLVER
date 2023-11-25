import java.util.List;

public class Clause {
    private List<Literal> literals ;

    public Clause(List<Literal> _literals){
        literals = _literals;
    }

    public List<Literal> getLiterals() {
        return literals;
    }
    public void insert(Literal literal){
        literals.add(literal);
    }
}
