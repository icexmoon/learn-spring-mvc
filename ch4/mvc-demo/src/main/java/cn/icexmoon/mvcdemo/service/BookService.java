package cn.icexmoon.mvcdemo.service;

import cn.icexmoon.mvcdemo.entity.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.service
 * @ClassName : .java
 * @createTime : 2023/8/29 16:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Transactional
public interface BookService {
    List<Book> getAllBooks();

    void addBook(Book book);

    Book getBookById(int id);

    void deleteBookById(int id);

    void updateBook(Book book);
}
