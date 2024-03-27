package oaosugar;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean numberCheck(String number){
        String pattern = "[^0-9]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(number);
        return !m.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadanie 1.10 Milovantseva Irina RIBO-01-22 Variant 16(1)");
        System.out.println("Введите количество файлов, которые хотите склеить: ");
        String number = scanner.nextLine();


        if (numberCheck(number)) {
            int intNumber = Integer.parseInt(number);
            int countNumber = 0;
            ArrayList<String> list = new ArrayList<>();
            while (countNumber < intNumber) {
                System.out.println("Введите директорию файла ");
                String directoryOfFile = scanner.nextLine();
                /*File directory = new File(directoryOfFile);
                if (!directory.exists() || !directory.isDirectory()) {
                    System.err.println("Указанная директория не существует или не является директорией.");
                    return;
                }*/
                list.add(directoryOfFile);
                countNumber = countNumber + 1;
            }
            try {
                String pathOfFirstDirectory =list.get(0);
                for (int i = pathOfFirstDirectory.length() - 1; i>-1; i--){
                    if(pathOfFirstDirectory.charAt(i) == '\\'){
                        pathOfFirstDirectory=pathOfFirstDirectory.substring(0,i+1);
                        break;
                    }
                }
                String outputFile = pathOfFirstDirectory + "output.txt";
                //System.out.println(outputFile);
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

                for (String filePath : list) {
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line + " ");
                    }
                    reader.close();
                }

                writer.close();
                System.out.println("Файлы успешно склеены и сохранены в файле: " + outputFile);
            } catch (Exception e) {
                System.err.println("Произошла ошибка, возможно введены неверные данные");
            }
            finally {
                System.out.println("Список введенных директорий");
                System.out.println(list);
            }

        } else {
            System.err.println("Введены неверные данные");
        }
    }
}