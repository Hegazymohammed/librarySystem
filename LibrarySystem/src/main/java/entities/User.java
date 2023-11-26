package entities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class User {

    private static int ID_GENERATOR = 1;

    public static void setIdGenerator(int idGenerator) {
        ID_GENERATOR = idGenerator;
    }

    public final static Comparator<User> COMPARING_BY_ID = Comparator.comparingInt(User::getId);
    public final static Comparator<User>COMPARING_BY_NAME=Comparator.comparing(User::getName);

    public static final int MAX_NUMBER_OF_BOOKS_ID = 100000;
    private final String name;
    private final int id;

    private boolean[] bookIds = new boolean[MAX_NUMBER_OF_BOOKS_ID];

    public User(String name) {
        this.name = name.toLowerCase();
        this.id = ID_GENERATOR++;
    }

    public static int getIdGenerator() {
        return ID_GENERATOR;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean borrowBook(int id) {
        if (this.bookIds[id] == true)
            return false;
        this.bookIds[id] = true;
        return true;
    }


    public boolean returnBook(int id) {
        this.bookIds[id] = false;
        return true;
    }


    public boolean IsUserBorrowBook(int id) {
        return this.bookIds[id];
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


    public static void main(String[] args) {
        User user1 = new User("mostata");
        User user2 = new User("Mohammed");
        User user3 = new User("Samy");
        User user4 = new User("Emam");
        User user5 = new User("Khaled");
        User user6 = new User("dina");
        User user7 = new User("SOAAD");
        User user8 = new User("SAMY");
        User user9 = new User("EMAN");
        List<User>list= Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9);

    }
}
