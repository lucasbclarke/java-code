import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("input")) {
            int i;
            int index = 0;
            
            char[] c = new char[20]; 
            while ((i = input.read()) != -1)  {
                c[index] = (char) i; 
                index++;
            }
            String concat = "test".concat(" case\n");
            System.out.print(concat);
            String s = String.valueOf(c);
            System.out.print(s);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
