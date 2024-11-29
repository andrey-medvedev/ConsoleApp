import java.util.Scanner;

public class UserInputValidator {

  public static int intInputWithValidation(){
      Scanner in = new Scanner(System.in);
      while(true){
            try {
                int intValue =  Integer.parseInt(in.nextLine());
                if (intValue > 0){
                    return intValue;
                } else{
                    System.out.println("Введенное значение должно быть > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введеное значение нельзя привести к целому числу");
            }
        }
    }

    public static String stringInputWithValidation(){
        Scanner in = new Scanner(System.in);
        String stringValue = "";
        while (stringValue.isEmpty()){
            stringValue = in.nextLine();
            if (stringValue.isEmpty()){
                System.out.println("Значение не может быть пустой строкой");
            }
        }
        return stringValue;
    }
}
