import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Enter student grades. Type 'done' to finish:");

        while (true) {
            System.out.print("Enter grade: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                double grade = Double.parseDouble(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to finish.");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            double average = calculateAverage(grades);
            double highest = findHighest(grades);
            double lowest = findLowest(grades);

            System.out.printf("Average grade: %.2f\n", average);
            System.out.printf("Highest grade: %.2f\n", highest);
            System.out.printf("Lowest grade: %.2f\n", lowest);
        }

        scanner.close();
    }

    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static double findHighest(ArrayList<Double> grades) {
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    private static double findLowest(ArrayList<Double> grades) {
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
