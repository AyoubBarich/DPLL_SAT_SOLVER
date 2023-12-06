import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    Literal x = new Literal(1);
    Literal _x = new Literal(2);
    Literal z =  new Literal(3);
    Literal _z = new Literal(4);
    Literal y = new Literal(5);
    Literal _y = new Literal(6);
    Clause un = new Clause(new ArrayList<>(List.of(x,z,_y)));
    Clause deux = new Clause(new ArrayList<>(List.of(z,x,y)));
    Clause trois = new Clause(7);
    Formule formule = new Formule(new ArrayList<>(List.of(un,deux,trois)));
    Literal t = new Literal(19);
    Literal _t = new Literal(20);
    Literal b =  new Literal(21);
    Literal _b = new Literal(22);
    Literal o = new Literal(23);
    Literal _o = new Literal(24);

    Clause tuGeresLaFougere = new Clause(new ArrayList<>(List.of(b,o,t,_o)));
    Clause weLoveCow = new Clause(new ArrayList<>(List.of(_t,_b)));



    public static void main(String[] args) throws IOException {
/*        Literal x = new Literal(1);
        Literal _x = new Literal(2);
        Literal z =  new Literal(3);
        Literal _z = new Literal(4);
        Literal y = new Literal(5);
        Literal _y = new Literal(6);
        Clause un = new Clause(new ArrayList<>(List.of(x,z,_y)));
        Clause deux = new Clause(new ArrayList<>(List.of(z,x,y)));
        Literal troisLit = new Literal(7);
        Clause trois = new Clause(new ArrayList<>(List.of(troisLit)));
        Formule formule = new Formule(new ArrayList<>(List.of(un,deux,trois)));

        System.out.println("Litéraux d'une formule" + formule.getLiteralsFromFormule());
        System.out.println("Clauses d'une formule" + formule.getClauses()); 
        LiteralClauses literalClauses = new LiteralClauses(formule);
        System.out.println(literalClauses);
        ClauseLiterals clauseLiterals = new ClauseLiterals(formule);
        System.out.println(clauseLiterals);*/
        StandardParser parser = new StandardParser();
        System.out.println(parser.parse("./Inputs/testcnf.cnf"));
    }
    @Test
    public void isMonoTest(){
        Clause clause = new Clause(new ArrayList<>(List.of(x)));
        Clause clause2 = new Clause(new ArrayList<>(List.of(x,y)));
        assert(clause.isMono()==true);
        assert(clause2.isMono()==false);


    }

    @Test
    public void oppositeTest(){
        assert(x.opposite().equals( _x));
    }

    @Test
    public void setTruthValue(){
        Literal literalTest = new Literal(65);
        Literal literalTest2 = new Literal(95);
        literalTest.setTruthValue(false);
        assert(literalTest.getTruthValue() == false);
        literalTest2.setTruthValue(true);
        assert(literalTest2.getTruthValue() == true);
    }
    @Test
    public void equalTest(){
        Literal k = new Literal(12);
        Literal j = new Literal(12);
        assert(k.equals(j));
    }

    @Test
    public void isSatisfaisableTest(){
        Literal null1 = new Literal(204);
        Literal A = new Literal(9);
        A.setTruthValue(false);
        Literal Y = new Literal(11);
        Y.setTruthValue(true);
        Literal O = new Literal(13);
        O.setTruthValue(false);
        Literal U = new Literal(15);
        U.setTruthValue(true);
        Literal B = new Literal(17);
        B.setTruthValue(true);

        Clause b = new Clause(new ArrayList<>(List.of(A,Y,O)));
        Clause g = new Clause(new ArrayList<>(List.of(null1)));

        Formule ilGere = new Formule(new ArrayList<>(List.of(b,g)));
        System.out.println(null1.getTruthValue());
        System.out.println(g);
        System.out.println(g.isSatisfaisable());

    }

    @Test
    public void isFormulaSatisfaisableTest(){
        Literal n = new Literal(101);
        n.setTruthValue(false);
        Literal e = new Literal(102);
        e.setTruthValue(null);
        Literal i =  new Literal(103);
        i.setTruthValue(null);
        Literal h = new Literal(104);
        h.setTruthValue(true);

        Clause non = new Clause(new ArrayList<>(List.of(n,e)));
        Clause no = new Clause(new ArrayList<>(List.of(i,n,h)));

        Formule nein = new Formule(new ArrayList<>(List.of(no,non)));
        System.out.println(nein);
        System.out.println(nein.isFormulaSatisfaisaible());

    }

    @Test
    public void affectTruthValueTest(){


        Formule formulea = new Formule(new ArrayList<>(List.of(tuGeresLaFougere,weLoveCow)));
        formulea.affectTruthValue(t,false);

        assert(t.getTruthValue()== false);
        assert(_t.getTruthValue() == true);


    }
    @Test
    public void getClauseValueTest(){

        Formule formule1 = new Formule(new ArrayList<>(List.of(tuGeresLaFougere,weLoveCow)));
        assert(formule1.getClauseValue(tuGeresLaFougere) == 0);
        assert(formule1.getClauseValue(weLoveCow) == 1);
    }

    @Test
    public void firstSatisfyTest(){

        Clause h = new Clause(new ArrayList<>(List.of(x,_x,_t)));
        Clause i = new Clause(new ArrayList<>(List.of(t,_t,b,x)));
        Clause hi = new Clause(new ArrayList<>(List.of(_t,_x,x)));
        Formule formule2 = new Formule(new ArrayList<>(List.of(h,i,hi)));

        assert(formule2.firstSatisfy().equals(x));



    }
    @Test
    public void firstTailTest(){

        Clause h = new Clause(new ArrayList<>(List.of(x,_x,_t)));
        Clause i = new Clause(new ArrayList<>(List.of(t,_t,b,x)));
        Clause hi = new Clause(new ArrayList<>(List.of(_t,_x,x)));
        Formule formule2 = new Formule(new ArrayList<>(List.of(h,i,hi)));

        assert(formule2.firstFail().equals(t));

    }

    @Test
    public void assignLiteralFirstFailTest(){

        Literal x = new Literal(1);
        Literal _x = new Literal(2);
        Literal z =  new Literal(3);
        Literal _z = new Literal(4);
        Literal y = new Literal(5);



        Clause Ayoub = new Clause(new ArrayList<>(List.of(x,t,_t)));
        Clause is = new Clause(new ArrayList<>(List.of(z,x,t,_z,y,_t,_x)));
        Clause beauGosse = new Clause(new ArrayList<>(List.of(y,_x,_t,x)));
        Clause isntIt = new Clause(new ArrayList<>(List.of(z)));
        Formule bgOfTheWorld = new Formule(new ArrayList<>(List.of(Ayoub, is, beauGosse, isntIt)));
        System.out.println(bgOfTheWorld);


        Literal littest1 = bgOfTheWorld.assignLiteralFirstFail(false);
        System.out.println(littest1);
        assert(littest1 == z);
        assert(z.getTruthValue() == false);
        System.out.println(littest1);
        ArrayList<Integer> testList = new ArrayList<>(List.of(1,0,0,0,1,1,0,0));
        System.out.println("index of 1 " + testList.indexOf(1));
        System.out.println(bgOfTheWorld.literalList);
        System.out.println(bgOfTheWorld.assignedLiteralList);
        System.out.println(testList);
        assert(bgOfTheWorld.assignedLiteralList.equals(testList));
        Literal litTest = bgOfTheWorld.assignLiteralFirstFail(false);
        System.out.println(litTest);
        assert(litTest.equals(y));
        System.out.println(y);
        Literal litest2 = bgOfTheWorld.assignLiteralFirstFail(false);
//        System.out.println(litest2);
//        assert(litest2.equals(t));

    }

    @Test
    public void assignLiteralFirstTailTest(){

        Literal x = new Literal(1);
        Literal _x = new Literal(2);
        Literal z =  new Literal(3);
        Literal _z = new Literal(4);
        Literal y = new Literal(5);



        Clause Ayoub = new Clause(new ArrayList<>(List.of(x,_x,t,_t)));
        Clause is = new Clause(new ArrayList<>(List.of(z,x,t,_z,y,_t,_x)));
        Clause beauGosse = new Clause(new ArrayList<>(List.of(y,_x,_t,x)));
        Clause isntIt = new Clause(new ArrayList<>(List.of(z)));
        Formule bgOfTheWorld = new Formule(new ArrayList<>(List.of(Ayoub, is, beauGosse, isntIt)));
        System.out.println(bgOfTheWorld);


        Literal littest1 = bgOfTheWorld.assignLiteralFirstTail(true);

        assert(littest1 == z);
        assert(z.getTruthValue()== true);
        ArrayList<Integer> testList = new ArrayList<>(List.of(1,0,0,0,0,1,1,0));
        System.out.println(bgOfTheWorld.literalList);
        System.out.println(bgOfTheWorld.assignedLiteralList);
        assert(bgOfTheWorld.assignedLiteralList.equals(testList));
        Literal litTest = bgOfTheWorld.assignLiteralFirstTail(true);
        assert(litTest.equals(y));
        System.out.println(bgOfTheWorld.assignedLiteralList);
        Literal litest2 = bgOfTheWorld.assignLiteralFirstTail(true);
        System.out.println(litest2);
        assert(litest2.equals(x));

    }

    @Test
    public void assignLiteralRandomTest() {

        Literal x = new Literal(1);
        Literal _x = new Literal(2);
        Literal z = new Literal(3);
        Literal _z = new Literal(4);
        Literal y = new Literal(5);


        Clause Ayoub = new Clause(new ArrayList<>(List.of(x, _x, t, _t)));
        Clause is = new Clause(new ArrayList<>(List.of(z, x, t, _z, y, _t, _x)));
        Clause beauGosse = new Clause(new ArrayList<>(List.of(y, _x, _t, x)));
        Clause isntIt = new Clause(new ArrayList<>(List.of(z)));
        Formule bgOfTheWorld = new Formule(new ArrayList<>(List.of(Ayoub, is, beauGosse, isntIt)));
        System.out.println(bgOfTheWorld);


        Literal littest1 = bgOfTheWorld.assignLiteralRandom(true);

        assert (littest1 == z);
        assert (z.getTruthValue()==true);
        ArrayList<Integer> testList = new ArrayList<>(List.of(1, 0, 0, 0, 0, 1, 1, 0));
        assert (bgOfTheWorld.assignedLiteralList.equals(testList));
        Literal litTest = bgOfTheWorld.assignLiteralRandom(true);
        assert (litTest.equals(y));
        Literal litTest3 = bgOfTheWorld.assignLiteralRandom(true);
        Literal liteTest4 = bgOfTheWorld.assignLiteralRandom(true);


    }

    @Test

    public void desaffecttruthvaluetest(){
        Clause Ayoub = new Clause(new ArrayList<>(List.of(x, _x, t, _t)));
        Clause is = new Clause(new ArrayList<>(List.of(z, x, t, _z, y, _t, _x)));
        Clause beauGosse = new Clause(new ArrayList<>(List.of(y, _x, _t, x)));
        Clause isntIt = new Clause(new ArrayList<>(List.of(z)));
        Formule bgOfTheWorld = new Formule(new ArrayList<>(List.of(Ayoub, is, beauGosse, isntIt)));
        System.out.println(bgOfTheWorld);
        System.out.println(x.getTruthValue());

        bgOfTheWorld.affectTruthValue(x, true);
        System.out.println(x.getTruthValue());
        System.out.println(_x.getTruthValue());

        bgOfTheWorld.desaffectTruthValue(x);
        System.out.println(x.getTruthValue());


    }

    @Test
    public void solveFirstFailTest(){

        Clause Ayoub = new Clause(new ArrayList<>(List.of(x, _x, t, _t)));
        Clause is = new Clause(new ArrayList<>(List.of(z, x, t, _z, y, _t, _x)));
        Clause beauGosse = new Clause(new ArrayList<>(List.of(y, _x, _t, x)));
        Clause isntIt = new Clause(new ArrayList<>(List.of(z)));
        Formule bgOfTheWorld = new Formule(new ArrayList<>(List.of(Ayoub, is, beauGosse, isntIt)));
        System.out.println(bgOfTheWorld);

        DPLL dpll = new DPLL();
        System.out.println(dpll.solveFirstFail(bgOfTheWorld));

    }

    @Test
    public void solveRandomTest(){

        Clause Ayoub = new Clause(new ArrayList<>(List.of(x, _x, t, _t)));
        Clause is = new Clause(new ArrayList<>(List.of(z, x, t, _z, y, _t, _x)));
        Clause beauGosse = new Clause(new ArrayList<>(List.of(y, _x, _t, x)));
        Clause isntIt = new Clause(new ArrayList<>(List.of(z)));
        Formule bgOfTheWorld = new Formule(new ArrayList<>(List.of(Ayoub, is, beauGosse, isntIt)));
        System.out.println(bgOfTheWorld);

        DPLL dpll = new DPLL();
        System.out.println(dpll.solveRandom(bgOfTheWorld));

    }

    @Test
    public void solveFirstSatisfyTest(){

        Clause Ayoub = new Clause(new ArrayList<>(List.of(x, _x, t, _t)));
        Clause is = new Clause(new ArrayList<>(List.of(z, x, t, _z, y, _t, _x)));
        Clause beauGosse = new Clause(new ArrayList<>(List.of(y, _x, _t, x)));
        Clause isntIt = new Clause(new ArrayList<>(List.of(z)));
        Formule bgOfTheWorld = new Formule(new ArrayList<>(List.of(Ayoub, is, beauGosse, isntIt)));
        System.out.println(bgOfTheWorld);

        DPLL dpll = new DPLL();
        System.out.println(dpll.solveFirstSatisfy(bgOfTheWorld));

    }

    @Test
    public void solveFirstSatisfyUniqueTest(){

        Clause Ayoub = new Clause(new ArrayList<>(List.of(_x,_y)));
        Clause is = new Clause(new ArrayList<>(List.of(z)));
        Clause bg =  new Clause(new ArrayList<>(List.of(_x)));

        Formule bgOfTheWorld = new Formule(new ArrayList<>(List.of(Ayoub, is, bg)));
        System.out.println(bgOfTheWorld);

        DPLL dpll = new DPLL();
        System.out.println(dpll.solveFirstSatisfyUnique(bgOfTheWorld));

    }
    @Test
    public void  QueenTest() throws IOException {
        NQueenGenrator nQueenGenrator = new NQueenGenrator(9);
        nQueenGenrator.generate();
        System.out.println(nQueenGenrator.getFilePath());
        StandardParser parser = new StandardParser();
         Formule formule6 = parser.parse(nQueenGenrator.getFilePath());
         DPLL dpll1 = new DPLL();
        System.out.println(dpll1.solveFirstSatisfy(formule6));

    }
}
