package mangement;

import entities.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookManager {

    HashMap<String, Book> nameToBooks =new HashMap<>();
    List<Book> books=new ArrayList<>();
    public boolean addUser(String name,int quantity){
                    if(nameToBooks.containsKey(name))
                            return false;
                    Book book=new Book(name,quantity);
                    nameToBooks.put(name,book);
                    books.add(book)  ;
                    return true;
    }


    public  List<String>searchByPrefix(String prefix ){
        List<String> names= nameToBooks.entrySet().stream().map(pair->pair.getKey()).collect(Collectors.toList());

        List<String>result=names.stream().filter(name->name.substring(0,prefix.length()).equals(prefix)).toList();
        return result;
    }


    public List<String>booksSortedById(){

         List<Book>temp=getSortedBooks(Book.COMPARING_BY_ID);
         return temp.stream().map(Book::toString).toList();
    }

    public List<String>booksSortedByName(){

        List<Book>temp=getSortedBooks(Book.COMPARING_BY_NAME);
        return temp.stream().map(Book::toString).toList();
    }

    private List<Book>getSortedBooks(Comparator comparator){
        List<Book>temp=new ArrayList<>(books);
        temp.sort(comparator);
        return temp;
    }
    public final int mapNameToId(String name){
        Book book=nameToBooks.get(name);
        return book==null?-1:book.getId();
    }


    public boolean ReturnBook(String name){
            Book book=this.nameToBooks.get(name);
            if(book==null)
                return false;
            book.returnBook();
            return true;
    }

    public boolean borrowBook(String name){
        Book book=this.nameToBooks.get(name);
        if(book==null)
            return false;
       return  book.canBorrow();

    }
    public static void main(String[] args) {
        Map<String,String>map= new HashMap<>( );
        map.put("hegazy","samy");
        map.put("heg","ahmed");
        map.put("hegzin","ali");


    }

}
