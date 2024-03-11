package org.jcz.wiki.service;

import org.jcz.wiki.model.Ebook;

import java.util.List;

public interface EbookService {
    // 查询所有电子书(分页)
    List<Ebook> list();

    // 根据书名模糊查询电子书(分页)
    List<Ebook> likeList(String bookName);
}
