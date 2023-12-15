import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        DPLL dpll = new DPLL();

        System.out.println("Choisissez votre problèmes");
        System.out.println("a || Dames");
        System.out.println("b || Pigeon");
        Scanner choix = new Scanner(System.in);
        String symb = choix.next();

        System.out.println("Choissisez votre heuristique");
        System.out.println("1 || First Satisfy");
        System.out.println("2 || First Fail");
        System.out.println("3 || Random");
        Scanner choix2 = new Scanner(System.in);
        int ent2 = choix2.nextInt();

        System.out.println("Choisissez vos solutions");
        System.out.println("a || Une seule solution");
        System.out.println("b || Toutes les solutions");
        Scanner choix3 = new Scanner(System.in);
        String symb2 = choix.next();



        if(symb.equals("a")){
            System.out.println("Choisissez le nombre de Dames : ");
            Scanner choix4 = new Scanner(System.in);
            int nbDames = choix4.nextInt();

            NQueenGenrator dames = new NQueenGenrator(nbDames);
            dames.generate();
            StandardParser parser1 = new StandardParser();
            Formule formuleDame = parser1.parse(dames.getFilePath());

            if (ent2 == 1){
                if (symb2 == "a"){
                    Timer timer_dico = new Timer("DPLL Queen start");
                    System.out.println(dpll.solveFirstSatisfyUnique(formuleDame));
                    timer_dico.print_time_past();

                }
                else{
                    Timer timer_dico = new Timer("DPLL Queen start");
                    dpll.solveFirstSatisfyUnique(formuleDame);
                    timer_dico.print_time_past();
                }
            } else if (ent2 == 2) {
                if (symb2 == "a"){
                    Timer timer_dico = new Timer("DPLL Queen start");
                    dpll.solveFirstFailUnique(formuleDame);
                    timer_dico.print_time_past();
                }
                else{
                    Timer timer_dico = new Timer("DPLL Queen start");
                    dpll.solveFirstFail(formuleDame);
                    timer_dico.print_time_past();
                }
            }else{
                if (symb2 == "a"){
                    Timer timer_dico = new Timer("DPLL Queen start");
                    dpll.solveRandomUnique(formuleDame);
                    timer_dico.print_time_past();
                }
                else{
                    Timer timer_dico = new Timer("DPLL Queen start");
                    dpll.solveRandom(formuleDame);
                    timer_dico.print_time_past();
                }
            }

            }

        if(symb.equals("b")){
            System.out.println("Choisissez le nombre de Pigeonniers: ");
            Scanner choix4 = new Scanner(System.in);
            int nbPigeonniers = choix4.nextInt();

           PigeonGenrator pigeonGenrator = new PigeonGenrator(nbPigeonniers);

            StandardParser parser1 = new StandardParser();
            Formule formulePigeon = parser1.parse(pigeonGenrator.getFilePath());

            if (ent2 == 1){
                if (symb2 == "a"){
                    Timer timer_dico = new Timer("DPLL Pigeon start");
                    System.out.println(dpll.solveFirstSatisfyUnique(formulePigeon));
                    timer_dico.print_time_past();
                }
                else{
                    Timer timer_dico = new Timer("DPLL Pigeon start");
                    System.out.println(dpll.solveFirstSatisfyUnique(formulePigeon));
                    timer_dico.print_time_past();
                }
            } else if (ent2 == 2) {
                if (symb2 == "a"){
                    Timer timer_dico = new Timer("DPLL Pigeon start");
                    System.out.println(dpll.solveFirstFailUnique(formulePigeon));
                    timer_dico.print_time_past();
                }
                else{
                    Timer timer_dico = new Timer("DPLL Pigeon start");
                    System.out.println(dpll.solveFirstFail(formulePigeon));
                    timer_dico.print_time_past();
                }
            }else{
                if (symb2 == "a"){
                    Timer timer_dico = new Timer("DPLL Pigeon start");
                    System.out.println(dpll.solveRandomUnique(formulePigeon));
                    timer_dico.print_time_past();
                }
                else{
                    Timer timer_dico = new Timer("DPLL Pigeon start");
                    System.out.println(dpll.solveRandom(formulePigeon));
                    timer_dico.print_time_past();
                }
            }

        }


        }
    private static class Timer {
        long startTime ;
        String name ;

        public Timer(String name) {
            startTime = System.currentTimeMillis();
            this.name = name;
        }

        public long time_past() {
            return System.currentTimeMillis() - startTime;
        }

        public void print_time_past() {
            String message = String.format("Timer %s : %f sec. past", name, ((double) time_past()) / 1000);
            System.out.println(message);
        }

    }

    }

