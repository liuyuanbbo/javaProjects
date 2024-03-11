package org.jcz.wiki.service.impl;

import jakarta.annotation.Resource;
import org.jcz.wiki.mapper.mytest.EbookMapper;
import org.jcz.wiki.model.Ebook;
import org.jcz.wiki.service.EbookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {

    @Resource
    EbookMapper ebookMapper;

    @Override
    public List<Ebook> list() {
        return ebookMapper.list();
    }

    @Override
    public List<Ebook> likeList(String bookName) {
        return ebookMapper.likeList(bookName);
    }
}
