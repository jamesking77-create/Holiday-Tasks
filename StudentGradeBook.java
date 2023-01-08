package assignments;

import java.util.Arrays;
import java.util.Collections;

public class StudentGradeBook {
    private final int [][] studentGrades;
    private String courseName;

    public StudentGradeBook(int[][] studentGrades, String courseName) {
        this.studentGrades = studentGrades;
        this.courseName = courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
    public void StudentGradeProcess(){
        outputStudentGrade();

    }
    public int getMaximum(){
       int maximum =  studentGrades[0][0];
        for (int [] studentGrade:studentGrades) {
            for (int grade: studentGrade) {
                if (grade > maximum){
                    maximum = grade;
                }
            }
        }
        return maximum;
    }
    public  int getMinimum(){
        int minimum = studentGrades [0][0];
        for (int[] studentGrade: studentGrades) {
            for (int grade: studentGrade) {
                if (grade < minimum){
                    minimum = grade;
                }
            }
        }
        return minimum;
    }
    public int getTotal(int[] studentGrade){
        int total = 0;
            for (int grade: studentGrade) {
                total += grade;
            }
        return total;
    }
    public double getAverage(int[] studentGrade){
        double total = 0;
            for (int grade: studentGrade) {
                total+=grade;
            }
        return total / studentGrades.length;
    }
    public void outputStudentGrade(){
        System.out.printf("The grades are: %n%n");
        System.out.println("================================================================");
        System.out.print("STUDENT   ");
        for (int subject = 0; subject < studentGrades[0].length ; subject++) {
            System.out.printf(" SUB%1d   ",subject + 1);
        }

        System.out.println(" TOT     AVE   POS");
        System.out.println("================================================================");

            for (int student = 0; student < studentGrades.length ; student++) {
            System.out.printf("Student%2d", student + 1);
                for (int subjectScore:studentGrades[student]) {
                System.out.printf("    %d", subjectScore);
                }
                Integer total = getTotal(studentGrades[student]);
                System.out.printf("     %d", total);
                double average = getAverage(studentGrades[student]);
                System.out.printf("%9.2f    ", average);
                Integer [] totals = new Integer[studentGrades.length ];
                for (int i = 0; i < totals.length; i++) {
                totals[i] = getTotal(studentGrades[i]);
                }
                Arrays.sort(totals, Collections.reverseOrder() );
                System.out.println(Arrays.asList(totals).indexOf(getTotal(studentGrades[student]))+1);
            }

        System.out.println("================================================================");
        System.out.println("================================================================");
        System.out.println();
        System.out.println();

        System.out.println("SUBJECT SUMMARY");
        int subject;
        Integer[] highest_fails = new Integer[studentGrades[0].length];
        Integer[] highest_passes = new Integer[studentGrades[0].length];


        for ( subject = 0; subject < studentGrades.length ; subject++) {
            System.out.println("========================================================");
            System.out.printf("SUBJECT%2d%n", subject + 1);
            Integer [] subject1 = new Integer[studentGrades.length ];
            int passes = 0;
            int fails = 0;
            for (int i = 0; i < subject1.length; i++) {
                subject1[i] = studentGrades[i][subject] ;
                if (subject1[i] >= 50){
                    passes++;
                }
                if (subject1[i] < 50){
                    fails++;

                }
            }

            Arrays.sort(subject1, Collections.reverseOrder() );
            System.out.printf("Highest scoring student is: student %s scoring  %d%n", subject1[subject], subject1[0]);
            System.out.printf("Lowest scoring student is: student %s scoring %d%n", subject1[subject], subject1[subject1.length-1]);
            double subjectSum = subject1[0] + subject1[subject1.length-1];
            System.out.printf("Total score is: %.0f%n",subjectSum );
            double subjectAverage = subjectSum / 2;
            System.out.printf("Average score is: %.2f%n",subjectAverage);
            System.out.printf("Number of passes: %d%n", passes);
            System.out.printf("Number of fails: %d%n", fails);
            System.out.println("========================================================");
            System.out.println();

            highest_fails[subject] = fails;
            highest_passes[subject] = passes;

        }
        Arrays.sort(highest_fails, Collections.reverseOrder());
        System.out.printf("The hardest subject is subject %d  with %d fails%n", subject ,highest_fails[0]);
        Arrays.sort(highest_passes, Collections.reverseOrder());
        System.out.printf("The hardest subject is subject %d with %d passes", subject ,highest_passes[0]);
    }
}
