import java.util.Scanner;
import java.util.HashMap;

    class Student{
        public String name;
        public int rollNo;
        public int age;
        public int marks;
        // constructor method are the method those have same name as class as they do not have return type.
        public Student(String name, int rollNo, int age, int marks){
            this.name=name;
            this.rollNo=rollNo;
            this.age=age;
            this.marks=marks;
        }
        public int display(){
            return rollNo;
        }
        public void viewStudent(){
            System.out.println("Name: "+name);
            System.out.println("Roll Number: "+rollNo);
            System.out.println("Age: "+age);
            System.out.println("Marks: "+marks);
        }
    }
    public class studentDatabase {
        
    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Student> database = new HashMap<Integer,Student>();

        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. View student");
            System.out.println("3. Search student");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: System.out.print("Enter your Name: ");
                        String name=sc.nextLine();
                        System.out.print("Enter your Roll Number: ");
                        int rollNo=sc.nextInt();
                        System.out.print("Enter your Age: ");
                        int age=sc.nextInt();
                        System.out.print("Enter your Marks: ");
                        int marks=sc.nextInt();
                        Student std=new Student(name, rollNo, age, marks);
                        database.put(rollNo,std);
                        System.out.println("Student Added Successfully");

                case 2: System.out.println("List of Student: ");
                        for(Student i:database.values()){
                            i.viewStudent();
                        }
                        System.out.println("******************************");
                        break;
                case 3: System.out.print("Enter your Roll Number: ");

                        int roll=sc.nextInt();
                        Student data=database.get(roll);
                        if(data!=null){
                            data.viewStudent();
                        }
                        else{
                            System.out.println("Student Not Found");
                        }
                        System.out.println("******************************");
                        break;
                case 4: int totalStudent=database.size();

                        int totalMarks=0;
                        for(Student j:database.values()){
                            totalMarks+=j.marks;
                        }
                        double average= (double) totalMarks/totalStudent;
                        System.out.println("Average Marks: "+average);
                        System.out.println("******************************");
                        break;
                case 5: System.exit(0);

                        System.out.println("******************************");
                        break;

                default:System.out.println("Invaild Choice");
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
