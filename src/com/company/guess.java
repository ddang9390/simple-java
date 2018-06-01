package com.company;

import java.util.Random;
import java.util.Scanner;

public class guess {
    String s;
    int n;
    Scanner reader;
    boolean status = false;
    boolean gameClear = false;

    int tries = 5;

    public guess(){
        this.s = new String();
        this.reader = new Scanner(System.in);
    }

    public void input(){
        if(tries > 0) {
            while (status == false) {
                System.out.print("Please enter a number: ");
                s = reader.next();
                if (s.matches("\\d+")) {
                    status = true;
                } else {
                    System.out.println("Integers only!");
                }
            }
            this.n = Integer.parseInt(s);
            tries--;
            status = false;
        }
        else{
            System.out.println("Game Over");
            gameClear = true;
        }
    }

    public void game(){
        Random random = new Random();
        int answer = random.nextInt(100) + 1;

        System.out.println("Lets start the game!");
        System.out.println("You have 5 tries to guess the I chose from 1-100");

        input();
        while(gameClear == false){
            if(n == answer){
                gameClear = true;
                System.out.println("Congratulations!");
            }
            else if(n < answer){
                System.out.println("Your answer is less than expected");
                input();
            }
            else{
                System.out.println("Your answer is greater than expected");
                input();
            }
        }
        System.out.println("The correct answer was " + answer);
    }

    public static void main(String[] args) {
        try{
            guess Game = new guess();
            Game.game();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
