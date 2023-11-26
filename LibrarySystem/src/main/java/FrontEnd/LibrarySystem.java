package FrontEnd;

import mangement.BookManager;
import mangement.UserManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static FrontEnd.HelperClass.*;

public class LibrarySystem {
    private   static Scanner input=new Scanner(System.in);
    private   final BookManager bookManager=new BookManager();
    private final UserManager userManager=new UserManager();
    public  void menue(){
        // i want system to read option from fille
        //after reading file return the result in list
        List<String>choices=readingOptionFromFile("choices.txt");
        while (true){
            int choice=displayChoice(choices);
            if(choice==1)
                //mean add new book name quantity
              addBook();

            else if(choice==2)
                //search books by prefix
                searchBooksByPrefix().stream().forEach(System.out::println);
            else if (choice==3)
                //print who borrowed books by name
                whoBorrowedBookByName().forEach(System.out::println);

            else if(choice==4)
                //print books sorted by id
                this.bookManager.booksSortedById().stream().forEach(System.out::println);

            else if(choice==5)
                //print books sorted by name
                this.bookManager.booksSortedByName().stream().forEach(System.out::println);

            else if(choice==6)
                //I want to add new user
                addNewUser();
            else if(choice==7)
                //user borrow book;
                this.userBorrowBook();
            else if(choice==8)
                //user return boook
                this.userReturnBook();
            else if(choice==9)
                this.userManager.getUsers().forEach(System.out::println);
            else if(choice==10)
                break;

        }
    }

    public void userReturnBook(){
        print("Enter user name and book name");
        String user=input.next().toLowerCase();
        String bookName=input.next().toLowerCase();
        if(!this.bookManager.borrowBook(bookName)) {
            print("Invalid book ");
            return;
        }

        int bookId=this.bookManager.mapNameToId(bookName);
        boolean validUser=this.userManager.userReturnBook(user,bookId);
        if(!validUser)
            print("Invalid user or the user doesn't take this book");
        else
            print("process is success");

    }
    public void userBorrowBook(){
        print("Enter user name and book name");
        String user=input.next().toLowerCase();
        String bookName=input.next().toLowerCase();
        if(!this.bookManager.borrowBook(bookName)){
            print("Invalid book try ");
            return ;
        }

        int bookId=this.bookManager.mapNameToId(bookName);
      boolean valid=  this.userManager.userBorrowBook(user,bookId);
        if(valid==false)
                print("User already take this book");
        else
            System.out.println("The process is success ");
    }
    private List<String>whoBorrowedBookByName(){
        print("Enter book anme :");
        String name=input.next().toLowerCase();
        int nameToInt= bookManager.mapNameToId(name);
        List<String>names=userManager.whoBorrowedBookByName(nameToInt);
        return names;
    }
    private List<String> searchBooksByPrefix(){
            String prefix=input.next();
            List<String>names=this.bookManager.searchByPrefix(prefix);
           return names;
    }
    private void addBook(){
        String name=input.next().toLowerCase();
        int quantity=input.nextInt();
      boolean exists=  bookManager.addUser(name,quantity);
        if(exists==false)
            print("This book was already exists");
        else
            print("new new book  is added".concat(name));

    }


    public void addNewUser(){
        print("Enter the user name");
        String name=input.next().toLowerCase();
       boolean isUserExists= this.userManager.addNewUser(name);
        if(!isUserExists)
                print("The user was already in the system");
        else
            print(name.concat(" is add to the system"));
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String txt=scan.next();
        int number=scan.nextInt();
        System.out.println(txt+" "+number);
    }

}
