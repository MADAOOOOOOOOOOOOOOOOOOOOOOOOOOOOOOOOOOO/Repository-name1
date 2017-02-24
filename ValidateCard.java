/**
 *Description: This program determines the validity of credit card numbers
 *@author  Zijia Ding
 *@version 1.0.0
 */
public class ValidateCard 
{
    /**
     * return if the cardnumber is a valid one
     * @param cardnumber as string 
     * @return the result of ((sum + lastDigit)% 10 == 0)
     */    
    public boolean validation(String cardnumber)
    {
        int sum =  0;
        int lastDigit;
        //create a boolean variable represents the position
        boolean isodd = true;
        //drop the last digit
        lastDigit= Integer.parseInt(cardnumber.substring(cardnumber.length()-1));
        //create a loop to read the whole string
        for (int i = cardnumber.length() - 2; i >= 0; i--)
        {
            //read the string from the next to last
            int n = Integer.parseInt(cardnumber.substring(i, i + 1));
            //the first one is odd, that is why we initialize the isodd as true
            if (isodd)
            {
                //multiple odd digits by 2
                n *= 2;
                if (n > 9)
                {
                    //the possible value of n*2 is between 0 and 18
                    //therefore subtract 9 can satisfy any result higher than 9
                    n = n - 9;
                }
            }
            //update the sum
            sum += n;
            //change the isodd value
            isodd = !isodd;
        }
        //return the validity of this card
        //it will return true if the result of sum plus the last digit divisible by 10
        return ((sum + lastDigit)% 10 == 0);
    }
}
