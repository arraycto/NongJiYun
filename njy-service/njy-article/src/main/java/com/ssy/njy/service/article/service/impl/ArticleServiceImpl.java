package com.ssy.njy.service.article.service.impl;

import com.ssy.njy.api.article.entity.Article;
import com.ssy.njy.service.article.mapper.ArticleMapper;
import com.ssy.njy.service.article.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: mqxu
 * @date: 2021-07-26
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Article getArticle(Long articleId) {
        return articleMapper.selectById(articleId);
    }
}
