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
       int lottoAmount = 0;
       Scanner keyboard = new Scanner(System.in);
       
       System.out.printf("Input the total Lotto Jackpot:\t");
       lottoAmount = keyboard.nextInt();
       keyboard.nextLine();
       
       System.out.printf("\nInput the players name:\t");
       playerName[0] = keyboard.nextLine();
       
       int[] playerNumbers = getPlayerNumbers(playerName[0]); 
       
       System.out.printf("\n%s:\t",playerName[0]);
       for (int i = 0;i < 4;i++)
       {
           System.out.printf("%d ",playerNumbers[i]);
       }
       
       int[] jackPotNumbers = generateWinningNumbers();
      
    } 
    
    public static int[] getPlayerNumbers(String nameOfPlayer)
    {
        Scanner keyboard = new Scanner(System.in);
        int[] numbers = new int[4];
        
        System.out.printf("\n%s's Number Selection:\n",nameOfPlayer);
        
        for(int i = 0;i < 4;i++)
        {
            System.out.printf("Number %d:\t",i+1);
            numbers[i] = keyboard.nextInt();
        }
        
        return numbers;
    }
    
    public static int[] generateWinningNumbers()
    {
        Random randomNumbers = new Random();
        int[] winningNumbers = new int[4];
        
        for (int i = 0;i < 4;i++)
        {
            winningNumbers[i] = 1 + randomNumbers.nextInt(20);
        }
        
        return winningNumbers;
    }
    
    public static void getJackpotWinners()
    {
        
    }
    
    public static void getMatch3Winners()
    {
    
    }
}
