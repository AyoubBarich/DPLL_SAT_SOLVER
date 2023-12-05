import java.util.*;

public class DPLL {
    public ArrayList solveFirstFail(Formule formule) {

        Stack<Literal> literalStack = new Stack<>();
        System.out.println(literalStack + "1");
        ArrayList<List<Literal>> modeles = new ArrayList<>();

        System.out.println("while1 " + formule.assignedLiteralList.contains(0) + " " + formule.isFormulaSatisfaisaible());
        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {
            Literal assignedLiteral = formule.assignLiteralFirstFail(true);
            literalStack.push(assignedLiteral);
            System.out.println(literalStack);

            if (formule.isFormulaSatisfaisaible() != null) {
                if (formule.isFormulaSatisfaisaible().equals(true)) {
                    ArrayList<Literal> modele = new ArrayList<>();

                    for (Literal literalFormule : formule.getLiteralsFromFormule()) {

                        if (formule.assignedLiteralList.get(formule.literalList.indexOf(literalFormule)) == 1) {
                            modele.add(literalFormule);
                        }
                    }
                    modeles.add(modele);
                }
                break;
            }
        }
        System.out.println("a");

        while (!literalStack.isEmpty()){
            System.out.println(literalStack);
            System.out.println("while 2 "+ !literalStack.isEmpty());
           Literal litChangAssignement = literalStack.pop();
            System.out.println(literalStack);
           formule.affectTruthValue(litChangAssignement, !litChangAssignement.getTruthValue());
            System.out.println("c");
           for (Literal literal : formule.getLiteralsFromFormule()){
               if ((formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (literal != litChangAssignement)){
                   formule.desaffectTruthValue(literal);
               }
           }
            System.out.println("d");
            System.out.println("while 3 " + formule.assignedLiteralList.contains(0) +" "+ (formule.isFormulaSatisfaisaible()==null));
            System.out.println("e");
            while((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)){
                System.out.println(formule.assignedLiteralList);
               Literal literalAffected = formule.assignLiteralFirstFail(true);
               literalStack.push(literalAffected);

               if (formule.isFormulaSatisfaisaible() != null) {
                   if (formule.isFormulaSatisfaisaible().equals(true)) {
                       ArrayList<Literal> modele = new ArrayList<>();

                       for (Literal literalFormule : formule.getLiteralsFromFormule()) {

                           if (formule.assignedLiteralList.get(formule.literalList.indexOf(literalFormule)) == 1) {
                               modele.add(literalFormule);
                           }
                       }

                       modeles.add(modele);
                   }
                   break;
               }
           }
        }

        return modeles;
    }
}

        //element constant
     /*   LiteralClauses literalClauses = new LiteralClauses(formule);
        ClauseLiterals clauseLiterals = new ClauseLiterals(formule);

        //Dynamic elements
        ArrayList<Integer> vectEtatClause = formule.vecteurEtatClause();
        ArrayList<Integer> vectLongClause = formule.vecteurLongeurClause();

        Queue<Literal> literalQueue = new ArrayDeque<>();
        Literal fisrtToTest = formule.getFistToTest();
        fisrtToTest.setTruthValue(true);
        formule.affectTruthValue(fisrtToTest,true);
        literalQueue.add(fisrtToTest);
        while (!literalQueue.isEmpty()){Literal totest = formule.getFistToTest();}*/

//        while (formule.assignedLiteralList.contains(0)) {
//            System.out.println(formule.assignedLiteralList);
////           if (!formule.isFormulaSatisfaisaible())
////            {
////                break;
////            }*/
////
////            formule.affectTruthValue(firstLiteral, true);
////            literalStack.add(firstLiteral);
//            while (!literalStack.isEmpty()) {
//                Literal literal = literalStack.pop();
//                //formule.affectTruthValue(literal, !literal.getTruthValue());
///*            if (formule.isFormulaSatisfaisaible()){
//                break;}*/
//            }
//        }
//    }
//
//}
