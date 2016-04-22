/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lotto_V4
{
    public static void main(String args[])
    {
        int lottoAmount = 0;
        int runs = 0;
        String temp ="";
        Scanner keyboard = new Scanner(System.in);
       
        String[] playerName = getPlayerNames();
        
        System.out.printf("How many runs would you like to play?:\t");
        runs = keyboard.nextInt();
        
        // Gets total lotto jackpot from user
        System.out.printf("Input the total Lotto Jackpot:\t");
        lottoAmount = keyboard.nextInt();
        keyboard.nextLine();
        
        // Loops the game number of times the user chose
        for (int game = 0;game < runs;game++)
        {
            System.out.printf("\n\nRound %d:\n",game + 1);
            // Sorts out the names in Alphabetical Order
            for (int i = 0; i < playerName.length;i++)
            {
                for (int j = 0;j < playerName.length - 1;j++)
                {
                    if(playerName[j].compareTo(playerName[j + 1]) > 0)
                    {
                        temp = playerName[j + 1];
                        playerName[j + 1] = playerName[j];
                        playerName[j] = temp;
                    }
                }
            }

            // Executes this if the players name is greater than 10 characters
            for (int i = 0;i < playerName.length;i++)
            {
                if(playerName[i].length() > 10)
                {
                    get10CharNames(playerName[i]);
                }
            }

            // Stores the numbers returned from the getPlayerNumbers method in the playerNumbers array
            int[][] playerNumbers = getPlayerNumbers(playerName); 

            // Outputs the players name and numbers  
            for (int i = 0;i < playerNumbers.length;i++)
            {
                System.out.printf("\n%s:\t\t",playerName[i]);
                for (int j = 0;j < 4;j++)
                {
                    System.out.printf("%d\t ",playerNumbers[i][j]); 
                }

            }

           // Stores the random numbers returned from the generateWinningNumbers method in jackPotNumbers[]
           int[] jackPotNumbers = generateWinningNumbers();

           // Outputs the Winning Numbers
           System.out.printf("\nWinning Numbers:\t");
           for (int i = 0;i < jackPotNumbers.length;i++)
           {
               System.out.printf("\t%d",jackPotNumbers[i]);
           }
        }
    } 
    
    public static String[] getPlayerNames()
    {
        int totalPlayers = 0;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.printf("How Many Players would like to play?:\t");
        totalPlayers = keyboard.nextInt();
        String[] pNames = new String[totalPlayers];
        
        for (int i = 0;i < pNames.length;i++)
        {
            System.out.printf("Enter a Player Name:\t");
            keyboard.nextLine();
            pNames[i] = keyboard.next();
        }
        return pNames;
    }
    
    public static int[][] getPlayerNumbers(String[] nameOfPlayer)
    {
        Scanner keyboard = new Scanner(System.in);
        int[][] numbers = new int[2][4];
        int[][] gottenNumbers = new int[2][4];
        int pass = 0;
        String choice = "";
        
        for(int i = 0;i < nameOfPlayer.length;i++)
        {
            System.out.printf("\n%s\n", nameOfPlayer[i]);
            for(int j = 0;j < 4;j++)
            {
                // While loop until user input is valid
                while (pass == 0)
                {
                    pass = 1;
                    System.out.printf("Number %d:\t",j + 1);
                    numbers[i][j] = keyboard.nextInt();
                    gottenNumbers[i][j] = numbers[i][j];
                    // Checks whether the input numbers[i][j] is between 1-20
                    if ((numbers[i][j] < 0)||(numbers[i][j] > 20))
                    {
                        pass = 0;
                    }
                    else
                    {
                        // Check numbers for duplicates
                        for(int h = 0; h < j;h++)
                        {
                            if(h != j)
                            {
                                if (numbers[i][j] == gottenNumbers[i][h])
                                {
                                    pass = 0;
                                }
                            }
                        }
                    }
                } 
                pass = 0;
            }
            // Asks user whether or not they'd like to change their numbers
            System.out.printf("\n\nAre these numbers okay?\n");
            // Outputs the players numbers
            for(int j = 0; j < 4;j++)
            {
                System.out.printf("%d\t", numbers[i][j]);
            }
            // Gets players choice on whether or not they want to change numbers
            System.out.printf("\nY/N");
            choice = keyboard.next();
            choice = choice.toLowerCase();
            if ((choice.equals("n"))||(choice.equals("no")))
            {
                i--;
            }
        }
        // Returns the numbers array
        return numbers;
    }
    
    public static int[] generateWinningNumbers()
    {
        Random randomNumbers = new Random();
        int[] winningNumbers = new int[4];
        int[] gottenNumbers = new int[4];
        int temp = 0;
        int pass = 0;
        
        // Generates 4 random numbers between 1-20 and stores each number in an array
        for (int i = 0;i < winningNumbers.length;i++)
        {
            while(pass == 0)
            {
                pass = 1;
                winningNumbers[i] = 1 + randomNumbers.nextInt(20);
                gottenNumbers[i] = winningNumbers[i];
                // For loop which checks if the random generator generated any duplicate numbers
                for(int j = 0;j <= i;j++)
                {
                    if (i != j)
                    {
                        if (winningNumbers[i] == gottenNumbers[j])
                        {
                            pass = 0;
                        }
                    }
                }
            }
            pass = 0;
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
    
    public static void getJackpotWinners()
    {
        
    }
    
    public static void getMatch3Winners()
    {
    
    }
}
