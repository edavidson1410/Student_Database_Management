package org.example;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeLevel;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private final static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter students name and year.
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();
        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student grade level: ");
        this.gradeLevel = in.nextInt();

        setStudentID();

        System.out.println(firstName + " " + lastName + " is a " + gradeLevel + ". ID=" + studentID);
    }

    // Generate 5 digit unique ID.
    private void setStudentID() {
        // Grade Level + ID.
        id++;
        this.studentID = gradeLevel + "" + id;
    }
    // Enroll in Courses.
    public void enroll() {
        // Get inside a loop, user hits 0 when done.
        do{
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
        }
            else { break; }
    }   while (1 != 0);

        System.out.println("Enrolled in: " + courses);
        System.out.println("Tuition Balance: " + tuitionBalance);
    }

    // View balance.
    public void viewBalance() {
        System.out.println("Your balance is $" + tuitionBalance);
    }
    // Pay tuition.
    public void payTuition() {
        viewBalance();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your payment: $");
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for the payment of $" + payment);
        viewBalance();
    }
    // Show status.
    public String showInfo() {
        return "Name:" + firstName + " " + lastName +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }

}
