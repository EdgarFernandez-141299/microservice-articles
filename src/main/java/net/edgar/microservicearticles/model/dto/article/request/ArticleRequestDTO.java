package net.edgar.microservicearticles.model.dto.article.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleRequestDTO {

    @NotEmpty(message = "description es requerido")
    private String description;

    @NotEmpty(message = "model es requerido")
    private String model;

}
