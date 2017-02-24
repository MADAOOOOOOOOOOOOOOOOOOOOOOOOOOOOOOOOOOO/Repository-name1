import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 *Description: This program determines the validity of credit card numbers
 *@author  Zijia Ding
 *@version 1.0.0
 */
public class CreditCardDriver 
{
    /**
     * @param String as args - Input string array from command line
     * @return nothing
     * @throws FileNotFoundException is implemented
     */
    public static void main(java.lang.String[] args)throws FileNotFoundException
    {
        //declare variables
        String cardNumber;
        //arrays to hold the card numbers and issuers
        //the reason I use arraylist is that we dont know the size of the data
        ArrayList<String> valid = new ArrayList<String>(); 
        ArrayList<String> invalid = new ArrayList<String>(); 
        ArrayList<String> validIssuer = new ArrayList<String>(); 
        ArrayList<String> invalidIssuer = new ArrayList<String>();
        //create two object to use the methods
        ValidateCard check = new ValidateCard();
        Issuer issuer= new Issuer();
        //attempt to open the file 
        try
        {
            //Create a File object representing the file.
            File inFile = new File("C:\\Users\\dellpc\\Desktop\\data.txt");
            File ovalid = new File("C:\\Users\\dellpc\\Desktop\\valid_cards.txt");
            File oinvalid = new File("C:\\Users\\dellpc\\Desktop\\ivalid_numbers.txt");
            //Create Scanner object to read the file.
            //Create PrintWrite object to output
            Scanner inputFile = new Scanner(inFile);
            PrintWriter validCard = new PrintWriter(ovalid);
            PrintWriter invalidCard = new PrintWriter(oinvalid);
            //instruction 
            System.out.println("Welcome...quack quack quack quack");
            System.out.println("Case number 20150510-001.");
            System.out.println("Processing data...");
            // create a while loop get every creadit card number 
            while(inputFile.hasNextLine())
            {
                //read all the data
                cardNumber = inputFile.nextLine();
                if(check.validation(cardNumber))
                {
                    //add the card number to the arraylist
                    valid.add(cardNumber);
                    //add the issuer to arraylist
                    validIssuer.add(issuer.getIssuer(cardNumber));
                }
                else
                {
                    //add the card number to the arraylist
                    invalid.add(cardNumber);
                    //add the issuer to arraylist
                    invalidIssuer.add(issuer.getIssuer(cardNumber));
                }
            }
            //create a loop to output all the data
            for (int index = 0; index < valid.size(); index++)
            {
                validCard.println(validIssuer.get(index));
                validCard.println(valid.get(index));
            }
            //create a loop to output all the data
            for (int index = 0; index < invalid.size(); index++)
            {            
                invalidCard.println(invalidIssuer.get(index));
                invalidCard.println(invalid.get(index)); 
            }
            //close the files
            inputFile.close();
            validCard.close();
            invalidCard.close();
        }
        //If the file was not found, the following statement will execute.
        catch(FileNotFoundException e)
        {
            java.lang.System.out.println("File not found.Please check the path again.");
        }
        System.out.println("Done...quack quack quack quack");
    }
}

