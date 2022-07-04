package HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class hw_3 {
    public static void main(String[] args) {
        List<List<Integer>> Log = new ArrayList<>();
        List<List<Integer>> Prom_List = new ArrayList<>();
        int n = Desk_size(); 
        Log = First_code(n);
        while(Log.size()<n*n){
            Prom_List = Serch_code(Log.get(Log.size()-1), n, Log);
            int min; int index=0;
            min = Serch_code(Prom_List.get(0),n,Log).size();
            for (List<Integer> item : Prom_List){
                if(Serch_code(item,n,Log).size()<min) {
                    min = Serch_code(item,n,Log).size();
                    index = Prom_List.indexOf(item);
                }
            }
            Log.add(Prom_List.get(index));
        }
        Narisovat_Dosku(n);
        System.out.println();
        for (List<Integer> item : Log){
            System.out.printf("%d -> ",Feeld_Number(item, n));
        }
    }
    
    public static List<List<Integer>> Serch_code(List<Integer> list, int m, List<List<Integer>> big_list){
        List<List<Integer>> res1 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if((list.get(0)-2)>=0 && (list.get(1)-1)>=0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-2);
            temp.add(list.get(1)-1);
            res1.add(temp);
        }
        if((list.get(0)-2)>=0 && (list.get(1)+1)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-2);
            temp.add(list.get(1)+1);
            res1.add(temp);
        }
        if((list.get(0)-1)>=0 && (list.get(1)-2)>=0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-1);
            temp.add(list.get(1)-2);
            res1.add(temp);
        }
        if((list.get(0)-1)>=0 && (list.get(1)+2)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-1);
            temp.add(list.get(1)+2);
            res1.add(temp);
        }
        if((list.get(0)+1)<m && (list.get(1)-2)>=0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+1);
            temp.add(list.get(1)-2);
            res1.add(temp);
        }
        if((list.get(0)+1)<m && (list.get(1)+2)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+1);
            temp.add(list.get(1)+2);
            res1.add(temp);
        }
        if((list.get(0)+2)<m && (list.get(1)-1)>=0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+2);
            temp.add(list.get(1)-1);
            res1.add(temp);
        }
        if((list.get(0)+2)<m && (list.get(1)+1)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+2);
            temp.add(list.get(1)+1);
            res1.add(temp);
        }
        for (List<Integer> item : res1) {
            if(big_list.contains(item)==false){
                res.add(item);
            }
        } 
        return res;
    }
    public static List<List<Integer>> First_code(int m){
        List<List<Integer>> Log = new ArrayList<>();
        List<Integer> Koord = new ArrayList<>();
        Random k = new Random();
        Koord.add(k.nextInt(m));
        Koord.add(k.nextInt(m));
        Log.add(Koord);
        return Log;
    }
    public static void Narisovat_Dosku(int m){
        int [][] arr = new int[m][m];
        String k = "+----+";
        for (int index = 0; index < m-1; index++) {
            k+="----+";
        } 
        System.out.print(k);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr[0].length; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                System.out.printf("| %-3d",Feeld_Number(temp, m));
            }
            System.out.print("|");
            System.out.println();
            System.out.print(k);
            System.out.println();
        }
    }
    public static int Feeld_Number(List<Integer> list, int m){   
        return list.get(0)*m+list.get(1)+1;
    }
    public static int Desk_size(){     
        int nm = Check_number();
        while(nm<5 || nm>11){
            nm=Check_number();
        }
        return nm;
    }
    public static int Check_number(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите сторону шахматной доски (целые числа не менее 5 и не более 11): \n");
        String s = sc.nextLine();
        int nmb;
        try{
            nmb = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException nfe){
            nmb = 0;
        }
        return nmb;
    }
}