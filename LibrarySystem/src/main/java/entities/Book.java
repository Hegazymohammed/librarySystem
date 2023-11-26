package entities;

import java.util.Comparator;

public class Book {

    private static  int ID_GENERATOR=1;
    private final int id;
    private final String name;

    private int quantity;

    public final static Comparator<Book>COMPARING_BY_ID=Comparator.comparingInt(Book::getId);
    public final static Comparator<Book>COMPARING_BY_NAME=Comparator.comparing(Book::getName);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Book(String name, int quantity){
            this.name=name.toLowerCase();
            this.quantity=quantity;
            this.id=ID_GENERATOR++;
    }

    public boolean canBorrow(){
        if(quantity>0){
            quantity--;
            return true;
        }
       return false;
    }

    public void returnBook(){
        quantity++;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
