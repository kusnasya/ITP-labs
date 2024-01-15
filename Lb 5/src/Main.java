import java.io.*;
import java.time.LocalDateTime;

public class Main{
        public static void main(String[] args) throws Exception
        {
            File file = new File("ienputr.txt");
            try {
                if (!file.exists()) {
                    throw new CustomFileNotFoundException("Файл не найден: " + file.getName());
                }
                FileInputStream fis = new FileInputStream(file);
                fis.close();
            } catch (CustomFileNotFoundException e){
                try {
                    FileWriter writer = new FileWriter("error.txt", true);
                    writer.write(e.getMessage() + " " + LocalDateTime.now() + "\n");
                    writer.close();
                } catch (IOException exception){
                    System.out.println("Ошибка логирования в текстовый файл");
                }
                System.out.println("Файл не найден: " + file.getName());
            }
        }
}
