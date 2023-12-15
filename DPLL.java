import java.util.*;

public class DPLL {

    // DPLL First Fail
    public ArrayList solveFirstFail(Formule formule) {
        System.out.println(formule);
        Stack<Literal> literalStack = new Stack<>();

        ArrayList<HashMap<Boolean, ArrayList<Literal>>> modeles = new ArrayList<>();

        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal assignedLiteral = formule.assignLiteralFirstFail(true);
            literalStack.push(assignedLiteral);

            if (formule.isFormulaSatisfaisaible() != null) {
                if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                }
                break;
            }
        }


        while (!literalStack.isEmpty()){
            System.out.println(literalStack);
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();
           Literal litChangAssignement = literalStack.pop();
           formule.affectTruthValue(litChangAssignement, !litChangAssignement.getTruthValue());

            for (Literal literal : formule.getLiteralsFromFormule()){
               if ((literal != litChangAssignement) & (!literal.equals(litChangAssignement.opposite())) & (formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (!literalStack.contains(literal)) & (!literalStack.contains(literal.opposite()))){
                   formule.desaffectTruthValue(literal);
               }

           }

            while((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)){
               Literal literalAffected = formule.assignLiteralFirstFail(true);
               literalStack.push(literalAffected);

                if (formule.isFormulaSatisfaisaible() != null) {
                    if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                    }
                    break;
                }
                   }
                   break;
               }

            return modeles;
    }

    public ArrayList solveFirstFailUnique(Formule formule) {
        System.out.println(formule);
        Stack<Literal> literalStack = new Stack<>();

        ArrayList<HashMap<Boolean, ArrayList<Literal>>> modeles = new ArrayList<>();
//        System.out.println(formule.literalList);
//        System.out.println(formule.assignedLiteralList);
//        System.out.println(formule.getlitValueT());

        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {

            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal assignedLiteral = formule.assignLiteralFirstFail(true);
//            System.out.println("assignedLiteral " + assignedLiteral);
//            System.out.println("assignedLiteral " + assignedLiteral.getTruthValue());
//            System.out.println(formule.assignedLiteralList);
//            System.out.println(formule.getlitValueT());

            literalStack.push(assignedLiteral);
//            System.out.println("literalStack " + literalStack);
//            System.out.println("formule.isFormulaSatisfaisaible()"+" " + formule.isFormulaSatisfaisaible());
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


//        System.out.println("c");
        while (!literalStack.isEmpty()){
//            System.out.println("literalStack" +"  " + literalStack);
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal litChangAssignement = literalStack.peek();
//            System.out.println("litChangAssignement " + litChangAssignement + " " + !litChangAssignement.getTruthValue());


            formule.affectTruthValue(litChangAssignement, !litChangAssignement.getTruthValue());
            Stack literalStackCopy = (Stack) literalStack.clone();




            for (Literal literal : formule.getLiteralsFromFormule()){

                if ((literal != litChangAssignement) & (!literal.equals(litChangAssignement.opposite())) & (formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (!literalStack.contains(literal)) & (!literalStack.contains(literal.opposite()))){
                    formule.desaffectTruthValue(literal);
                }

            }
//            System.out.println("literal modifié : " + litChangAssignement +" "+litChangAssignement.opposite());
//            System.out.println( "LiteralList" + formule.literalList);
//            System.out.println("assigned literal liste " + formule.assignedLiteralList);
//            System.out.println("null ? "+ (formule.isFormulaSatisfaisaible() == null));


            while((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null) &(!literalStackCopy.equals(literalStack))){
//                System.out.println("Debut nouvelle sous branche");

                Literal literalAffected = formule.assignLiteralFirstFail(true);
//                System.out.println("literalAffected " + literalAffected + " " + literalAffected.getTruthValue());
//                System.out.println(literalAffected + " affected "+literalAffected.getAffectationCounter());
                if(literalAffected.getAffectationCounter() > 1 ){
                    break;
                }
                literalStackCopy.push(literalAffected);

//                System.out.println(formule.assignedLiteralList);

//                System.out.println("formule satisfaisable "+ formule.isFormulaSatisfaisaible());
                if (formule.isFormulaSatisfaisaible() != null) {
                    if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                        return(modeles);
                    }
                    break;
                }
            }
            Literal deleteLiteral =literalStack.pop();
            literalStack.removeElement(deleteLiteral.opposite());
//            System.out.println("literalStack" + literalStack);
        }

        return modeles;
    }


    // DPLL FirstSatisfy
    public ArrayList solveFirstSatisfy(Formule formule) {

        System.out.println(formule);
        Stack<Literal> literalStack = new Stack<>();

        ArrayList<HashMap<Boolean, ArrayList<Literal>>> modeles = new ArrayList<>();


        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal assignedLiteral = formule.assignLiteralFirstTail(true);
            literalStack.push(assignedLiteral);

            if (formule.isFormulaSatisfaisaible() != null) {
                if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                }
                break;
            }
        }


        while (!literalStack.isEmpty()){
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal litChangAssignement = literalStack.pop();

            formule.affectTruthValue(litChangAssignement, !litChangAssignement.getTruthValue());

            for (Literal literal : formule.getLiteralsFromFormule()){

                if ((literal != litChangAssignement) & (!literal.equals(litChangAssignement.opposite())) & (formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (!literalStack.contains(literal)) & (!literalStack.contains(literal.opposite()))){
                    formule.desaffectTruthValue(literal);
                }

            }

            while((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)){

                Literal literalAffected = formule.assignLiteralFirstTail(true);
                literalStack.push(literalAffected);

                if (formule.isFormulaSatisfaisaible() != null) {
                    if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                    }
                    break;
                }
            }
            break;
        }

        return modeles;
    }

    public ArrayList solveFirstSatisfyUnique(Formule formule) {
        System.out.println(formule);
        Stack<Literal> literalStack = new Stack<>();

        ArrayList<HashMap<Boolean, ArrayList<Literal>>> modeles = new ArrayList<>();
//        System.out.println(formule.literalList);
//        System.out.println(formule.assignedLiteralList);
//        System.out.println(formule.getlitValueT());

        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {

            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal assignedLiteral = formule.assignLiteralFirstTail(true);
//            System.out.println("assignedLiteral " + assignedLiteral);
//            System.out.println("assignedLiteral " + assignedLiteral.getTruthValue());
//            System.out.println(formule.assignedLiteralList);
//            System.out.println(formule.getlitValueT());

            literalStack.push(assignedLiteral);
//            System.out.println("literalStack " + literalStack);
//            System.out.println("formule.isFormulaSatisfaisaible()"+" " + formule.isFormulaSatisfaisaible());
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


//        System.out.println("c");
        while (!literalStack.isEmpty()){
//            System.out.println("literalStack" +"  " + literalStack);
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal litChangAssignement = literalStack.peek();
//            System.out.println("litChangAssignement " + litChangAssignement + " " + !litChangAssignement.getTruthValue());


            formule.affectTruthValue(litChangAssignement, !litChangAssignement.getTruthValue());
            Stack literalStackCopy = (Stack) literalStack.clone();




            for (Literal literal : formule.getLiteralsFromFormule()){

                if ((literal != litChangAssignement) & (!literal.equals(litChangAssignement.opposite())) & (formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (!literalStack.contains(literal)) & (!literalStack.contains(literal.opposite()))){
                    formule.desaffectTruthValue(literal);
                }

            }
//            System.out.println("literal modifié : " + litChangAssignement +" "+litChangAssignement.opposite());
//            System.out.println( "LiteralList" + formule.literalList);
//            System.out.println("assigned literal liste " + formule.assignedLiteralList);
//            System.out.println("null ? "+ (formule.isFormulaSatisfaisaible() == null));


            while((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null) &(!literalStackCopy.equals(literalStack))){
//                System.out.println("Debut nouvelle sous branche");

                Literal literalAffected = formule.assignLiteralFirstTail(true);
//                System.out.println("literalAffected " + literalAffected + " " + literalAffected.getTruthValue());
//                System.out.println(literalAffected + " affected "+literalAffected.getAffectationCounter());
                if(literalAffected.getAffectationCounter() > 1 ){
                    break;
                }
                literalStackCopy.push(literalAffected);

//                System.out.println(formule.assignedLiteralList);

//                System.out.println("formule satisfaisable "+ formule.isFormulaSatisfaisaible());
                if (formule.isFormulaSatisfaisaible() != null) {
                    if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                        return(modeles);
                    }
                    break;
                }
            }
            Literal deleteLiteral =literalStack.pop();
            literalStack.removeElement(deleteLiteral.opposite());
//            System.out.println("literalStack" + literalStack);
        }

        return modeles;
    }

    public ArrayList solveRandom(Formule formule) {
        System.out.println(formule);
        Stack<Literal> literalStack = new Stack<>();

        ArrayList<HashMap<Boolean, ArrayList<Literal>>> modeles = new ArrayList<>();


        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal assignedLiteral = formule.assignLiteralRandom(true);
            literalStack.push(assignedLiteral);

            if (formule.isFormulaSatisfaisaible() != null) {
                if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                }
                break;
            }
        }


        while (!literalStack.isEmpty()){
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal litChangAssignement = literalStack.pop();

            formule.affectTruthValue(litChangAssignement, !litChangAssignement.getTruthValue());


            for (Literal literal : formule.getLiteralsFromFormule()){

                if ((literal != litChangAssignement) & (!literal.equals(litChangAssignement.opposite())) & (formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (!literalStack.contains(literal)) & (!literalStack.contains(literal.opposite()))){
                    formule.desaffectTruthValue(literal);
                }

            }

            while((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)){

                Literal literalAffected = formule.assignLiteralRandom(true);
                literalStack.push(literalAffected);

                if (formule.isFormulaSatisfaisaible() != null) {
                    if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                    }
                    break;
                }
            }
            break;
        }

        return modeles;
    }

    public ArrayList solveRandomUnique(Formule formule) {
        System.out.println(formule);
        Stack<Literal> literalStack = new Stack<>();

        ArrayList<HashMap<Boolean, ArrayList<Literal>>> modeles = new ArrayList<>();
//        System.out.println(formule.literalList);
//        System.out.println(formule.assignedLiteralList);
//        System.out.println(formule.getlitValueT());

        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {

            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal assignedLiteral = formule.assignLiteralRandom(true);
//            System.out.println("assignedLiteral " + assignedLiteral);
//            System.out.println("assignedLiteral " + assignedLiteral.getTruthValue());
//            System.out.println(formule.assignedLiteralList);
//            System.out.println(formule.getlitValueT());

            literalStack.push(assignedLiteral);
//            System.out.println("literalStack " + literalStack);
//            System.out.println("formule.isFormulaSatisfaisaible()"+" " + formule.isFormulaSatisfaisaible());
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


//        System.out.println("c");
        while (!literalStack.isEmpty()){
//            System.out.println("literalStack" +"  " + literalStack);
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal litChangAssignement = literalStack.peek();
//            System.out.println("litChangAssignement " + litChangAssignement + " " + !litChangAssignement.getTruthValue());


            formule.affectTruthValue(litChangAssignement, !litChangAssignement.getTruthValue());
            Stack literalStackCopy = (Stack) literalStack.clone();




            for (Literal literal : formule.getLiteralsFromFormule()){

                if ((literal != litChangAssignement) & (!literal.equals(litChangAssignement.opposite())) & (formule.assignedLiteralList.get(formule.literalList.indexOf(literal)) == 1) & (!literalStack.contains(literal)) & (!literalStack.contains(literal.opposite()))){
                    formule.desaffectTruthValue(literal);
                }

            }
//            System.out.println("literal modifié : " + litChangAssignement +" "+litChangAssignement.opposite());
//            System.out.println( "LiteralList" + formule.literalList);
//            System.out.println("assigned literal liste " + formule.assignedLiteralList);
//            System.out.println("null ? "+ (formule.isFormulaSatisfaisaible() == null));


            while((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null) &(!literalStackCopy.equals(literalStack))){
//                System.out.println("Debut nouvelle sous branche");

                Literal literalAffected = formule.assignLiteralRandom(true);
//                System.out.println("literalAffected " + literalAffected + " " + literalAffected.getTruthValue());
//                System.out.println(literalAffected + " affected "+literalAffected.getAffectationCounter());
                if(literalAffected.getAffectationCounter() > 1 ){
                    break;
                }
                literalStackCopy.push(literalAffected);

//                System.out.println(formule.assignedLiteralList);

//                System.out.println("formule satisfaisable "+ formule.isFormulaSatisfaisaible());
                if (formule.isFormulaSatisfaisaible() != null) {
                    if (formule.isFormulaSatisfaisaible().equals(true)) {
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
                        return(modeles);
                    }
                    break;
                }
            }
            Literal deleteLiteral =literalStack.pop();
            literalStack.removeElement(deleteLiteral.opposite());
//            System.out.println("literalStack" + literalStack);
        }

        return modeles;
    }


}


