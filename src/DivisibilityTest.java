import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
//program that teaches on divisibility test of number in the range 0 to 9
public class DivisibilityTest {
    private static int number;
    public static void main(String[]args){
        //allow user to input a number and store the result in variable number
        number = input_verify_number("Enter a number");
        StringBuilder reasons = new StringBuilder();
        for(int i = 1; i <=9; i++){
            //check if the number is divisible by i
            if(number % i==0){
                reasons.append("\n").append(number).append(" is divisible by ").append(i).append(" ").append(get_divisibility_reason(i));
            }
        }
        JOptionPane.showMessageDialog(null, reasons.toString());

    }
   //function to let user enter a number and verify if its valid
    private static int input_verify_number(String message){
        String number_string = JOptionPane.showInputDialog(null, message);
        int number;
        try{
            //convert the number entered to integer
            number = Integer.parseInt(number_string);
        }catch (Exception e){
            //handles exceptions
            return input_verify_number("Invalid! Enter a number");
        }
        return number;
    }
    //function that returns divisibility law of a certain number
    private static String get_divisibility_reason(int value){
        HashMap<Integer, String> divisibility_cases = new HashMap<>();
        divisibility_cases.put(0, "because no number is divisible by 0.");
        divisibility_cases.put(1, "because every number is divisible by 1 or itself.");
        divisibility_cases.put(2, "A number is divisible by 2 if its unit digit is divisible by 2.");
        divisibility_cases.put(3, "A number is divisible by 3 if the sum of its digits is divisible by 3.");
        divisibility_cases.put(4, "A number is divisible by 4 if the number formed by its last two digits in the same order (tens and unit digits) is divisible by 4.");
        divisibility_cases.put(5, "A number is divisible by 5 if its unit digit is either 0 or 5.");
        divisibility_cases.put(6, "A number is divisible by 6 if its divisible by both 2 and 3.");
        divisibility_cases.put(7, "however no rule has been established.");
        divisibility_cases.put(8, "A number is divisible by 8 if the number formed by its last three digits in the same order (hundreds, tens and unit digits) is divisible by 8.");
        divisibility_cases.put(9, "A number is divisible by 9 if the sum of its digit is divisible by 9.");
        return divisibility_cases.get(value)+" "+ (value == 0 || value == 1 || value == 7 ? "" : divisible__proof(number, value))+" "+number+ "/"+value+"="+number/value ;
    }
    private static String divisible__proof(int number_to_test, int test_against){
        int original_number = number_to_test;
        if(test_against == 2 || test_against == 5){
            int unit_digit = number_to_test % 10;
            return "For instance the unit digit for "+original_number+" is "+unit_digit+". "+unit_digit+" / "+test_against+" = "+unit_digit/test_against+".";
        } else if (test_against == 3 || test_against == 9) {
            int sum = 0;
            ArrayList<Integer> number_digits = new ArrayList<>();
            while(number_to_test>0){
                int last_digit = number_to_test % 10;
                number_digits.add(last_digit);
                number_to_test /= 10;
                sum += last_digit;
            }
            StringBuilder all_digits = new StringBuilder();
            if (!number_digits.isEmpty()){
                for (int digits: number_digits){
                    all_digits.append(" ").append(digits);
                }
            }
            return "The sum of digits("+all_digits+") in "+original_number+" is "+ sum+" which is divisible by "+ test_against+".";
        } else if (test_against == 4 || test_against == 8) {
            int loop_twice = 1;
            int last__units = 0;
            AtomicInteger ones = new AtomicInteger();
            AtomicInteger tens = new AtomicInteger();
            AtomicInteger hundreds = new AtomicInteger();
            while (loop_twice <= (test_against == 4 ? 2 : 3) && number_to_test > 0){
                int last_digit = number_to_test % 10;
                if (loop_twice == 1){
                    ones.set(last_digit);
                }
                else if(loop_twice == 2){
                    tens.set(last_digit*10);
                }
                else if(loop_twice == 3){
                    hundreds.set(last_digit*100);
                }
                last__units = hundreds.get()+tens.get()+ones.get();
                number_to_test /= 10;
                loop_twice++;
            }
            return  "The last "+((test_against == 4) ? 2 : 3)+" ("+(last__units < 100 && test_against == 8 ? "0"+last__units: last__units)+") is divisible by "+test_against+" . ("+last__units+" / "+test_against + "= "+last__units/test_against+").";
        } else if (test_against == 6) {
            return divisible__proof(original_number, 2)+" "+divisible__proof(original_number, 3)+".";
        }
        return "";
    }
}
