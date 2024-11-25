/**
 * Пакет ki301_kutsenko_lab5.
 */
package ki301_kutsenko_lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс для работы с файлами. Поддерживает запись и чтение данных из текстовых и бинарных файлов.
 */
public class FileHandler
{
    private String textFilePath;
    private String binaryFilePath;

    /**
     * Конструктор для создания обработчика файлов.
     *
     * @param textFilePath   путь к текстовому файлу.
     * @param binaryFilePath путь к бинарному файлу.
     */
    public FileHandler(String textFilePath, String binaryFilePath) 
    {
        this.textFilePath = textFilePath;
        this.binaryFilePath = binaryFilePath;
    }

    /**
     * Записывает строку данных в текстовый файл.
     *
     * @param data строка для записи.
     */
    public void writeToTextFile(String data)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFilePath, true))) 
        {
            writer.write(data);
            writer.newLine();
            System.out.println("Данные успешно записаны в текстовый файл.");
        }
        catch (IOException e) 
        {
            System.out.println("Ошибка при записи в текстовый файл: " + e.getMessage());
        }
    }

    /**
     * Записывает число с плавающей точкой в бинарный файл.
     *
     * @param result число для записи.
     */
    public void writeToBinaryFile(double result)
    {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(binaryFilePath, true)))
        {
            dos.writeDouble(result);
            System.out.println("Данные успешно записаны в бинарный файл.");
        }
        catch (IOException e) 
        {
            System.out.println("Ошибка при записи в бинарный файл: " + e.getMessage());
        }
    }

    /**
     * Читает строки из текстового файла.
     *
     * @return список строк, прочитанных из файла.
     */
    public List<String> readFromTextFile() 
    {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(textFilePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                lines.add(line);
            }
            System.out.println("Данные успешно считаны из текстового файла.");
        } 
        catch (IOException e) 
        {
            System.out.println("Ошибка при чтении из текстового файла: " + e.getMessage());
        }
        return lines;
    }

    /**
     * Читает числа с плавающей точкой из бинарного файла.
     *
     * @return список чисел, прочитанных из файла.
     */
    public List<Double> readFromBinaryFile() 
    {
        List<Double> results = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(binaryFilePath)))
        {
            while (dis.available() > 0) 
            {
                results.add(dis.readDouble());
            }
            System.out.println("Данные успешно считаны из бинарного файла.");
        } 
        catch (IOException e) 
        {
            System.out.println("Ошибка при чтении из бинарного файла: " + e.getMessage());
        }
        return results;
    }
}

