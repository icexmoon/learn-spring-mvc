package cn.icexmoon.mvcdemo.mapper;

import cn.icexmoon.mvcdemo.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.mapper
 * @ClassName : .java
 * @createTime : 2023/8/29 16:27
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface BookMapper {
    @Select("select * from tbl_book")
    List<Book> selectAll();

    void insert(Book book);

    @Delete("delete from tbl_book where id=#{id}")
    void deleteById(int id);

    @Select("select * from tbl_book where id=#{id}")
    Book selectById(int id);

    void update(Book book);
}
