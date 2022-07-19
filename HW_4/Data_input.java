package HW_4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Data_input {
    public List<String> Vvod_dannych(){
        System.out.println("Введите арифметическое выражение.");
        System.out.println("Допустимы только целые числа. Дробные могут быть введены как отношение целых в выражении.");
        System.out.println("Например, число 0,25 это 1/4.");
        System.out.println("Допустимы бинарные операции: +, -, *, /, %, ^.");
        System.out.println("Допустимо вводить функции sin(), cos(), tg(), ln(), lg(), exp().");
        System.out.println("Вычисление функций sin(), cos(), tg(), ведется из предположения, что аргумент передан в радианах.");
        System.out.println("При необходимости ввода числа Пи введите pi, числа e - введите e (лат.).");
        System.out.println("Допускаются только круглые скобки.");
        System.out.printf("Ваше выражение: ");
        Scanner sc = new Scanner(System.in);
        String raw_s = sc.nextLine().trim();
        String s = raw_s.toLowerCase().replaceAll("\\s+", "");
        
        Queue<String> chisla = new LinkedList<>();
        Queue<String> func = new LinkedList<>();
        Stack<String> skobki = new Stack<>();
        List<Character> operands = List.of('+','-','*','/','^', '%');
        List<Character> mist = List.of('[',']','{','}','<','>');

        List<String> ls = new ArrayList<>();
        char [] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ')' && skobki.empty()){
                System.out.println("Введенное выражение содержит ошибку. Проверьте скобки.");
                System.exit(1);
            } else if(mist.contains(arr[i])){
                System.out.println("Введенное выражение содержит ошибку. Проверьте скобки.");
                System.exit(1);
            } else if(arr[i] == ')' && !skobki.empty()){
                String ch = Sergant_Mnogonozhko(chisla);
                String f = Sergant_Mnogonozhko(func);
                if(ch!="") ls.add(ch);
                if(f!="") ls.add(f);
                ls.add(Character.toString(arr[i]));
                skobki.pop();
            }else if(arr[i]=='('){
                String ch = Sergant_Mnogonozhko(chisla);
                String f = Sergant_Mnogonozhko(func);
                if(ch!="") ls.add(ch);
                if(f!="") ls.add(f);
                ls.add(Character.toString(arr[i]));
                skobki.push(Character.toString(arr[i]));
            }else if(operands.contains(arr[i])){
                String ch = Sergant_Mnogonozhko(chisla);
                String f = Sergant_Mnogonozhko(func);
                if(ch!="") ls.add(ch);
                if(f!="") ls.add(f);
                ls.add(Character.toString(arr[i]));
            }else if(Character.isDigit(arr[i])){
                chisla.add(Character.toString(arr[i]));
            }else if(Character.isAlphabetic(arr[i])){
                func.add(Character.toString(arr[i]));
            }
        }
       
        String ch1 = Sergant_Mnogonozhko(chisla);
        String f1 = Sergant_Mnogonozhko(func);
        if(ch1!="") ls.add(ch1);
        if(f1!="") ls.add(f1);
        
        if(!skobki.empty()){
            System.out.println("Введенное выражение содержит ошибку. Проверьте скобки.");
            System.exit(1);
        }
        sc.close();
        if(ls.isEmpty()){
            System.out.println("Введенное выражение содержит ошибку.");
            System.exit(1);
        }
        return ls;
    }
    private String Sergant_Mnogonozhko(Queue<String> bronetransporter){
        String res="";
        if(!bronetransporter.isEmpty()){
            while(!bronetransporter.isEmpty()){
                res+=bronetransporter.poll();
            }
        }
        return res;
    }
}