package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    String[] words = {"word", "choice", "amalgamation", "it", "comprehensive"};
    List<Character> inputs = new ArrayList<Character>();
    List<Character> correct = new ArrayList<Character>();
    int index = 0;

    String s;
    String answer;
    char c;

    Scanner reader = new Scanner(System.in);
    boolean status = false;
    boolean gameClear = false;

    int tries = 6;


    public void input(String word){
        if(tries > 0 || !gameClear) {
            while (status == false) {
                System.out.print("Please enter a letter: ");
                s = reader.next();
                if (Character.isLetter(s.charAt(0))) {
                    c = s.charAt(0);
                    if(inputs.toString().indexOf(c) >= 0){
                        System.out.println("You already entered that letter");
                    }
                    else{
                        inputs.add(c);
                        index++;

                        status = true;
                        check(word, c, countLetters(answer));
                    }
                } else {
                    System.out.println("Letters only!");
                }
            }
            status = false;
        }
        else{
            System.out.println("Game Over");
            gameClear = true;
        }
    }

    public void check(String ss, char cc, int total){
        System.out.println(inputs);
        if(ss.indexOf(cc) >= 0){
            for(char ccc : inputs) { //does not print correctly
                for (char x : ss.toCharArray()) {
                    if (x == ccc) {
                        
                        System.out.print(ccc + " ");

                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
        }
        else{
            tries--;
            System.out.println("Wrong. You have " + tries + " tries left"); //does not handle wrong answers properly
        }
        if(total == (index)){
            System.out.println("Congratulations!");
            tries = 0;
            gameClear = true;
        }
    }

    public int countLetters(String s){
        boolean[] itsThere = new boolean[Character.MAX_VALUE];
        for(int i = 0; i < s.length(); i++){
            itsThere[s.charAt(i)] = true;
        }
        int count = 0;
        for(int i = 0; i < itsThere.length; i++){
            if(itsThere[i] == true){
                count++;
            }
        }
        return count;
    }

    public void hang(){
        Random random = new Random();
        int ind = random.nextInt(4) + 0;

        answer = words[ind];

        System.out.println("We will be playing hangman and you get 6 tries!");

        System.out.println(inputs.toString());
        for(char c : answer.toCharArray()){
            System.out.print("_ ");
        }
        System.out.println();

        while(tries > 0 || !gameClear) {
            input(answer);
        }

    }

    public static void main(String[] args) {
        try{
            hangman game = new hangman();
            game.hang();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
