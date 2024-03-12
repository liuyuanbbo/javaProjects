package org.jcz.wiki.mapper.mytest;

import org.apache.ibatis.annotations.Param;
import org.jcz.wiki.model.Ebook;

import java.util.List;

public interface EbookMapper {
    // 查询所有电子书(分页)
    List<Ebook> list();

    // 根据书名模糊查询电子书(分页)
    List<Ebook> likeList(@Param("bookName") String bookName);

    // 插入电子书
    void insert(Ebook ebook);

    // 更新电子书
    void update(Ebook ebook);
}
