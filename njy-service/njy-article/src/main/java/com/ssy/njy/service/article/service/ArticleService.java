package com.ssy.njy.service.article.service;

import com.ssy.njy.api.article.entity.Article;

/**
 * ArticleService
 *
 * @author: mqxu
 * @since: 2021-07-26
 **/
public interface ArticleService {

    /**
     * 根据id查找Article
     *
     * @param articleId 文章id
     * @return Article
     */
    Article getArticle(Long articleId);
}
