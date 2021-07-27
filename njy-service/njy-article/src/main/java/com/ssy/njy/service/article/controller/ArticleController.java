package com.ssy.njy.service.article.controller;

import com.ssy.njy.api.article.entity.Article;
import com.ssy.njy.api.article.vo.ArticleVO;
import com.ssy.njy.api.user.vo.UserVO;
import com.ssy.njy.common.result.R;
import com.ssy.njy.service.article.feign.UserClient;
import com.ssy.njy.service.article.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ArticleController
 *
 * @author: mqxu
 * @date: 2021-07-26
 **/
@RestController
@RequestMapping(value = "article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private UserClient userClient;

    @ApiOperation(value = "根据id查询文章VO", notes = "传入文章id")
    @GetMapping("/info/{articleId}")
    public R<ArticleVO> getArticleVO(@PathVariable Long articleId) {
        Article article = articleService.getArticle(articleId);
        UserVO userVO = userClient.getUserInfo(article.getUserId()).getData();
        ArticleVO articleVO = ArticleVO.builder()
                .article(article)
                .userId(userVO.getId())
                .name(userVO.getName())
                .avatar(userVO.getAvatar())
                .build();
        return R.data(articleVO);
    }
}
