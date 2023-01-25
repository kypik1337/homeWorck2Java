import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class homeWorck2 {
    public static void main(String[] args) throws FileNotFoundException {
        ex1();

    }
    static void ex1 () throws FileNotFoundException{
        /*
         * Дана json строка { { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
         * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}} 
         * Задача написать метод(ы), который распарсить строку и выдаст ответ вида: Студент Иванов получил 5 по предмету Математика. 
         * Студент Петрова получил 4 по предмету Информатика. Студент Краснов получил 5 по предмету Физика. Используйте StringBuilder для подготовки ответа
         */

         String string =  "{{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}}";
         string = string.replace("{", "")
                         .replace("}", "")
                         .replace("\"", "")
                         .replace(",", " ")
                         .replace("фамилия", "")
                         .replace("оценка", "")
                         .replace("предмет", "")
                         .replace(":", "");

        
        String[] array = string.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i+=3) {
            sb.append(" Студент ");
            sb.append(array[i]);
            sb.append(" Получил ");
            sb.append(array[i+1]);
            sb.append(" По предмету ");
            sb.append(array[i+2]);
            sb.append(".\n");            
        }
        System.out.println(sb);

        File fileZapis = new File("log.txt");
        PrintWriter pw = new PrintWriter(fileZapis);
        pw.print(sb);
        pw.close();
     

    }
    static String readFile(String filePatch){
        File file = new File("log.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()){
               stringBuilder.append(scanner.nextLine()); 
               stringBuilder.append("\n");
            }   
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
