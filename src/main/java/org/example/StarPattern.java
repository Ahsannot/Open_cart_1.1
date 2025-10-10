package org.example;

import java.util.Scanner;

public class StarPattern {

    int number ;

    public StarPattern(int number){
        this.number = number;
    }

    public void squarePattern(){
        for (int i = 1 ; i <= number ; i++ ){
            for (int j = 1 ; j <= i ; j++ ){
                System.out.print(" * ");
            }
            System.out.println("   ");
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter a number :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StarPattern sp = new StarPattern(n);
        sp.squarePattern();

        sc.close();
    }
}
