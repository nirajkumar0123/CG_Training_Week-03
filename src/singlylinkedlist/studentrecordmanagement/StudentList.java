package singlylinkedlist.studentrecordmanagement;

class StudentList {
    Student head;

    //add at begining
    void addStudentBegin(int rollNumber, String name, int age, char grade){
       Student s = new Student(rollNumber, name, age, grade);
       s.next = head;
       head = s;
    }

    //add at begining
//    void addStudentBegin(Student s){
//        new Student(s.rollNumber, s.name, s.age, s.grade);
//        s.next = head;
//        head = s;
//    }

    //add at end
    void addAtEnd(int rollNumber, String name, int age, char grade){
        Student s = new Student(rollNumber, name, age, grade);

        //if head is null
        if(head == null){
            head = s;
            return;
        }

        Student temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = s;
    }

    //insert at specific position
    void addPosition(int rollNumber, String name, int age, char grade, int pos){
        Student s = new Student(rollNumber, name, age, grade);
        //if insert at 1st position
        if(pos == 1){
            addStudentBegin(rollNumber, name, age, grade);
            return;
        }

        Student temp = head;
        for(int i = 1; i <= pos- 2; i++){
           temp = temp.next;
        }
        s.next = temp.next;
        temp.next = s;
    }

    //display
    void display(){
      Student temp = head;
      while(temp != null){
          //System.out.println("Roll Number : " +temp.rollNumber + ", Name : " + temp.name + ", Age : " + temp.age + " , Grade : " + temp.grade);
          System.out.print(temp.name + " ");
          temp = temp.next;
      }
        System.out.println();
    }

    //delete student by Roll number
    Student delete(int rollNumber){
        Student temp = head;
        Student deleted;
        //if we want to delete the 1st student with roll number
        if(temp.rollNumber == rollNumber){
            deleted = temp;
            head = head.next;
            return deleted;
        }

        while(temp.next.rollNumber != rollNumber){
            temp = temp.next;
        }

        //store the student into node
        deleted = temp.next;
        temp.next = temp.next.next;
        return deleted;
    }

    //search student by roll number
    Student searchStudent(int rollNumber){
        Student temp = head;
       Student searched;
        if(temp.rollNumber == rollNumber){
            searched = temp;
            head = head.next;
            return searched;
        }

        while(temp.next.rollNumber != rollNumber){
            temp = temp.next;
        }
        searched = temp.next;
        return searched;
    }

    //update rollnumber
    Student updateGrade(int rollNumber,  char updatedGrade){
        Student temp = head;
        Student updatedNode;

        if(temp.rollNumber == rollNumber){
            temp.grade = updatedGrade;
            updatedNode = temp;
            return updatedNode;
        }

        while(temp.next.rollNumber != rollNumber){
            temp = temp.next;
        }
        temp.next.grade = updatedGrade;
        updatedNode = temp.next;
        return updatedNode;
    }
}
