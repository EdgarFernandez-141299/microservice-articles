package net.edgar.microservicearticles.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.edgar.microservicearticles.entity.ArticleEntity;
import net.edgar.microservicearticles.exception.UpdateDatabaseException;
import net.edgar.microservicearticles.model.dto.article.ArticleDTO;
import net.edgar.microservicearticles.model.dto.article.request.ArticleRequestDTO;
import net.edgar.microservicearticles.repository.ArticleRepository;
import net.edgar.microservicearticles.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ArticleDTO searchArticle(String articleId) {

        log.info("Inicia servicio de busqueda de articulo...");

        ArticleEntity articleEntity = this.articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException(String.format("El articulo con id: %s no fue encontrado", articleId)));

        return new ArticleDTO(articleEntity.getArticleId(),
                articleEntity.getName(),
                articleEntity.getDescription(),
                articleEntity.getPrice(),
                articleEntity.getModel());
    }

    @Override
    @Transactional
    public ArticleDTO updateArticle(String articleId, ArticleRequestDTO articleRequestDTO) throws UpdateDatabaseException {

        log.info("Inicia servicio de actualización de articulo...");

        if (this.articleRepository.updateArticle(articleRequestDTO.getDescription(), articleRequestDTO.getModel(), articleId) == 0) {
            throw new UpdateDatabaseException(String.format("No fue posible actualizar el articulo con id: %s", articleId));
        }

        ArticleEntity articleEntity = this.articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException(String.format("El articulo con id: %s no fue encontrado", articleId)));

        return new ArticleDTO(articleEntity.getArticleId(),
                articleEntity.getName(),
                articleEntity.getDescription(),
                articleEntity.getPrice(),
                articleEntity.getModel());
    }

}
