package org.example;

public class Factorial {
    int number ;
    int fac = 1 ;

    public Factorial(int number){
        this.number = number;
    }

    public void calculateFactorial(){
        if (number<0){
            System.out.println("No factorial");
            return;
        }
        for (int i = 1; i<= number; i++){
            fac *= i;
        }
        System.out.println("Factorial of " + number + " is: " + fac);
    }
    public static void main(String[] args) {
        Factorial ff = new Factorial(5);
        ff.calculateFactorial();
    }
}
