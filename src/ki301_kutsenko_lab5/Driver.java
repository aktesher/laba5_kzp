/**
 * Пакет ki301_kutsenko_lab5.
 */
package ki301_kutsenko_lab5;

//import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Основной класс программы. Реализует ввод данных, вызов методов вычисления, запись результатов
 * в файлы и чтение из них.
 */
public class Driver 
{
	/**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("results.txt", "results.bin");
        //calculate calculator = new calculate();
        System.out.println("Введите значение x:");
        try {
            double x = Double.parseDouble(scanner.nextLine());

            // Вычисление значения функции
            double y = Calculate.calculation(x);

            // Формирование строкового результата
            String resultText = "x = " + x + ", y = " + y;

            // Запись данных в файлы
            fileHandler.writeToTextFile(resultText);
            fileHandler.writeToBinaryFile(y);

            // Чтение данных из текстового и бинарного файлов для проверки
            System.out.println("\nСчитанные данные из текстового файла:");
            fileHandler.readFromTextFile().forEach(System.out::println);

            System.out.println("\nСчитанные данные из бинарного файла:");
            fileHandler.readFromBinaryFile().forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректное числовое значение.");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка при вычислениях: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Программа завершена.");
        }
    }
}
