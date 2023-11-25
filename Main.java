import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Literal x = new Literal(1);
        Literal y = new Literal(2);
        Clause xory = new Clause(new ArrayList<>(List.of(x,y)));
        System.out.println(xory);
    }
}
