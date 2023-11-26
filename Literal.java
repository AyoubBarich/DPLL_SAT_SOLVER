import java.util.ArrayList;
import java.util.List;

public class Literal  {
    private int integerValue;
    private   Boolean truthValue;
//    private String variableName;

    private LiteralProprety proprety;

    public Literal(int assignedIntegerValue){

        this.integerValue = assignedIntegerValue;
        this.truthValue = assignedIntegerValue%2 !=0;
//        this.variableName  = assignedVariableName;

    }




    public Boolean getTruthValue() {
        return truthValue;
    }
    public int getIntegerValue() {
        return integerValue;
    }

//    public String getVariableName() {
//        return variableName;
//    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
        this.truthValue = null;
    }

    @Override
    public boolean equals(Object obj) {
        return integerValue == ((Literal) obj).getIntegerValue();
    }
    @Override
    public String toString(){
        return "" +integerValue;
    }
    public void setProprety(LiteralProprety proprety){
        this.proprety = proprety;
    }
    public Literal getClone(){
        return new Literal(this.integerValue);
    }

    public LiteralProprety getProprety() {
        return proprety;
    }
}
