package singlylinkedlist.socialmediafriendconnections;

class User {
    int userId;
    String name;
    int age;
    FriendNode friendsHead;  // Head of the linked list for friends
    User next;

    // Constructor to initialize a user
    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendsHead = null;  // Initially, the user has no friends
    }

    // Add a friend to the user's list
    void addFriend(int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (friendsHead == null) {
            friendsHead = newFriend;
        } else {
            FriendNode temp = friendsHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newFriend;
        }
    }

    // Remove a friend from the user's list
    void removeFriend(int friendId) {
        if (friendsHead == null) return;

        if (friendsHead.friendId == friendId) {
            friendsHead = friendsHead.next;
            return;
        }

        FriendNode temp = friendsHead;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Display all the friends of the user
    void displayFriends() {
        FriendNode temp = friendsHead;
        System.out.print(name + "'s Friends: ");
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count the number of friends
    int countFriends() {
        int count = 0;
        FriendNode temp = friendsHead;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

