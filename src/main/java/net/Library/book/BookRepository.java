package net.Library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT a FROM Book a WHERE CONCAT(a.title, a.author) LIKE %?1%")
    public List<Book> search(String keyword);

    public Book findByTitle(String title);

}
