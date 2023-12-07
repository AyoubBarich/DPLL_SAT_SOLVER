import java.util.ArrayList;

public class PingeonGenrator {
    private int n;
    public Formule formule = new Formule(new ArrayList<>());
    public PingeonGenrator(int nb) {
        this.n = nb;
    }


    public void allPigeonInOneHome(){
        for (int i = 1; i <= 2*n; i++) { // Pigeon
            Clause unPigeonLogéDansUnPigeonnier = new Clause(new ArrayList<>());
            if (i%2 == 1) {
                for (int k = 0; k < n; k++) { // Pigeonnier
                    unPigeonLogéDansUnPigeonnier.insert(new Literal(2 * (i + k * n) - 1));
                }
                formule.insert(unPigeonLogéDansUnPigeonnier);
            }

        }
    }


}
