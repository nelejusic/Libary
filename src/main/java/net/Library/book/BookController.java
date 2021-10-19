package net.Library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam("keyword") String keyword){
        return bookRepository.search(keyword);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/rent/{id}")
    public void rentBook(@PathVariable("id") Long id){
        Book book = bookRepository.getOne(id);
        if(book == null){
            throw new BookNotFoundException(id);
        }
        else{
            int copies = book.getAvailableCopies();
            if(copies > 0){
                book.setAvailableCopies(copies-1);
            }
            bookRepository.save(book);
        }
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
