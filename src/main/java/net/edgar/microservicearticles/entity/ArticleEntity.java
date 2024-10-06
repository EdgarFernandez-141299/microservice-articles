package net.edgar.microservicearticles.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "article")
public class ArticleEntity implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "article_id")
    private String articleId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Column(name = "price")
    private Double price;

    @Basic(optional = false)
    @Column(name = "model")
    private String model;


}
