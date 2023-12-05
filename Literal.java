import java.util.ArrayList;
import java.util.List;

public class Literal  {
    private int integerValue;
    private   Boolean truthValue;
    private Boolean hasBeenAffected;
//    private String variableName;

    private LiteralProprety proprety;

    public Literal(int assignedIntegerValue){

        this.integerValue = assignedIntegerValue;


        /*this.truthValue = assignedIntegerValue%2 !=0;*/
//        this.variableName  = assignedVariableName;

    }

    public Boolean affected(){
        return hasBeenAffected;
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
    }
    public void  setTruthValue(Boolean b){
        this.truthValue = b;
        this.hasBeenAffected = true;
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

    public Literal opposite(){
        if (this.integerValue % 2 == 0){
            return new Literal(this.integerValue - 1);
        }
        else{
            return new Literal((this.integerValue +1));
        }
    }


    public LiteralProprety getProprety() {
        return proprety;
    }
}
