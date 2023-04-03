import java.util.*;

public class Primitive {
    static String[] dataTypes = {"byte", "short", "int", "double", "float", "char", "boolean"};
    static String validChar = "abcdefghijklmnopqrstuvwxysABCDEFGHIJKLMNOPQRSTUVWXYZ_";
    static String[] charValue = {"'a'", "'b'", "'c'", "'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", "'k'", "'l'", "'m'", "'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", "'u'", "'v'", "'w'", "'x'", "'y'", "'z'",
                                 "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'M'", "'N'", "'O'", "'P'", "'Q'", "'R'", "'S'", "'T'", "'U'", "'V'", "'W'", "'X'", "'Y'", "'Z'"};


    // check if data type is valid
    static boolean CheckDataType(String data) {        
            
        for (String dataType : dataTypes) {
            if (dataType.equals(data)) {
                return true;
            }
        }
        return false;

    }
    

    // check if variable name is valid
    static boolean CheckVariable(String var) {
       
        for (int i = 0; i < var.length(); i++) {
            if (!validChar.contains(var.substring(i, i+1))) {
                return false;
            }
        }
        return true;

    }


    // check if input value is valid for given data type
    static boolean CheckValue(String type, String value) {
        try {
            switch (type) {
                case "byte":
                    byte byteValue = Byte.parseByte(value);
                    return true;
                case "short":
                    short shortValue = Short.parseShort(value);
                    return true;
                case "int":
                    int intValue = Integer.parseInt(value);
                    return true;
                case "float":
                    float floatValue = Float.parseFloat(value);
                    return true;
                case "double":
                    double doubleValue = Double.parseDouble(value);
                    return true;
                case "boolean":
                    if(value.equals("true") || value.equals("false"))
                        return true;
                    else
                        return false;
                case "char":
                    for(String character : charValue) {
                        if(character.equals(value))
                            return true;
                    }
                    return false;
                default:
                    return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }  
    

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter: ");
        String input = scan.nextLine();

        String[] words = input.split(" ");
        
        try{
            String type = words[0];
            String variable = words[1];
            String equals = words[2];
            String value = words[3];

            if(!(type == null) && !(variable == null) && !(equals == null) && !(value == null)) {
                if (CheckDataType(type) && CheckVariable(variable) && CheckValue(type, value))
                    System.out.println("Valid.");
                else
                    System.out.println("Invalid.");
            }
        } catch (IndexOutOfBoundsException e){
            String type = words[0];
            String variable = words[1];
            if(!(type == null) && !(variable == null)) {
                if (CheckDataType(type) && CheckVariable(variable))
                    System.out.println("Valid.");
                else
                    System.out.println("Invalid.");
            }
        }

    }

}
