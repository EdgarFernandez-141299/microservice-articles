USE articles_db;

CREATE TABLE article (
    article_id VARCHAR(10) NOT NULL,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(200) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    model VARCHAR(10) NOT NULL,
    PRIMARY KEY (article_id)
);