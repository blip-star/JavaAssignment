import javax.swing.*;
import java.util.HashMap;

//program allow users input two number(integer/float/double) them computes them according to the selected operation
public class SimpleCalculator {
    public static void main(String[]args){

        float number_1 = input_verify_number(show_input_dialog("Enter first number"));
        float number_2 = input_verify_number((show_input_dialog("Enter second number")));
        //hashmap carries both the operands, operator and results
        HashMap<String, String> computations = new HashMap<>();
        computations.put("number_1", String.valueOf(number_1));
        computations.put("number_2", String.valueOf(number_2));
        switch (select_operation_from_list(new String[]{"+", "-", "*", "/"})) {
            case 0 -> {
                computations.put("results", String.valueOf(number_1 + number_2));
                computations.put("operator", "+");
            }
            case 1 -> {
                computations.put("results", String.valueOf(number_1 - number_2));
                computations.put("operator", "-");
            }
            case 2 -> {
                computations.put("results", String.valueOf(number_1 * number_2));
                computations.put("operator", "*");
            }
            case 3 -> {
                computations.put("results", String.valueOf(number_1 / number_2));
                computations.put("operator", "/");
            }
            default -> throw new IllegalStateException("No operator selected: " + select_operation_from_list(new String[]{"+", "-", "*", "/"}));

        }
        display_results(computations);
    }
    //function display results
    private static void display_results(HashMap<String, String> computations){
        System.out.println("The `"+ computations.get("operator")+"` of "+computations.get("number_1")
        +" and "+computations.get("number_2")+" is "+computations.get("results"));
    }
    //function create an input dialog
    private static String show_input_dialog(String input_message){
        return JOptionPane.showInputDialog(null, input_message);
    }
    //function verifies and check if the number entered is valid
    private static float input_verify_number(String value){
        float number;
        try{
            number = Float.parseFloat(value);
        }catch (Exception e){
            return input_verify_number(show_input_dialog("Invalid. Enter new number"));
        }
        return number;
    }
    private static int select_operation_from_list(String[] options){
        return JOptionPane.showOptionDialog(null, "Select an operation", "Operation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, null);
    }
}
