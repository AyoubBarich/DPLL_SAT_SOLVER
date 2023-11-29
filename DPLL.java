import java.util.ArrayList;

public class DPLL {
    public void afecctTruthValue(Formule formule, Literal literal, Boolean literalTruthValue) {
        // On définit la valeur du litéral
        literal.setTruthValue(literalTruthValue);
        // On cherche s'il existe dans la formule son négatif:
        int value = literal.getIntegerValue();
        ArrayList<Literal> literals = formule.getLiteralsFromFormule();
        for (Literal elementOfLiterals : literals) {
            if (value % 2 == 0) {
                if (elementOfLiterals.getIntegerValue() == value - 1) {
                    elementOfLiterals.setTruthValue(!literalTruthValue);
                }
            } else {
                if (elementOfLiterals.getIntegerValue() == value + 1) {
                    elementOfLiterals.setTruthValue(!literalTruthValue);
                }
            }

        }
    }

}
