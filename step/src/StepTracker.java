import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData;
    Converter converter;
    private int goalByStepsPerDay = 10000;

    StepTracker(Scanner scanner) {
        this.scanner = scanner;
        this.monthToData = new MonthData[12];
        this.converter = new Converter();

        for(int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    // Добавляет количество шагов за выбранный пользователем день
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();

        while (month < 1 || month > 12) {
            System.out.println("Некорректный номер месяца, введите число от 1 до 12:");
            month = scanner.nextInt();
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int days = scanner.nextInt();
        while (days < 1 || days > 30) {
            System.out.println("Некорректный номер дня, введите число от 1 до 30:");
             days = scanner.nextInt();
        }

        System.out.println("Введите количество шагов от 1 до 10000");
        int steps = scanner.nextInt();
        while (steps < 1 || steps > 10000) {
            System.out.println("Некорректное значение, введите число от 1 до 10000:");
            steps = scanner.nextInt();
        }

        // Вытащили из хранилища месяц который необходимо отредактировать и сохранили его в переменную editedMonth
        MonthData editedMonth = monthToData[month];

        // Вытащили из месяца который нам необходимо отредактировать массив со всеми днями
        int[] editedDays = editedMonth.days;

        // Вытащили информацию о количество шагов за день который хочет отредактировать пользователь
        int editedDay = editedDays[days];

        // Добавили количество шагов за данный день
        editedDay = editedDay + steps;
        // Сохранили новое значение шагов за день
        editedDays[days] = editedDay;
        // Сохранил новый массив с редактируемым днем, с обновленным количество шагов
        editedMonth.days = editedDays;
        // Сохранили в хранилище monthToData редактируемый месяц
        monthToData[month] = editedMonth;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель по количеству шагов");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Цель должна быть положительным числом. Повторите ещё раз");
        } else {
            goalByStepsPerDay = steps;
            System.out.println("Введена новая цель на " + goalByStepsPerDay + "шагов.");
        }
    }

    void printStatistic() {

        System.out.println("Введите число месяца от 1 до 12:");
        int month = scanner.nextInt();

        while (month < 1 || month > 12) {
            System.out.println("Некорректный номер месяца, введите число от 1 до 12:");
            month = scanner.nextInt();
        }

        MonthData monthData = monthToData[month];
        monthData.printDaysAndStepsFromMonth();

        System.out.println("общее количество шагов за месяц " + monthData.sumStepsFromMonth());
        System.out.println("максимальное пройденное количество шагов в месяце " + monthData.maxSteps());
        System.out.println("среднее количество шагов " + monthData.sumStepsFromMonth() / monthData.days.length);
        int steps = monthData.sumStepsFromMonth();
        System.out.println("пройденная дистанция (в км) " + converter.convertToKm(steps));
        System.out.println("количество сожжённых килокалорий " + converter.convertStepsToKilocalories(steps));
        System.out.println("лучшая серия " + monthData.bestSeries(goalByStepsPerDay));
    }
}
