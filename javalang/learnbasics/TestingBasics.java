package javalang.learnbasics;

public class TestingBasics {
    public static void main(String[] args) {
        // Setting a min average
        BasicLearning.setMinAvarage(7);
        /*
            Creating a objects for Basic Learning
        */
        // Single Student (no initial data)
        BasicLearning studentOne = new BasicLearning();
        // Setting Datas
        studentOne.setName("Arthur");
        studentOne.setAge(15);
        studentOne.setStature(1.60);
        studentOne.setWheight(52);
        // Setting Grades
        studentOne.setGrades(new double[]{6.5,7.8,6.2});
        studentOne.print();

        // Other Student (first datas)
        BasicLearning studentTwo = new BasicLearning("Jonh",16);
        // Setting Datas
        studentTwo.setStature(1.45);
        studentTwo.setWheight(46);
        studentTwo.setGrades(new double[]{8.57,6.4,7.89});
        studentTwo.print();

        // Last Student (all datas on creation)
        BasicLearning studentThree = new BasicLearning("Mary",15,1.65,57);
        studentThree.setGrades(new double[]{9.54,8.47,7.41});
        studentThree.print();
    }
}
