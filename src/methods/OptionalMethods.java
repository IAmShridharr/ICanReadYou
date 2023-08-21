package methods;

import java.io.IOException;

public class OptionalMethods {
    public void clear(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException exception) {
            System.out.println("This command-line interface does not support the clear method!");
        }
    }
}
