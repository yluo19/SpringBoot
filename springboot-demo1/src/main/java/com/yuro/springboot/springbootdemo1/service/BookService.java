package com.yuro.springboot.springbootdemo1.service;

import com.yuro.springboot.springbootdemo1.domain.Book;
import com.yuro.springboot.springbootdemo1.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 获取全部书单列表
     * @return
     */
    public List<Book> getAll(){

        return bookRepository.findAll();
    }

    /**
     * 新增一个书单信息
     * @param book
     * @return
     */
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    /**
     * 获取一条书单信息
     * @param id
     * @return
     */
    public Optional<Book> getOneBook(Long id){
        return  bookRepository.findById(id);
    }

    /**
     * 删除一条书单信息
     * @param id
     */
    public void deleteOneBook(Long id){
        bookRepository.deleteById(id);
    }

    /**
     * 根据author和status 查询书单列表
     * @param author
     * @return
     */
    public List<Book> findByAuthorAndStatus(String author, Integer status){

        return bookRepository.findByAuthorAndStatus(author, status);
    }

    /**
     * 根据author查询书单列表
     * @param author
     * @return
     */
    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    /**
     * Like 以end 结尾的like 查询书单列表
     * @param end
     * @return
     */
    public List<Book> findByDescriptionEnds(String end){
        return bookRepository.findByDescriptionEndingWith(end);
    }
}
