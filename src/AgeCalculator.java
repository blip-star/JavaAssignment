import javax.swing.*;

//program allows user enter their surname and age
//It counts the number of characters in their surname and output the value
//Also the programs check if the value of age entered is odd or even outputting the results.
public class AgeCalculator {
    public static void main(String[] args){
        String surname = show_input_value_dialog("Enter surname");
        int number_of_char_surname = 0;
        if(surname.length() == 0){
            JOptionPane.showMessageDialog(null, "Note# No surname entered", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            number_of_char_surname = surname.length();
        }
        int age = input_validate_age();
        boolean is_age_even = false;
        try{
            if(age % 2 == 0){
                is_age_even = true;
            }
            System.out.println(number_of_char_surname > 0 ? "The number of characters is: "
                    .concat(String.valueOf(number_of_char_surname)) :
                    "No surname entered.");

            System.out.println(is_age_even ? "Your current age is an even number.": "Your current age is an odd number.");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Did you enter a valid age?", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    //function to show an input dialog.
    private static String show_input_value_dialog(String input_message){
        return JOptionPane.showInputDialog(null, input_message);
    }
    //function to allow users input and validate their age
    private static int input_validate_age(){
        String age_string = show_input_value_dialog("Enter your age (number)");
        int age;
        try {
            age = Integer.parseInt(age_string);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Invalid or no age entered!!!","Error", JOptionPane.ERROR_MESSAGE);
            //Recursively calls itself to input a new age if an invalid age has been entered
            return input_validate_age();
        }
        return age;
    }
}
