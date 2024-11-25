/**
 * Пакет ki301_kutsenko_lab5.
 */
package ki301_kutsenko_lab5;
 
/**
 * Класс для вычисления значения математической функции.
 */
public class Calculate
{
	/**
     * Вычисляет значение функции: {@code y = cos(2x) / ctg(3x - 1)}.
     *
     * @param x входное значение для вычисления.
     * @return результат вычисления функции.
     * @throws IllegalArgumentException если {@code ctg(3x - 1)} равен нулю.
     */
	public static double calculation(double x) 
    {
        // Шаг 1: Проверка, что знаменатель не равен нулю
		 double  denominator =  1/Math.tan(3 * x - 1);
	        if (Math.abs(Math.tan(3 * x - 1)) < 1e-10) 
	        {
	            throw new IllegalArgumentException("ctg(3x - 1) равен 0, деление на ноль невозможно.");
	        }      
        
        // Шаг 2: Вычисление числителя и знаменателя
        double numerator = Math.cos(2 * x) ;
        
        // Шаг 3: Результат деления
        return numerator / denominator;
    }
}            //0,33333333333333333333333333333333
      