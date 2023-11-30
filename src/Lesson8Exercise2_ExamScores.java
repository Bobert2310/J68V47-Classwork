public class Lesson8Exercise2_ExamScores {
    public static void main (String[] args) {
        int[] TestScores = {52, 79, 43, 97, 10};
        int sum = TestScores[0] + TestScores[1] + TestScores[2] + TestScores[3] + TestScores[4] ;
        int Average = sum / TestScores.length;
        for (int index = 0; index < TestScores.length; index++) {
            System.out.println(TestScores[index]);
        }
        System.out.println("The average of all test scores = " + Average);
    }
}


