package javalang.learnbasics;

/*
 * Class with basic concepts of java
 *
 */
public class BasicLearning {
    // Basic Attributes and types
    private String name;
    private int age;
    private double stature;
    private float wheight;
    // Arrays
    private double[] grades;
    // Attributes Statics
    private static double minAvarage;
    // Initializer blocks
    static {
        BasicLearning.minAvarage = 6.0;
    }
    {
        this.stature = 1.0D;
        this.wheight = 5.0F;
    }
    // Constructors
    public BasicLearning(){}
    public BasicLearning(String name, int age){
        this.name = name;
        this.age = age;
    }
    public BasicLearning(String name, int age, double stature, float wheight){
        this.name = name;
        this.age = age;
        this.stature = stature;
        this.wheight = wheight;
    }
    // Getters ans Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getStature() {
        return stature;
    }

    public void setStature(double stature) {
        this.stature = stature;
    }

    public float getWheight() {
        return wheight;
    }

    public void setWheight(float wheight) {
        this.wheight = wheight;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public static double getMinAvarage() {
        return minAvarage;
    }

    public static void setMinAvarage(double minAvarage) {
        BasicLearning.minAvarage = minAvarage;
    }
    // Others functions
    private double getAverage(){
        double average = 0;
        for (double grade: this.grades){
            average += grade;
        }
        average = average / this.grades.length;
        return average;
    }
    private boolean isApproved(){
        if (this.getAverage() >= BasicLearning.minAvarage){
            return true;
        }
        return false;
    }
    public void print(){
        System.out.println("###############");
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("Stacture: "+this.stature);
        System.out.println("Wheight: "+this.wheight);
        System.out.println("--------------");
        System.out.println("Grades: (avarage = "+BasicLearning.minAvarage+")");
        for(int i=0; i < this.grades.length; i++){
            System.out.println((i+1)+" - "+this.grades[i]);
        }
        System.out.printf("Average from %s : %.2f \n", this.name, this.getAverage());
        System.out.print("Situation: ");
        if (this.isApproved()) {
            System.out.println("Approved");
        }else{
            System.out.println("Reproved");
        }
        System.out.println("################");
        System.out.println(" ");
    }
}
