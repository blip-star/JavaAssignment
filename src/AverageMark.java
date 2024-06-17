import javax.swing.*;

public class AverageMark {
    public static void main(String[]args){
       float avg;
       int sum=0;

        for(int i=1;i<=5;i++){
            sum+=input_verify("input the "+i+" mark");
        }
        avg= (float) sum /5;
        System.out.printf("%.2f%n",avg);
    }
    private static int input_verify(String message){
        String mark_string= JOptionPane.showInputDialog(null,message);
        int mark;
        try {
            mark=Integer.parseInt(mark_string);
            if(mark<0 || mark >100)
                return input_verify("invalid.enter new mark");
        }catch (Exception e){
            return input_verify("invalid.enter new mark");
        }
        return mark;
    }
}
