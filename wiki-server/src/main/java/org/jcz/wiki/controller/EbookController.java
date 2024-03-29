package org.jcz.wiki.controller;

import jakarta.annotation.Resource;
import org.jcz.wiki.common.PageR;
import org.jcz.wiki.common.R;
import org.jcz.wiki.controller.vo.request.InsertOrUpdateReq;
import org.jcz.wiki.model.Ebook;
import org.jcz.wiki.service.EbookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    EbookService ebookServiceImpl;

    @GetMapping("/list")
    public R<PageR<Ebook>> list(@RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(required = false, value = "pageSize", defaultValue = "3") Integer pageSize) {
        return R.success(ebookServiceImpl.list(pageNum, pageSize));
    }

    @GetMapping("/likeList")
    public R<PageR<Ebook>> likeList(@RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, value = "pageSize", defaultValue = "3") Integer pageSize,
                                    @RequestParam(required = false, value = "bookName") String bookName) {
        return R.success(ebookServiceImpl.likeList(pageNum, pageSize, bookName));
    }

    @PostMapping("/insertOrUpdate")
    public R<?> insert(@Validated @RequestBody InsertOrUpdateReq req) {
        Ebook ebook = InsertOrUpdateReq.buildEbook(req);
        ebookServiceImpl.insertOrUpdate(ebook);
        return R.success();
    }

    @PostMapping("/delete")
    public R<?> delete(@RequestParam("id") Long id) {
        ebookServiceImpl.delete(id);
        return R.success();
    }
}
