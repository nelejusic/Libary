package net.Library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LibraryDispatcher {

    @GetMapping("/all")
    public String allBooks(){
        return "books.html";
    }
}
