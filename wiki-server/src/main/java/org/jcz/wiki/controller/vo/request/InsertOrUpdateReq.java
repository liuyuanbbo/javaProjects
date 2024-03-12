package org.jcz.wiki.controller.vo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.jcz.wiki.model.Ebook;

public class InsertOrUpdateReq {
    private Long id;
    @NotBlank(message = "书名不能为空")
    private String name;
    @NotNull(message = "一级分类不能为空")
    private Integer category1Id;
    @NotNull(message = "二级分类不能为空")
    private Integer category2Id;
    private String description;
    @NotBlank(message = "封面不能为空")
    private String cover;
    @NotNull(message = "文档数不能为空")
    private Integer docCount;
    @NotNull(message = "阅读数不能为空")
    private Integer viewCount;
    @NotNull(message = "点赞数不能为空")
    private Integer voteCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Integer category1Id) {
        this.category1Id = category1Id;
    }

    public Integer getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Integer category2Id) {
        this.category2Id = category2Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getDocCount() {
        return docCount;
    }

    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public static Ebook buildEbook(InsertOrUpdateReq req) {
        Ebook ebook = new Ebook();
        ebook.setId(req.getId());
        ebook.setName(req.getName());
        ebook.setCategory1Id(req.getCategory1Id());
        ebook.setCategory2Id(req.getCategory2Id());
        ebook.setCover(req.getCover());
        ebook.setDescription(req.getDescription());
        ebook.setDocCount(req.getDocCount());
        ebook.setViewCount(req.getViewCount());
        ebook.setVoteCount(req.getVoteCount());
        return ebook;
    }
}
