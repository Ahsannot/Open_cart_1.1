package org.example;

public class SwipeTwoNumbers {
    int a ;
    int b ;

    public  SwipeTwoNumbers(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void swipeByTemp(){
        int temp = a;
        a = b;
        b = temp ;
    }

    public  void swipeByArithmatic(){
        a = a + b;
        a = a - b;
        b = a - b;
    }

    public  void display(){
        System.out.println("a = " + a  + ", b = " + b);
    }

    public static void main(String[] args) {
        SwipeTwoNumbers sp = new SwipeTwoNumbers(5 , 10);

        System.out.println("Before Swap:");
        sp.display();

        sp.swipeByTemp();
        // obj.swipeByArithmatic();

        System.out.println("After Swap:");
        sp.display();
    }
}
