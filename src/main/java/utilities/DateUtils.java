package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    // Формат даты, используемый Air Canada: DD/MM/YYYY
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Возвращает дату в формате DD/MM/YYYY, отстоящую на указанное количество месяцев и дней от сегодняшнего дня.
     * @param months Месяцев от текущего момента
     * @param days Дней от текущего момента
     * @return Строка с датой (например, "23/05/2026")
     */
    public static String getDate(int months, int days) {
        LocalDate futureDate = LocalDate.now()
                .plusMonths(months)
                .plusDays(days);
        return futureDate.format(DATE_FORMATTER);
    }

    /**
     * Парсит строковое выражение даты (например, "6 months and 1 week from now") и возвращает вычисленную дату.
     * Поддерживает: "X months from now" и "X months and Y week from now"
     * @param expression Выражение для парсинга
     * @return Вычисленная дата в формате DD/MM/YYYY
     */
    public static String parseDateExpression(String expression) {
        int months = 0;
        int days = 0;

        if (expression.contains("months")) {
            // Ищем количество месяцев
            String monthPart = expression.substring(0, expression.indexOf("months")).trim();
            try {
                months = Integer.parseInt(monthPart);
            } catch (NumberFormatException e) {
                // Если "6 months"
                months = 6;
            }
        }

        if (expression.contains("week")) {
            // Ищем количество недель (переводим в дни)
            String weekPart = expression.substring(expression.indexOf("and") + 3, expression.indexOf("week")).trim();
            try {
                int weeks = Integer.parseInt(weekPart);
                days = weeks * 7;
            } catch (NumberFormatException e) {
                // Если "1 week"
                days = 7;
            }
        }

        // Базовый случай для "6 months from now"
        if (expression.contains("from now") && !expression.contains("months")) {
            // Это можно расширить для обработки только недель, если нужно
        }

        return getDate(months, days);
    }
}