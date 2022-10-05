
class Solution {
    //Private variables that contains arrays of possibilities of numbers entered in the SayNumber method
    private static String[] less_twenty = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

    private static String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    private static String[] big_numbers = {"","Thousand","Million","Billion","Trillion"};

    /*

    * Static Method SayNumber (Recursive)
    * -------------------------------
    * This method takes a long (int) as a parameter and then breaks the number
    * into three parts.
    *
    */

    public static String SayNumber(long number) {
        if(number == 0) return "Zero.";

        String answer = new String();

        int index = 0;
        while(number > 0){
            if(number % 1000 != 0){
                answer = convertThreeDigit(number%1000) + big_numbers[index]+", " + answer;
            }
            index++;

            number /= 1000;
        }

        //Punctuation
        return answer.trim().substring(0, answer.length()-3)+".";

    }

    // This function recieves the 3 digit number and builds the string.
    // Its a recursive function.
    private static String convertThreeDigit(long num){
        if(num == 0)return "";
        if(num < 20) return less_twenty[(int)num] + " ";

        else if(num < 100) return tens[(int)num/10] + " " + convertThreeDigit(num % 10);

        else return less_twenty[(int)num/100] + " " + "Hundred" + " " + convertThreeDigit(num % 100);
    }

    // Finally our driver class to test our inputs.
    public static void main(String[] args) {

        long smallNumber = 0;
        long mediumNumber = 11;
        long largeNumber = 5007896;
        long bigNumber = 1237902373;

        System.out.println(SayNumber(smallNumber) + "\n" + SayNumber(mediumNumber) + "\n" + SayNumber(largeNumber) + "\n" + SayNumber(bigNumber));
    }
}
