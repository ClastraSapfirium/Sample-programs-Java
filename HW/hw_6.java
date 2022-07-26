import java.util.ArrayList;
import java.util.List;

public class hw_6 {
    public static void main(String[] args) {
        String s=" 2? + 5? = 69";
        s = s.trim().replace(target: " ", replacement: "");
        List<String> Ls = Nmbr(s);
        System.out.println(Ls);
        List<String> Ls1 = parsNmbr(Ls);
        int ch=chislo(Ls1);
        Ls = chislo2(Ls, ch);
        Ls = chislo3(Ls);
        System.out.println(ch);
        if (!Vopros(Ls)) System.out.println(x: "Решения нет");


    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
                return false;
            }
        }
    public static List<String> chislo3(List<String> Lst) {
        List<String> res = new ArreyList<>();
        int rs = 0;
        String x = Lst.get(index: 0);
        String y = Lst.get(index: 1);
        String z = Lst.get(index: 2);
        if(!isNumeric(x)){
            rs = Integer.parseInt(z)-Integer.parseInt(y);
            x= Integer.toString(rs);
        } else if(!isNumeric(y)){
            rs = Integer.parseInt(z)-Integer.parseInt(x);
            y= Integer.toString(rs);
        } else if(!isNumeric(x)){
            rs = Integer.parseInt(z)-Integer.parseInt(y);
            z= Integer.toString(rs);
        }
        res.add(x); res.add(y); res.add(z);
        return Lst;
    }
    public static List<String> chislo2(List<String> Lst, int n) {
        List<String> result = new ArreyList<>();
        String res = "";

        for (int i=0; i<Lst.size(); i++){
            int nm=Lst.get(i).length()-1;

            if(Lst.get(i).charAt(nm)=='x'){
                res = Lst.get(i).replaceAll(regex: "x", Integer.toString(n));
                result.add(res);
            } else {
                result.add(Lst.get(i));
            }
        }
        return result;
    }
    public static int chislo(List<String> Lst) {
        int res=0;
        String x = Lst.get(index:0);
        String y = Lst.get(index:1);
        String z = Lst.get(index:2);
        if(Character.isDigit(z.charAt(index:0))){
            if((Character.isDigit(z.charAt(index:0)))){
                res=Integer.parseInt(z)-Integer.parseInt(x);
                if (res<0){
                    res+=10;
                }
            }else if(Character.isDigit(y.charAt(index:0))){
                res=Integer.parseInt(z)-Integer.parseInt(y);
                if (res<0){
                    res+=10;
                }
            }
        }else{
            if((Character.isDigit(z.charAt(index:0))) && Character.isDigit(y.charAt(index:0))){
                res=Integer.parseInt(x)+Integer.parseInt(y);
                if(res>9){
                    res-=10;
                }
            }
        }
        return res;
    }
    public static List<String> parsNmbr(List<String> str) {
        List<String> res = new ArrayList<>();
        for (String item:str){
            res.add(Character.toString(item.charAt(item.length()-1)));
        }
        return res;
    }
    public static List<String> Nmbr(String s) {
        List<String> result=new ArreyList<>();
        String res="";
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                res+=s.charAt(i);
            }else{
                if(s.charAt(i)=='?'){
                    res+="?";
                }
            }
            if(s.charAt(i)=='+' && s.charAt(i)=='='){
                result.add(res);
                res="";
            }
        }
        result.add(res);
        return result;
    }
}
