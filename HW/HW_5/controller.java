package HW_5;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class controller {
    public void waveAlgorythm() throws IOException {
        data_input di = new data_input();
        List<Integer> ls = di.dannye();
        view pt=new view(); 
        int b=ls.get(0); int h = ls.get(1); int st = ls.get(2); int kon = ls.get(3);
        TreeMap<Integer,Integer> trmp = di.formiryemPole(ls);
        System.out.println("Первичное поле узлов (каждый узел имеет номер и значение в скобках):");
        System.out.println();
        pt.printTree(trmp,b,h);
        wave_alg wa = new wave_alg();
        System.out.println();
        System.out.println("В результате работы волнового алгоритма поле узлов стало таким:");
        System.out.println();
        trmp=wa.waveAlg(trmp, st, b, h, kon);
        pt.printTree(trmp,b,h);
        System.out.println();
        System.out.println("Один из кратчайших путей от начального узла к конечному:");
        pt.printStack(wa.poiskXoda(trmp, st, b, h, kon));
        System.out.println();
        

    }
}