import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DPPL2 {
    public ArrayList solveFirstSatisfyUnique2(Formule formule) {
        System.out.println(formule);

        // Initialisation des variables
        Stack<Literal> literalStack = new Stack<>();
        ArrayList<HashMap<Boolean, ArrayList<Literal>>> modeles = new ArrayList<>();

        // Initialisation de la pile
       while ((formule.assignedLiteralList.contains(0)) &(formule.isFormulaSatisfaisaible() == null)){
           HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();
           Literal litAssigned = formule.assignLiteralFirstTail(true);
           literalStack.push(litAssigned);

           //On regarde si formules avec variables assignées valide formule ou pas
           if (formule.isFormulaSatisfaisaible() != null){
               if (formule.isFormulaSatisfaisaible()){
                   ArrayList<Literal> modeleTrue = new ArrayList<>();
                   ArrayList<Literal> modeleFalse = new ArrayList<>();
                   ArrayList<Literal> modelenull = new ArrayList<>();

                   for (Literal literalFormule : formule.getLiteralsFromFormule()) {

                       if (literalFormule.getTruthValue() != null) {
                           if(literalFormule.getTruthValue()) {
                               modeleTrue.add(literalFormule);
                           }else{
                               modeleFalse.add(literalFormule);
                           }
                       }else{
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

       while(!literalStack.isEmpty()){
           System.out.println(literalStack);

           Literal litToBeChanged = literalStack.peek();
           HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();


           // Si a deja été affecté deux fois ne sert à rien

           if (formule.assignedLiteralList.get(formule.literalList.indexOf(litToBeChanged)) < 2){
               System.out.println("done");

               for (Literal literal : formule.getLiteralsFromFormule()){
                   if ((literal != litToBeChanged) & (!literal.equals(litToBeChanged.opposite())) & (formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (!literalStack.contains(literal)) & (!literalStack.contains(literal.opposite()))){
                       System.out.println("literal" + literal );
                       formule.desaffectTruthValue(literal);
                   }

               }

               formule.affectTruthValue(litToBeChanged,!litToBeChanged.getTruthValue());


               if (formule.isFormulaSatisfaisaible() != null){
                   if (formule.isFormulaSatisfaisaible()){
                       ArrayList<Literal> modeleTrue = new ArrayList<>();
                       ArrayList<Literal> modeleFalse = new ArrayList<>();
                       ArrayList<Literal> modelenull = new ArrayList<>();

                       for (Literal literalFormule : formule.getLiteralsFromFormule()) {

                           if (literalFormule.getTruthValue() != null) {
                               if(literalFormule.getTruthValue()) {
                                   modeleTrue.add(literalFormule);
                               }else{
                                   modeleFalse.add(literalFormule);
                               }
                           }else{
                               modelenull.add(literalFormule);
                           }
                       }
                       modele.put(Boolean.TRUE, modeleTrue);
                       modele.put(Boolean.FALSE, modeleFalse);
                       modele.put(null, modelenull);
                       modeles.add(modele);
                       System.out.println("Merci Monsieur pour vos cours !");
                       return modeles;
                   }
                   //ou return modeles, on est arrivé au bout de notre arbre DPLL
               }

               while ((formule.assignedLiteralList.contains(0)) &(formule.isFormulaSatisfaisaible() == null)){

                   Literal litAssigned = formule.assignLiteralFirstTail(true);
                   literalStack.push(litAssigned);

                   //On regarde si formules avec variables assignées valide formule ou pas
                   if (formule.isFormulaSatisfaisaible() != null){
                       if (formule.isFormulaSatisfaisaible()){
                           ArrayList<Literal> modeleTrue = new ArrayList<>();
                           ArrayList<Literal> modeleFalse = new ArrayList<>();
                           ArrayList<Literal> modelenull = new ArrayList<>();

                           for (Literal literalFormule : formule.getLiteralsFromFormule()) {

                               if (literalFormule.getTruthValue() != null) {
                                   if(literalFormule.getTruthValue()) {
                                       modeleTrue.add(literalFormule);
                                   }else{
                                       modeleFalse.add(literalFormule);
                                   }
                               }else{
                                   modelenull.add(literalFormule);
                               }
                           }
                           modele.put(Boolean.TRUE, modeleTrue);
                           modele.put(Boolean.FALSE, modeleFalse);
                           modele.put(null, modelenull);
                           modeles.add(modele);
                           System.out.println("Merci Monsieur pour vos cours !");
                           return modeles;
                       }
                       break;  //ou return modeles, on est arrivé au bout de notre arbre DPLL
                   }
               }
               literalStack.pop();
           }
       }
        System.out.println("Merci Monsieur pour vos cours !");
       return modeles;
    }

//    public int getNumberOfModele(Formule formule){
//
//        ArrayList<HashMap<Boolean,Literal>> modeles = this.solveFirstSatisfyUnique2(formule);
//        int numModele = modeles.size();
//        int counterNullValue = 0;
//        for (HashMap<Boolean,Literal> modele : modeles){
//            ArrayList<Literal> listeOfNull = modele.get(NULL);
//
//        }
//    }
}




