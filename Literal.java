import java.util.ArrayList;
import java.util.List;

public class Literal extends Clause {
    private int integerValue;
    private   Boolean truthValue;
    private String variableName;

    public Literal(int assignedIntegerValue,String assignedVariableName){
        super(new Literal(assignedIntegerValue,assignedVariableName));
        integerValue = assignedIntegerValue;
        truthValue = assignedIntegerValue%2 !=0;
        variableName  = assignedVariableName;

    }



    public Boolean getTruthValue() {
        return truthValue;
    }
    public int getIntegerValue() {
        return integerValue;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
        this.truthValue = integerValue%2 !=0;
    }

    @Override
    public boolean equals(Object obj) {
        return integerValue == ((Literal) obj).getIntegerValue();
    }
    @Override
    public String toString(){
        return  truthValue? "<- "+variableName+" , Value : "+integerValue+" >":"< "+variableName+" , Value : "+integerValue+" >";
    }
}
