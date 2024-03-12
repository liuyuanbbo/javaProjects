package org.jcz.wiki.service;

import org.jcz.wiki.common.PageR;
import org.jcz.wiki.model.Ebook;

public interface EbookService {
    // 查询所有电子书(分页)
    PageR<Ebook> list(Integer pageNum, Integer pageSize);

    // 根据书名模糊查询电子书(分页)
    PageR<Ebook> likeList(Integer pageNum, Integer pageSize, String bookName);

    // 插入/更新 电子书
    void insertOrUpdate(Ebook ebook);
}
