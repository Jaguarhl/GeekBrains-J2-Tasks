import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        doIt();
    }

    public static void doIt() {
        Scanner sc = new Scanner(System.in);
        String strIn, strOut;
        InputData id;
        do {
            System.out.println("Введите имя файла с матрицей");
            strIn = sc.next();
            id = new InputData(strIn);
        } while (!id.isReaded());
        System.out.println("Введите имя файла куда сохранить результат");
        strOut = sc.next();
        calculateAndSave(id, strOut);
    }

    public static void calculateAndSave(InputData id, String filename) {
        try {
            PrintWriter pw = new PrintWriter(filename);
            pw.write(id.calculateAndGenerate());
            pw.close();
            System.out.println("OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
