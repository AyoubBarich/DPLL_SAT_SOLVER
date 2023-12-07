import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DPPL2 {
    public ArrayList solveFirstSatisfyUnique2(Formule formule) {
        System.out.println(formule);
        Stack<Literal> literalStack = new Stack<>();

        ArrayList<HashMap<Boolean, ArrayList<Literal>>> modeles = new ArrayList<>();
//        System.out.println(formule.literalList);
//        System.out.println(formule.assignedLiteralList);

        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {

            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal assignedLiteral = formule.assignLiteralFirstTail(true);
//            System.out.println("assignedLiteral " + assignedLiteral);
//            System.out.println("assignedLiteral " + assignedLiteral.getTruthValue());
//            System.out.println(formule.assignedLiteralList);

            literalStack.push(assignedLiteral);
//            System.out.println("literalStack " + literalStack);
//            System.out.println("formule.isFormulaSatisfaisaible() != null  " + (formule.isFormulaSatisfaisaible() != null));
            if (formule.isFormulaSatisfaisaible() != null) {
//                System.out.println("a");
//                System.out.println("1" + formule.isFormulaSatisfaisaible());
                if (formule.isFormulaSatisfaisaible()) {
                    ArrayList<Literal> modeleTrue = new ArrayList<>();
                    ArrayList<Literal> modeleFalse = new ArrayList<>();
                    ArrayList<Literal> modelenull = new ArrayList<>();
//                    System.out.println(formule.getLiteralsFromFormule());
                    for (Literal literalFormule : formule.getLiteralsFromFormule()) {
//                        System.out.println(literalFormule.getTruthValue());
                        if (literalFormule.getTruthValue() != null) {
                            if (literalFormule.getTruthValue()) {
                                modeleTrue.add(literalFormule);
                            } else {
                                modeleFalse.add(literalFormule);
                            }
                        } else {
                            modelenull.add(literalFormule);
                        }
                    }
                    modele.put(Boolean.TRUE, modeleTrue);
                    modele.put(Boolean.FALSE, modeleFalse);
                    modele.put(null, modelenull);
                    modeles.add(modele);
                    return modeles;
                }
                break;
            }
        }


        while (!literalStack.isEmpty()) {
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();
            // On récupère le dernier litéral de la pile sans le retirer
            Literal lastInStack = literalStack.peek();
            // On retire toutes les constantes qui ne sont pas dans la pile
            for (Literal literal : formule.getLiteralsFromFormule()) {

                // On veut désafecter ceux qui ne sont pas contenus dans la pile, mais attention aux opposés !!
                if ((!literal.equals(lastInStack.opposite())) & (formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (!literalStack.contains(literal)) & (!literalStack.contains(literal.opposite()))) {
                    formule.desaffectTruthValue(literal);
                }

            }

            formule.affectTruthValue(lastInStack, !lastInStack.getTruthValue());
            if (formule.isFormulaSatisfaisaible() == null) {

                while ((formule.isFormulaSatisfaisaible() == null) & (formule.assignedLiteralList.contains(0))) {
                    HashMap<Boolean, ArrayList<Literal>> modele1 = new HashMap<>();
                    Literal assignedLiteral = formule.assignLiteralFirstTail(true);
                    literalStack.push(assignedLiteral);
                    if (formule.isFormulaSatisfaisaible() != null) {
                        if (formule.isFormulaSatisfaisaible()) {
                            ArrayList<Literal> modeleTrue = new ArrayList<>();
                            ArrayList<Literal> modeleFalse = new ArrayList<>();
                            ArrayList<Literal> modelenull = new ArrayList<>();
                            for (Literal literalFormule : formule.getLiteralsFromFormule()) {
                                if (literalFormule.getTruthValue() != null) {
                                    if (literalFormule.getTruthValue()) {
                                        modeleTrue.add(literalFormule);
                                    } else {
                                        modeleFalse.add(literalFormule);
                                    }
                                } else {
                                    modelenull.add(literalFormule);
                                }
                            }
                            modele.put(Boolean.TRUE, modeleTrue);
                            modele.put(Boolean.FALSE, modeleFalse);
                            modele.put(null, modelenull);
                            modeles.add(modele);
                            return modeles;
                        }


                    }
                }

            } else if (formule.isFormulaSatisfaisaible())  {

                ArrayList<Literal> modeleTrue = new ArrayList<>();
                ArrayList<Literal> modeleFalse = new ArrayList<>();
                ArrayList<Literal> modelenull = new ArrayList<>();
                for (Literal literalFormule : formule.getLiteralsFromFormule()) {
//                        System.out.println(literalFormule.getTruthValue());
                    if (literalFormule.getTruthValue() != null) {
                        if (literalFormule.getTruthValue()) {
                            modeleTrue.add(literalFormule);
                        } else {
                            modeleFalse.add(literalFormule);
                        }
                    } else {
                        modelenull.add(literalFormule);
                    }
                }
                modele.put(Boolean.TRUE, modeleTrue);
                modele.put(Boolean.FALSE, modeleFalse);
                modele.put(null, modelenull);
                modeles.add(modele);
                return modeles;
            }
            literalStack.pop();


        }
        return modeles;
    }
}




