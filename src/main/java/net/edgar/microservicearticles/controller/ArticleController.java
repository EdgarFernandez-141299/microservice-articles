package net.edgar.microservicearticles.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.edgar.microservicearticles.exception.UpdateDatabaseException;
import net.edgar.microservicearticles.model.dto.GlobalSuccessResponseDTO;
import net.edgar.microservicearticles.model.dto.article.request.ArticleRequestDTO;
import net.edgar.microservicearticles.service.ArticleService;
import net.edgar.microservicearticles.utility.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles-management")
@Validated
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/search")
    public ResponseEntity<GlobalSuccessResponseDTO<Object>> searchArticle(@RequestParam(value = "articleId") String articleId) {
        return ResponseEntity.ok(ResponseUtils.generateSuccessResponse(this.articleService.searchArticle(articleId)));
    }

    @PatchMapping("/update/{articleId}")
    public ResponseEntity<GlobalSuccessResponseDTO<Object>> updateArticle(@PathVariable(value = "articleId") String articleId,
                                                                         @Valid @RequestBody ArticleRequestDTO articleRequestDTO) throws UpdateDatabaseException {
        return ResponseEntity.ok(ResponseUtils.generateSuccessResponse(this.articleService.updateArticle(articleId, articleRequestDTO)));
    }


}
