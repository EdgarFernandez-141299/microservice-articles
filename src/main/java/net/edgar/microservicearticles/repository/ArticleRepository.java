package net.edgar.microservicearticles.repository;

import net.edgar.microservicearticles.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {

    @Modifying
    @Query("UPDATE ArticleEntity ae "
            + "SET ae.description = :#{#description}, "
            + "ae.model = :#{#model} "
            + "WHERE ae.articleId = :#{#articleId}")
    int updateArticle(@Param("description") String description, @Param("model") String model, @Param("articleId") String articleId);


}
