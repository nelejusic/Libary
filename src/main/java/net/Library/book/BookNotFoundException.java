package net.Library.book;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super("Couldn't find book with id: " + id);
    }
}
