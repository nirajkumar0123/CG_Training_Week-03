package singlylinkedlist.socialmediafriendconnections;

public class SocialMediaSystemMain {
    public static void main(String[] args) {
        FriendList friendList = new FriendList();

        // Adding users to the system
        friendList.addUser(1, "Alice", 25);
        friendList.addUser(2, "Bob", 30);
        friendList.addUser(3, "Charlie", 28);
        friendList.addUser(4, "David", 22);

        // Adding friend connections
        friendList.addFriend(1, 2);  // Alice and Bob are friends
        friendList.addFriend(1, 3);  // Alice and Charlie are friends
        friendList.addFriend(2, 4);  // Bob and David are friends

        // Display all friends of a user
        friendList.findUserById(1).displayFriends();  // Display Alice's friends
        friendList.findUserById(2).displayFriends();  // Display Bob's friends

        // Finding mutual friends between Alice and Bob
        friendList.findMutualFriends(1, 2);

        // Remove a friend connection
        friendList.removeFriend(1, 2);  // Remove the friend connection between Alice and Bob

        // Display friends after removal
        friendList.findUserById(1).displayFriends();  // Display Alice's friends after removal

        // Count the number of friends of a user
        System.out.println("Alice has " + friendList.findUserById(1).countFriends() + " friends.");
        System.out.println("Bob has " + friendList.findUserById(2).countFriends() + " friends.");

        // Search for a user by Name
        User searchedUser = friendList.findUserByName("Charlie");
        if (searchedUser != null) {
            System.out.println("Found user: " + searchedUser.name);
        }

        // Display all users in the system
        friendList.displayUsers();
    }
}

