CREATE TABLE IF NOT EXISTS car_models (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    model_name VARCHAR(255) NOT NULL,
    brand_id BIGINT,
    CONSTRAINT FK_brand FOREIGN KEY (brand_id) REFERENCES car_brands(id)
);

