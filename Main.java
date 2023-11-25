import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Literal x = new Literal(1,"x");
        Literal _x = new Literal(2,"x");
        Literal z =  new Literal(3,"z");
        Literal _z = new Literal(4,"z");
        Clause xor_x = new Clause(new ArrayList<>(List.of(x,_x)));
        Clause zor_z = new Clause(new ArrayList<>(List.of(z,_z)));
        Clause mono = new Literal(5,"m");
        Formule formule = new Formule(new ArrayList<>(List.of(xor_x,zor_z,mono)));
        System.out.println(mono.getLiterals().get(0).getProprety());
        System.out.println(formule);
    }
}
