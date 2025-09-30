import java.util.Scanner;
public class Seatwork13 {
	public static String calculateGrade(double percentage ){
		if(percentage >= 90) return "A";
		else if(percentage >= 80) return "B";
		else if(percentage >= 70) return "C";
		else if(percentage >= 60) return "D";
		else return "F";
	}
	public static String calculateGrade(int score, int maxScore){
	    double percentage = (double) score / maxScore * 100;
	    return calculateGrade(percentage);
	}
	//1st block grade in percentage
	//2nd block grade in raw score 45-50
	//3rd average in  in multiple subject
	
	public static String calculateGrade(double[ ] subjectScores){
	    double total = 0;
	    for (double score : subjectScores) {
	        total += score;
	    }
	    double average = total/ subjectScores.length;
	    return calculateGrade(average);
	}
	 
	 public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	     
	     System.out.print("Enter percentage score: ");
	     double percent = scanner.nextDouble( );
	     System.out.println("Grade: " +  calculateGrade(percent));
	     
	     System.out.print("\nEnter raw score: ");
	     int score = scanner.nextInt( );
	     System.out.print("Enter maximum score : ");
	     int max = scanner.nextInt( );
	     System.out.println("Grade: " + calculateGrade(score, max));
	     
	     System.out.print("\nEnter number of subjects: ");
	     int numSubjects = scanner.nextInt( );
	     double[ ] subjects = new double[numSubjects];
	     
	     for( int i = 0; i < numSubjects; i++){
	         System.out.print("Enter scote for subject " + (i + 1) + ": ");
	         subjects[i] = scanner.nextDouble();
	     }
	     
	     System.out.println("Final Grade: " + calculateGrade(subjects));
	     
	     scanner.close();
	
	}
             }
