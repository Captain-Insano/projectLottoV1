/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lotto_V1_3
{
    public static void main(String args[])
    {
       String[] playerName = {"Player1"};
       int lottoAmount = 0;
       Scanner keyboard = new Scanner(System.in);
       
       // Gets total lotto jackpot from user
       System.out.printf("Input the total Lotto Jackpot:\t");
       lottoAmount = keyboard.nextInt();
       keyboard.nextLine();
       
       // Executes this if the players name is greater than 10 characters
       if(playerName[0].length() > 10)
       {
           get10CharNames(playerName[0]);
       }
       
       // Stores the numbers returned from the getPlayerNumbers method in the playerNumbers array
       int[] playerNumbers = getPlayerNumbers(playerName[0]); 
       
       // Outputs the players name and numbers
       System.out.printf("\n%s:\t\t",playerName[0]);
       for (int i = 0;i < 4;i++)
       {
           System.out.printf("%d\t ",playerNumbers[i]);
       }

       
       // Stores the random numbers returned from the generateWinningNumbers method in jackPotNumbers[]
       int[] jackPotNumbers = generateWinningNumbers();
       
       // Outputs the Winning Numbers
       System.out.printf("\nWinning Numbers:\t");
       for (int i = 0;i < jackPotNumbers.length;i++)
       {
           System.out.printf("%d\t ",jackPotNumbers[i]);
       }
       
    } 
    
    public static int[] getPlayerNumbers(String nameOfPlayer)
    {
        Scanner keyboard = new Scanner(System.in);
        int[] numbers = {1,2,3,4};
        
        // Returns the numbers array
        return numbers;
    }
    
    public static int[] generateWinningNumbers()
    {
        Random randomNumbers = new Random();
        int[] winningNumbers = new int[4];
        int temp = 0;
        
        // Generates 4 random numbers between 1-20 and stores each number in an array
        for (int i = 0;i < 4;i++)
        {
            winningNumbers[i] = 1 + randomNumbers.nextInt(20);
        }
        
        // Sorts out the winning numbers from lowest to highest
        for (int i = 0; i < winningNumbers.length;i++)
        {
            for (int j = 0;j < winningNumbers.length - 1;j++)
            {
                if(winningNumbers[j] > winningNumbers[j + 1])
                {
                    temp = winningNumbers[j + 1];
                    winningNumbers[j + 1] = winningNumbers[j];
                    winningNumbers[j] = temp;
                }
            }
        }
        
        // Returns the winningNumbers array
        return winningNumbers;
    }
    
    public static void get10CharNames(String name)
    {
        // Outputs the name with more than 10 characters
        System.out.printf("\n%s is greater than 10 characters.\n",name);
        
    }
    
    public static void getJackpotWinners(int[] numbersPlayer,int[] winningNumbers)
    {
        //Tests if the two arrays are equal or not
        
        if (Arrays.equals(numbersPlayer,winningNumbers))
        {
            System.out.printf("\n Winner \t");
        }
        else{
            System.out.printf("\nYou lose");
        }
    }
    
    public static void getMatch3Winners(int[] numbersPlayer,int[] winningNumbers)
    {
      int tally=0;//Counts the number of times the player has a matching number,
      //and displays if they won.
      
        for (int x =0;x<winningNumbers.length;x++)
        {
            if(numbersPlayer[x]==winningNumbers[x])
            {
            tally++;
            }
            if(tally>=3)
            {
                System.out.printf("\nYou have matched "+tally+" numbers. Congrats");
            }
        }
    }
    
}
