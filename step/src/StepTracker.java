import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData;

    StepTracker(Scanner scanner) {
        this.scanner = scanner;
        this.monthToData = new MonthData[12];

        for(MonthData month : monthToData) {
            month = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {

    }

}
