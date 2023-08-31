package cn.icexmoon.mvcdemo.controller;

import cn.icexmoon.mvcdemo.entity.Book;
import cn.icexmoon.mvcdemo.service.BookService;
import cn.icexmoon.mvcdemo.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.controller
 * @ClassName : .java
 * @createTime : 2023/8/29 16:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public WebResult<List<Book>> getAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        return WebResult.success(allBooks);
    }

    @PostMapping
    public WebResult<Integer> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return WebResult.success(book.getId());
    }

    @PutMapping("/{id}")
    public WebResult<Object> updateBook(@PathVariable("id") Integer id,@RequestBody Book book){
        book.setId(id);
        bookService.updateBook(book);
        return WebResult.success();
    }

    @GetMapping("/{id}")
    public WebResult<Book> getBookInfo(@PathVariable("id") Integer id){
        System.out.println("getBookInfo...");
        Book book = bookService.getBookById(id);
        return WebResult.success(book);
    }

    @DeleteMapping("/{id}")
    public WebResult<Object> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBookById(id);
        return WebResult.success();
    }
}
