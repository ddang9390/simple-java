package com.company;

import java.util.Scanner;

public class Main {

    //user input
    public static void input(){
        String s = new String();
        Scanner reader = new Scanner(System.in);

        System.out.print("What is your name?   ");
        s = reader.next();

        if(s.equals("Alice") || s.equals("Bob")){ //only recognize users named Alice or Bob
            System.out.println("Welcome back " + s);
        }
        else{
            System.out.println("Who is u");
        }
    }

    //sum of numbers that are divisible by 3 or 5
    public static void nums(){
        String s = new String();
        int n;
        int sum = 0;
        Scanner reader = new Scanner(System.in);
        boolean status = false;

        while(status == false) {
            System.out.print("Please enter a number: ");
            s = reader.next();
            if(s.matches("\\d+")){
                status = true;
            }
            else{
                System.out.println("Integers only!");
            }
        }

        n = Integer.parseInt(s);
        for(int i=0; i <= n; i++){
            if(i%3 == 0 || i%5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    //prints multiplication table
    public static void multable(){
        System.out.println("1  2  3  4  5  6  7  8  9  10  11  12");
        System.out.println("-------------------------------------");

        for(int i = 1; i <= 12; i++){
            System.out.print(i + "|");
            for(int j = 1; j <= 12; j++){
                System.out.print(" " + i*j + " ");
            }
            System.out.println();
        }
    }

    //check if input is a prime number
    public static void checkPrime(){
        String s = new String();
        int n;
        Scanner reader = new Scanner(System.in);
        boolean status = false;

        while(status == false) {
            System.out.print("Please enter a number: ");
            s = reader.next();
            if(s.matches("\\d+")){
                status = true;
            }
            else{
                System.out.println("Integers only!");
            }
        }
        n = Integer.parseInt(s);
        boolean isNotPrime = true;
        if(n == 0 || n == 1){
            System.out.println(n + " is not a prime number");
        }
        else{
            for(int i = 2; i < n; i++){
                if(n%i == 0){
                    System.out.println(n + " is not a prime number");
                    isNotPrime = false;
                    break;
                }
            }
            if(isNotPrime == true){
                System.out.println(n + " is a prime number");
            }
        }
    }

    //prints prime numbers up to number user inputted
    public static void primes(){
        String s = new String();
        int n;
        Scanner reader = new Scanner(System.in);
        boolean status = false;

        while(status == false) {
            System.out.print("Please enter a number: ");
            s = reader.next();
            if(s.matches("\\d+")){
                status = true;
            }
            else{
                System.out.println("Integers only!");
            }
        }

        boolean isPrime = true;
        n = Integer.parseInt(s);
        if(n == 0 || n == 1){
            System.out.println(n + " is not a prime number");
        }
        else{
            for(int i = 2; i <= n; i++){
                for(int j = 2; j < i; j++){
                    if(i%j == 0){
                        isPrime = false;
                    }
                }
                if(isPrime == true){
                    System.out.println(i);
                }
                isPrime = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        hangman.main(args);
    }
}
