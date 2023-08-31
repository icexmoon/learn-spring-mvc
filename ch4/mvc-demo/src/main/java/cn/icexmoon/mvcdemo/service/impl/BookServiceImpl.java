package cn.icexmoon.mvcdemo.service.impl;

import cn.icexmoon.mvcdemo.entity.Book;
import cn.icexmoon.mvcdemo.mapper.BookMapper;
import cn.icexmoon.mvcdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.service.impl
 * @ClassName : .java
 * @createTime : 2023/8/29 16:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class BookServiceImpl implements BookService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.selectAll();
    }

    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookMapper.selectById(id);
    }

    @Override
    public void deleteBookById(int id) {
        bookMapper.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.update(book);
    }
}
