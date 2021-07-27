package com.ssy.njy.api.article.vo;

import com.ssy.njy.api.article.entity.Article;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ArticleVO
 *
 * @author: mqxu
 * @date: 2021-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ArticleVO对象", description = "ArticleVO对象")
public class ArticleVO {
    private Article article;

    private Long userId;

    private String avatar;

    private String name;

}
