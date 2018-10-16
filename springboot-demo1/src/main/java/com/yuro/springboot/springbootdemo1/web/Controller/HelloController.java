package com.yuro.springboot.springbootdemo1.web.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ hello Spring Boot
 *
 * @RestController 是Restful风格的Controller
 * @Controller 返回字符串是要映射模版(thymeleaf 模版 )， 如果要返回字符串要加@ResponseBody
 */
//@RestController //给HelloController标示为控制器
@Controller
@RequestMapping("/api/v1")
public class HelloController {

    /**
     * @RequestMapping
     *
     * 1。在方法之上 ： 对应url 映射请求到目标方法
     * 2。在类之上 : 对应整个controller的url的根路径
     *
     * @return String 或者 返回实体类是json格式
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET) // 标记为GET请求，通过RESTful架构定义资源
    public String hello() {

        return "hello";
    }


    /**
     * 正则表达式：
     *      {参数名:正则表达式}
     *
     * GET请求 + 有url传参方式 + @PathVariable
     * @param id
     * @param username
     * @return
     */
    @GetMapping("/books/{id}/{username:[a-z_]+}")  //通过正则表达式可以规范url传参
    @ResponseBody
    public Object getOne(@PathVariable("id") long id,
                         @PathVariable String username) {

        System.out.println("----id----->" + id);

        Map<String, Object> book = new LinkedHashMap<>();

        book.put("name", "找工作指南");
        book.put("isbn", "88888888");
        book.put("author", "Yuro");
        book.put("borrower", username);
        return book;
    }

    /**
     * @RequestParam 传参
     *
     * @return
     */

    @PostMapping("/books")
    @ResponseBody
    public Object postBook(@RequestParam String name,
                           @RequestParam String author,
                           @RequestParam Long isbn) {

        Map<String, Object> book  = new TreeMap<>();
        book.put("bookname", name);
        book.put("author", author);
        book.put("isbn", isbn);
        return book;
    }

    /**
     * 模拟实现分页
     */
    @GetMapping("/books")
    @ResponseBody
    public Object getPageBooks(@RequestParam int page,
                               @RequestParam(defaultValue = "10") int size){

        Map<String, Object> book1 = new HashMap<>();
        book1.put("name", "HarryPotter");
        book1.put("author", "Rolli");
        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "Computer Architecture");
        book2.put("author", "daniu");
        Map<String, Object> book3 = new HashMap<>();
        book3.put("name", "Java");
        book3.put("author", "Oracle");
        Map<String, Object> book4 = new HashMap<>();
        book4.put("name", "Alibaba");
        book4.put("author", "Jack Ma");

        List<Map> contents = new ArrayList<>();
        contents.add(book1); contents.add(book2); contents.add(book3); contents.add(book4);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("size", size);
        pageMap.put("content", contents );

        return pageMap;

    }


    /**
     * // 什么都不传时，什么请求都可以接收
     * @return
     */
    @RequestMapping()
    public String helloNoParam() {
        return "hello";
    }


    /**
     * GetMapping, PostMapping, 是简写方式（常用）
     *
     * @return
     */
    @GetMapping("/gethello")
    @ResponseBody  //返回不是模版的
    public String helloDefaultGet() {
        return "hello Default Get Mapping";
    }

    @GetMapping("/booksall")
    public String books(){
        return "books";
    }


}
