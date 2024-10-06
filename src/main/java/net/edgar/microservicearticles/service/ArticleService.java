package net.edgar.microservicearticles.service;

import net.edgar.microservicearticles.exception.UpdateDatabaseException;
import net.edgar.microservicearticles.model.dto.article.ArticleDTO;
import net.edgar.microservicearticles.model.dto.article.request.ArticleRequestDTO;

public interface ArticleService {

    ArticleDTO searchArticle(String articleId);

    ArticleDTO updateArticle(String articleId, ArticleRequestDTO articleRequestDTO) throws UpdateDatabaseException;

}
