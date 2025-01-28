package singlylinkedlist.studentrecordmanagement;

public class StudentRecordManagement {
    public static void main(String[] args) {
       StudentList s1 = new StudentList();
       s1.addStudentBegin(1, "Niraj", 20, 'A');
       s1.addStudentBegin(2, "Abhii", 18, 'B');
       s1.addStudentBegin(3, "Rahul", 16, 'C');
       s1.display();
       s1.addAtEnd(4, "Renu", 18, 'A');
       s1.display();
       s1.addPosition(5, "Raj", 19,  'B', 2);
       s1.display();
       s1.addPosition(6, "Rohit", 19,  'B', 1);
       s1.display();
       s1.addPosition(7, "Monu", 12, 'A', 7);
       s1.display();
       System.out.println();

       Student deleted = s1.delete(4);
       System.out.println("Deleted student name is : " + deleted.name);

       System.out.println();
       System.out.println("After deleting the remaining students are as follows : - >");
       s1.display();
       System.out.println();

       try {
           Student searched = s1.searchStudent(3);
           System.out.println("Student is :" + searched.name);
       }catch(Exception e){
           System.out.println("Roll Number is not found might be deleted!");
       }
        System.out.println();

       Student changedGrade = s1.updateGrade(1, 'C');
        System.out.println("After the grade updation name is , "+changedGrade.name + " updated grade is : " + changedGrade.grade);
    }
}
