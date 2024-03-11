package org.jcz.wiki.controller;

import jakarta.annotation.Resource;
import org.jcz.wiki.common.R;
import org.jcz.wiki.model.Ebook;
import org.jcz.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    EbookService ebookServiceImpl;

    @GetMapping("/list")
    public R<List<Ebook>> list() {
        return R.success(ebookServiceImpl.list());
    }

    @GetMapping("/likeList")
    public R<List<Ebook>> likeList(@RequestParam(required = false, value = "bookName") String bookName) {
        return R.success(ebookServiceImpl.likeList(bookName));
    }

}
