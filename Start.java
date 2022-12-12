package StudentManagementApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.Student;
import com.student.StudentDao;

public class Start {
    public static void main(String[] args)throws IOException {
        System.out.println("Welcome to Student Management App");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.println("Press 1 to Add Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display Students");
            System.out.println("Press 4 to Exit");
            int c = Integer.parseInt(br.readLine());

            if (c==1){
                // add
                System.out.println("Enter Student Name :");
                String name = br.readLine();

                System.out.println("Enter Student Phone :");
                String phone = br.readLine();

                System.out.println("Enter Student City :");
                String city = br.readLine();

                //create student object to store student
                Student st = new Student(name,phone,city);
                boolean answer = StudentDao.insertStudentToDB(st);
                if (answer)
                {
                    System.out.println("Student is added successfully...");
                }
                else{
                    System.out.println("Something went wrong, try again !");
                }
                System.out.println(st);
            }
            else if (c==2){
                // delete 
                System.out.println("Enter the student id to delete :");
                int userId = Integer.parseInt(br.readLine());
                boolean f = StudentDao.deleteStudent(userId);
                if (f){
                    System.out.println("Deleted ...");
                }
                else{
                    System.out.println("Something went wrong !");
                }
            }
            else if (c==3){
                // display 
                StudentDao.showAllStudent();
            }
            else if (c==4){
                // exit 
                break;
            }
            else{
                // Wrong Choice 
            }
        }
        System.out.println("Thank you for using my application");
    }
}