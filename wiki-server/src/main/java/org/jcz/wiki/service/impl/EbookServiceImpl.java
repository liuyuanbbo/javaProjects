package org.jcz.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.jcz.wiki.common.PageR;
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
    public PageR<Ebook> list(Integer pageNum, Integer pageSize) {
        PageR<Ebook> pageR = new PageR<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Ebook> list = ebookMapper.list();
        PageInfo<Ebook> pageInfo = new PageInfo<>(list);
        pageR.setTotal(pageInfo.getTotal());
        pageR.setItems(pageInfo.getList());
        return pageR;
    }

    @Override
    public PageR<Ebook> likeList(Integer pageNum, Integer pageSize, String bookName) {
        PageR<Ebook> pageR = new PageR<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Ebook> list = ebookMapper.likeList(bookName);
        PageInfo<Ebook> pageInfo = new PageInfo<>(list);
        pageR.setTotal(pageInfo.getTotal());
        pageR.setItems(pageInfo.getList());
        return pageR;
    }

    @Override
    public void insertOrUpdate(Ebook ebook) {
        Long id = ebook.getId();
        // 执行插入
        if (id == null) {
            ebookMapper.insert(ebook);
        } else {
            // 执行更新
            ebookMapper.update(ebook);
        }
    }

    @Override
    public void delete(Long id) {
        ebookMapper.delete(id);
    }
}
