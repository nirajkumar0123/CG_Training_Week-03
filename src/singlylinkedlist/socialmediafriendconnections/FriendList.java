package singlylinkedlist.socialmediafriendconnections;

import java.util.ArrayList;
import java.util.List;

class FriendList {
    User head;  // Head of the linked list of users

    FriendList() {
        this.head = null;  // Initially, the list of users is empty
    }

    // Add a new user to the list
    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp != null) {
                if (temp.userId == userId) {
                    System.out.println("User with ID " + userId + " already exists.");
                    return;
                }
                temp = temp.next;
            }
            newUser.next = head;
            head = newUser;
        }
    }

    // Add a friend connection between two users
    void addFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println("Friend connection added between " + userId1 + " and " + userId2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend connection between two users
    void removeFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println("Friend connection removed between " + userId1 + " and " + userId2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find a user by their ID
    User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Find a user by their name
    User findUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Find mutual friends between two users
    void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            FriendNode temp1 = user1.friendsHead;
            List<Integer> mutualFriends = new ArrayList<>();
            while (temp1 != null) {
                FriendNode temp2 = user2.friendsHead;
                while (temp2 != null) {
                    if (temp1.friendId == temp2.friendId) {
                        mutualFriends.add(temp1.friendId);
                    }
                    temp2 = temp2.next;
                }
                temp1 = temp1.next;
            }
            System.out.println("Mutual Friends between " + userId1 + " and " + userId2 + ": " + mutualFriends);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all users in the list
    void displayUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}


