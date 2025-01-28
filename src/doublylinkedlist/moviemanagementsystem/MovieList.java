package doublylinkedlist.moviemanagementsystem;

class MovieList {
    Movie head, tail;

    //add at begining
    void addAtBegining(String title, String director, int yearOfRelease, int rating){
        Movie m1 = new Movie(title, director, yearOfRelease, rating);
        if(head == null){
            head = tail = m1;
        }else {
            m1.next = head;
            head.prev = m1;
            head = m1;
        }
    }

    //add at end
    void addAtEnd(String title, String director, int yearOfRelease, int rating){
        Movie m1 = new Movie(title, director, yearOfRelease, rating);

        if(tail == null){
            head = tail = m1;
        }

        Movie temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        m1.prev = tail;
        tail.next = m1;
        tail = m1;
    }

    void displayForward(){
        Movie temp = head;
        while(temp != null){
            System.out.print(temp.title + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    //display reverse method
    void displayReverse(){
        Movie temp = tail;
        while(temp != null){
            System.out.print(temp.title + "->");
            temp = temp.prev;
        }
        System.out.println();
    }

    //remove a movie by title
    Movie remove(String title){
        Movie temp = head;
        Movie removed;

        if(temp.title == title){
           removed = temp;
           head = head.next;
           head.next.prev= head;
           return removed;
        }

        while(temp.title != title){
            temp = temp.next;
        }
        removed = temp;
        temp.prev.next = temp.next;
        temp.next.prev= temp.prev;
        return removed;
    }

    //search a movie
    boolean searchMovie(String Director){
        Movie temp = head;
        while(temp != null){
            if(temp.director.equals(Director)){
                return  true;
            }
            temp = temp.next;
        }
        return false;
    }

    //update movie rating
    Movie updateRating(String title, int updateRating){
        Movie temp = head;
        while(temp != null){
            if(temp.title.equals(title)){
                temp.rating = updateRating;
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
