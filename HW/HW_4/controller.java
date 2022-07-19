package HW.HW_4;

import java.util.List;

public class controller {
    public void Postfix_notation(String[] args) {
        data_input dv = new data_input();
        List<String> ls = dv.Vvod_dannych();
        postfix pf = new postfix();
        List<String> ls1 = pf.in_postfix(ls);
        view pl = new view();
        pl.printList(ls1);
        double res = pf.calc(ls1);
        System.out.printf("Результат вычисления: %.4f",res);
    }
}