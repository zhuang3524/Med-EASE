CREATE TABLE recommendations (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 request_id VARCHAR(255) NOT NULL,
                                 audio BLOB,
                                 status VARCHAR(255),
                                 recommendation_text TEXT
);