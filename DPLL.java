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
            System.out.println((formule.isFormulaSatisfaisaible() != null));
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
                    return modeles;
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
                        return modeles;
                    }
                    break;
                }
            }
            break;
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
            System.out.println((formule.isFormulaSatisfaisaible() != null));
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

        while ((formule.assignedLiteralList.contains(0)) & (formule.isFormulaSatisfaisaible() == null)) {
            HashMap<Boolean, ArrayList<Literal>> modele = new HashMap<>();

            Literal assignedLiteral = formule.assignLiteralFirstTail(true);
            literalStack.push(assignedLiteral);
            System.out.println((formule.isFormulaSatisfaisaible() != null));
            if (formule.isFormulaSatisfaisaible() != null) {
                if (formule.isFormulaSatisfaisaible().equals(true)) {
                    ArrayList<Literal> modeleTrue = new ArrayList<>();
                    ArrayList<Literal> modeleFalse = new ArrayList<>();
                    ArrayList<Literal> modelenull = new ArrayList<>();
                    System.out.println(formule.getLiteralsFromFormule());
                    for (Literal literalFormule : formule.getLiteralsFromFormule()) {
                        System.out.println(literalFormule.getTruthValue());
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
                        return(modeles);
                    }
                    break;
                }
            }
            break;
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
                    return modeles;
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
                        return modeles;
                    }
                    break;
                }
            }
            break;
        }

        return modeles;
    }

}


