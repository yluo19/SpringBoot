package com.yuro.springboot.springbootdemo1.Controller;


import com.yuro.springboot.springbootdemo1.domain.Book;
import com.yuro.springboot.springbootdemo1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 功能：获取全部书单
     *
     * @return
     */
    @GetMapping("/books")
    public List<Book> getAllBooks(){

        return bookService.getAll();
    }

    /**
     * 新增一条书单信息
     * @param name
     * @param author
     * @param description
     * @param status
     * @return
     */
    @PostMapping("/books")
    public Book postBook(
                         @RequestParam String name,
                         @RequestParam String author,
                         @RequestParam String description,
                         @RequestParam Integer status){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.saveBook(book);
    }

    /**
     * 获取一条书单信息
     * @param id
     * @return
     */
    @GetMapping("/books/{id}")
    public Optional<Book> getOne(@PathVariable Long id) {

        return bookService.getOneBook(id);
    }

    /**
     * 更新一条书单信息
     * @param id
     * @param name
     * @param author
     * @param description
     * @param status
     * @return
     */
    @PutMapping("/books")
    public Book update( @RequestParam Long id,
                        @RequestParam String name,
                        @RequestParam String author,
                        @RequestParam String description,
                        @RequestParam Integer status) {

        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.saveBook(book);

    }

    /**
     * 删除一条书单
     * @param id
     */
    @DeleteMapping("books/{id}")
    public void deleteOne(@PathVariable Long id){

        bookService.deleteOneBook(id);
    }

    /**
     * 根据author来查询书单列表
     * @param author
     * @return
     */
    @PostMapping("/books/byas")
    public List<Book> findByAuthorAndStatus(@RequestParam String author,
                                   @RequestParam Integer status){
        return bookService.findByAuthorAndStatus(author,status);
    }


    @PostMapping("/books/bydes")
    public List<Book> findByAuthorAndStatus(@RequestParam String description){
        return bookService.findByDescriptionEnds(description);
    }
}
