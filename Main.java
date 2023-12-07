//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.SQLOutput;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) throws IOException {
//        DPPL2 dpll = new DPPL2();
//
//        System.out.println("Choisissez votre problèmes");
//        System.out.println("a || Dames");
//        System.out.println("b || Pigeon");
//        Scanner choix = new Scanner(System.in);
//        String symb = choix.next();
//
//        System.out.println("Choissisez votre heuristique");
//        System.out.println("1 || First Satisfy");
//        System.out.println("2 || First Fail");
//        System.out.println("3 || Random");
//        Scanner choix2 = new Scanner(System.in);
//        int ent2 = choix2.nextInt();
//
//        System.out.println("Choisissez vos solutions");
//        System.out.println("a || Une seule solution");
//        System.out.println("b || Toutes les solutions");
//        Scanner choix3 = new Scanner(System.in);
//        String symb2 = choix.next();
//
//
//
//        if(symb.equals("a")){
//            System.out.println("Choisissez le nombre de Dames : ");
//            Scanner choix4 = new Scanner(System.in);
//            int nbDames = choix4.nextInt();
//
//            NQueenGenrator dames = new NQueenGenrator(nbDames);
//            dames.generate();
//            StandardParser parser1 = new StandardParser();
//            Formule formuleDame = parser1.parse(dames.getFilePath());
//
//            if (ent2 == 1){
//                if (symb2 == "a"){
//                    System.out.println(dpll.solveFirstSatisfyUnique(formuleDame));
//                }
//                else{
//                    dpll.solveFirstSatisfyUnique(formuleDame);
//                }
//            } else if (ent2 == 2) {
//                if (symb2 == "a"){
//                    dpll.solveFirstFailUnique(formuleDame);
//                }
//                else{
//                    dpll.solveFirstFail(formuleDame);
//                }
//            }else{
//                if (symb2 == "a"){
//                    dpll.solveRandomUnique(formuleDame);
//                }
//                else{
//                    dpll.solveRandom(formuleDame);
//                }
//            }
//
//            }
//
//
//        }
//
//    }

