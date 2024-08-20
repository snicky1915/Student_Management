package Baitap1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1", "nam1", "java", 5));
        studentList.add(new Student("2", "vu1", "c", 5));
        studentList.add(new Student("3", "nam2", "c++", 5));
        studentList.add(new Student("4", "nam3", "python", 5));
        studentList.add(new Student("5", "cuong1", "c", 5));
        studentList.add(new Student("6", "cuong2", "c++", 5));
        studentList.add(new Student("7", "nguyen van a", "c", 5));
        studentList.add(new Student("8", "1", "html", 5));
        studentList.add(new Student("9", "af", "daf", 5));
        studentList.add(new Student("10", "last", "java", 5));  // Danh sách ban đầu đã đủ 10 sinh viên
        int i = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("WELCOME TO STUDENT MANAGEMENT\n");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");

            System.out.print("Hay nhap vao yeu cau: ");
            i = scanner.nextInt();
            scanner.nextLine();

            switch (i) {
                case 1:
                    createStudent(studentList, scanner);
                    break;
                case 2:
                    findAndSortStudent(studentList, scanner);
                    break;
                case 3:
                    updateOrDeleteStudent(studentList, scanner);
                    break;
                case 4:
                    reportStudents(studentList);
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long thu lai.");
            }
        } while (i != 5);
        scanner.close();
    }

    public static void createStudent(ArrayList<Student> studentList, Scanner scanner) {
        while (true) {
            if (studentList.size() >= 10) {
                System.out.print("Danh sách đã đầy! Bạn có muốn tiếp tục thêm sinh viên? (Y/N): ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    break;
                } else if (!choice.equalsIgnoreCase("Y")) {
                    System.out.println("Lua chon khong hop le, quay lai menu chinh.");
                    break;
                }
            }
            System.out.print("Nhap vao ID sinh vien: ");
            String id = scanner.nextLine();

            if (isIdExists(studentList, id)) {
                System.out.println("ID nay da ton tai. Vui long nhap ID khac.");
                continue; // Quay lại vòng lặp để yêu cầu nhập lại ID
            }

            System.out.print("Nhap vao ten sinh vien: ");
            String studentName = scanner.nextLine();
            System.out.print("Nhap vao mon hoc: ");
            String courseName = scanner.nextLine();
            System.out.print("Nhap vao nam hoc: ");
            int semester = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            studentList.add(new Student(id, studentName, courseName, semester));
            System.out.println("Sinh vien da duoc them thanh cong!\n");


        }
    }

    public static boolean isIdExists(ArrayList<Student> studentList, String id) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    public static void findAndSortStudent(ArrayList<Student> studentList, Scanner scanner) {
        int a = 0;
        do {
            System.out.println("Tim kiem va sap xep");
            System.out.println("1.Tim kiem theo ten");
            System.out.println("2.Sap xep danh sach theo ten");
            System.out.println("3.Exit");

            a = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            if (a == 1) {
                System.out.print("Nhap vao ten muon tim kiem: ");
                String name = scanner.nextLine();

                ArrayList<Student> foundStudents = new ArrayList<>();
                for (Student student : studentList) {
                    if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                        foundStudents.add(student);
                    }
                }
                if (foundStudents.isEmpty()) {
                    System.out.println("Khong tim thay sinh vien nao voi ten: " + name);
                } else {
                    System.out.println("Danh sach sinh vien tim kiem duoc la:");
                    for (Student student : foundStudents) {
                        System.out.println(student);
                    }
                }
            } else if (a == 2) {
                Collections.sort(studentList);
                System.out.println("Danh sách sinh viên đã sắp xếp:");
                for (Student student : studentList) {
                    System.out.println(student);
                }
            } else if (a != 3) {
                System.out.println("Vui long nhap lai");
            }
        } while (a != 3);
    }

    public static void updateOrDeleteStudent(ArrayList<Student> studentList, Scanner scanner) {
        System.out.print("Nhap vao Id sinh vien: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                found = true;
                System.out.println("Da tim thay sinh vien\nThong tin sinh vien: " + student);
                System.out.print("Nhap U de cap nhat sinh vien va D de xoa sinh vien: ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("U")) {
                    System.out.println("Nhap lai thong tin sinh vien!");
                    System.out.print("Nhap vao ten sinh vien: ");
                    String studentName = scanner.nextLine();

                    scanner.nextLine(); // Đọc bỏ dòng trống
                    System.out.print("Nhap vao mon hoc: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Nhap vao nam hoc: ");
                    int semester = scanner.nextInt();

                    student.setStudentName(studentName);
                    student.setCourseName(courseName);
                    student.setSemester(semester);
                    System.out.println("Cap nhat thanh cong!");
                } else if (choice.equalsIgnoreCase("D")) {
                    studentList.remove(student);
                    System.out.println("Sinh vien da bi xoa.");
                } else {
                    System.out.println("Lua chon khong hop le, vui long thu lai.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien voi ID da cho.");
        }
    }

    public static void reportStudents(ArrayList<Student> studentList) {
        Collections.sort(studentList);
        System.out.printf("%-20s %-20s\n", "Student Name", "Course Name");
        System.out.println("--------------------------------------------");
        for (Student student : studentList) {
            System.out.println(student.toNameAndCourseString());
        }
        System.out.println("Tong so sinh vien: " + studentList.size());
    }
}
