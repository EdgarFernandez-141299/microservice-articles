package net.edgar.microservicearticles.model.dto.article;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleDTO {

    private String articleId;

    private String name;

    private String description;

    private Double price;

    private String model;

}
