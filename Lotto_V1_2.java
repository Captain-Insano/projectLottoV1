/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lotto_V1_2
{
    public static void main(String args[])
    {
       String[] playerName = new String[1];
       String[] playerNumbers = new String[1];
       int lottoAmount = 0;
       Scanner keyboard = new Scanner(System.in);
       
       System.out.printf("Input the total Lotto Jackpot:\t");
       lottoAmount = keyboard.nextInt();
       keyboard.nextLine();
       
       System.out.printf("\nInput the players name:\t");
       playerName[0] = keyboard.nextLine();
       
       playerNumbers[0] = getPlayerNumbers(playerName[0]); 
       
       System.out.printf("\n%s:\t%s",playerName[0],playerNumbers[0]);
    } 
    
    public static String getPlayerNumbers(String nameOfPlayer)
    {
        Scanner keyboard = new Scanner(System.in);
        String numbers = "";
        
        System.out.printf("\n%s's Number Selection:\n",nameOfPlayer);
        
        for(int i = 0;i < 4;i++)
        {
            System.out.printf("Number %d:\t",i+1);
            numbers = numbers + keyboard.nextLine() + " ";
        }
        
        return numbers;
    }
    
    public static String[] generateWinningNumbers()
    {
        
    }
    
    public static void getJackpotWinners()
    {
        
    }
    
    public static void getMatch3Winners()
    {
    
    }
}
