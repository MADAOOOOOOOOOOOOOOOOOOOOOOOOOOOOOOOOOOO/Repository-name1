/**
 *Description: This program determines the validity of credit card numbers
 *@author  Zijia Ding
 *@version 1.0.0
 */
public class Issuer
{
    /**
     * return the issuer
     * @param cardNumber as string 
     * @return American Express in the card issuer field 
     * @return Diners Club - Carte Blanche in the card issuer field
     * @return Diners Club - International in the card issuer field
     * @return Diners Club - USA & Canada in the card issuer field
     * @return Discover in the card issuer field
     * @return InstaPayment in the card issuer field 
     * @return JCB in the card issuer field
     * @return Laser in the card issuer field
     * @return Maestro in the card issuer field
     * @return MasterCard in the card issuer field
     * @return Visa in the card issuer field
     * @return Visa Electron in the card issuer field
     */
    public String getIssuer(String cardNumber)
    {
        //use substring to decide which credit card carrier the card number is for. 
        int oneDigit = Integer.parseInt(cardNumber.substring(0, 1));
        int twoDigit = Integer.parseInt(cardNumber.substring(0, 2));
        int threeDigit = Integer.parseInt(cardNumber.substring(0, 3));
        int fourDigit = Integer.parseInt(cardNumber.substring(0, 4));
        int sixDigit = Integer.parseInt(cardNumber.substring(0, 6));
        //the reason I start from sixdigit is that onedigit may have the same digit as higher one
        //for example, if we have 1 in oneDigit and 111 in threeDigit
        //in that case, the results will be different if we start from oneDigit
        //the string will match the oneDigit first
        //in this application, the case of Visa card needs attention
        if( sixDigit>=622126 && sixDigit<=622925 && cardNumber.length() == 16)
        {
            return "Discover";
        }
        else if ( sixDigit==417500 && cardNumber.length() == 16)
        {
            return "Visa Electron";
        }
        else if (fourDigit==6011 && cardNumber.length() == 16)
        {
            return "Discover";
        }   
        else if ( fourDigit>=3528 && fourDigit<=3589 && cardNumber.length() == 16)    
        {
            return "JBC";
        }
        else if ((fourDigit==6304||fourDigit==6706||fourDigit==6771||fourDigit==6709)&& cardNumber.length()>=16&&cardNumber.length()<=19)
        {
            return "Laser";
        }
        else if((fourDigit==5018||fourDigit==5020||fourDigit==5038||fourDigit==5893||fourDigit==6304||fourDigit==6759||fourDigit==6761||fourDigit==6762||fourDigit==6763)&& cardNumber.length()>=16&&cardNumber.length()<=19)
        {
            return "Maestro";
        }
        else if((fourDigit==4026||fourDigit==4508||fourDigit==4844||fourDigit==4913||fourDigit==4917)&& cardNumber.length()==16)
        {
            return "Visa Electron";
        }
        else if(threeDigit>=300 && threeDigit<=305 && cardNumber.length() == 14)
        {
            return "Diners Club - Carte Blanche";
        }
        else if ( threeDigit>=644 && threeDigit<=649 && cardNumber.length() == 16)
        {
            return "Discover";
        }
        else if (threeDigit>=637 && threeDigit<=639 && cardNumber.length() == 16)
        {
            return "InstaPayment";
        }
        else if ( (twoDigit==34||twoDigit==37)&& cardNumber.length() == 15)
        {
            return "American Express";
        }
        else if (twoDigit==36&& cardNumber.length() == 14)
        {
            return "Diners Club - International";
        }
        else if (twoDigit==54&& cardNumber.length() == 16)
        {
            return "Diners Club - USA & Canada";
        } 
        else if (twoDigit==65&& cardNumber.length() == 16)
        {
            return "Discover";
        } 
        else if (twoDigit>=51 && threeDigit<=55 && cardNumber.length() >= 16&&cardNumber.length()<=19)
        {
            return "MasterCard";
        }
        else if (oneDigit==4 && cardNumber.length() >= 13&&cardNumber.length()<=16)
        {
            return "Visa";
        } 
        else
        {
            return "Unknown issuer";
        }
    }

}
