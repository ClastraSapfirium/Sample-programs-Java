package HW;

public class hw_1{
    public static void main(String[] args) {
       int i = 0;
       int j =0;
       int count =0;
       for (i=1;i<=10;i++){
           count = 0;  
           for(j=1;j<=i;j++){
               count = count + j;
           }
               System.out.println(count);
           }
       }
   }