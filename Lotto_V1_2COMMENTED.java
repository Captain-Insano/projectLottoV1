/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lotto_V1_2COMMENTED
{
    public static void main(String args[])
    {
       String[] playerName = new String[1];
       int lottoAmount = 0;
       Scanner keyboard = new Scanner(System.in);
       
       // Gets total lotto jackpot from user
       System.out.printf("Input the total Lotto Jackpot:\t");
       lottoAmount = keyboard.nextInt();
       keyboard.nextLine();
       
       // Gets the players name
       System.out.printf("\nInput the players name:\t");
       playerName[0] = keyboard.nextLine();
       
       // Stores the numbers returned from the getPlayerNumbers method in the playerNumbers array
       int[] playerNumbers = getPlayerNumbers(playerName[0]); 
       
       // Outputs the players name and numbers
       System.out.printf("\n%s:\t",playerName[0]);
       for (int i = 0;i < 4;i++)
       {
           System.out.printf("%d ",playerNumbers[i]);
       }
       
       // Stores the random numbers returned from the generateWinningNumbers method in jackPotNumbers[]
       int[] jackPotNumbers = generateWinningNumbers();
       
       getJackpotWinners(playerNumbers,jackPotNumbers);
      
    } 
    
    public static int[] getPlayerNumbers(String nameOfPlayer)
    {
        Scanner keyboard = new Scanner(System.in);
        int[] numbers = new int[4];
        
        System.out.printf("\n%s's Number Selection:\n",nameOfPlayer);
        
        // Stores the user selected numbers in an array
        for(int i = 0;i < 4;i++)
        {
            System.out.printf("Number %d:\t",i+1);
            numbers[i] = keyboard.nextInt();
        }
        
        // Returns the numbers array
        return numbers;
        
        
    }
    
    public static int[] generateWinningNumbers()
    {
        Random randomNumbers = new Random();
        int[] winningNumbers = new int[4];
        
        // Generates 4 random numbers between 1-20 and stores each number in an array
        for (int i = 0;i < 4;i++)
        {
            winningNumbers[i] = 1 + randomNumbers.nextInt(20);
        }
        
        // Returns the winningNumbers array
        return winningNumbers;
    }
    
    public static void getJackpotWinners(int[] numbersPlayer,int[] winningNumbers)
    {
        for (int x=0; x<winningNumbers.length;x++);
        {
            if (numbersPlayer[x]===winningNumbers[x])
            {
            System.out.printf("\n Does this work? \t");
            }
            else{
            }
        }
    }
    
    public static void getMatch3Winners()
    {
    
    }
}
