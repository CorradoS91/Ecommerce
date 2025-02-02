CREATE TABLE IF NOT EXISTS USER_ECOMMERCE (
    USER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    EMAIL VARCHAR(255) NOT NULL UNIQUE,
    PHONE VARCHAR(50) NOT NULL UNIQUE,
    BALANCE DECIMAL NOT NULL,
    ROLE VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS PRODUCT_ECOMMERCE (
    ASIN BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    PRICE DOUBLE NOT NULL,
    QUANTITY INT NOT NULL,
    IMAGEURL VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ECOMMERCE_ORDER (
    ECOMMERCE_ORDER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    ORDER_TOTAL DECIMAL(15,2) NOT NULL,
    ORDER_STATUS VARCHAR(50) NOT NULL,
    ORDER_PAYMENT VARCHAR(50) NOT NULL,
    DONE_AT DATE,
    RECEIVED_AT DATE,
    USER_ID BIGINT NOT NULL,
    CONSTRAINT FK_USER_ORDER FOREIGN KEY (USER_ID) REFERENCES USER_ECOMMERCE(USER_ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ORDER_PRODUCT (
    ECOMMERCE_ORDER_ID BIGINT NOT NULL,
    ASIN BIGINT NOT NULL,
    PRIMARY KEY (ECOMMERCE_ORDER_ID, ASIN),
    CONSTRAINT FK_ORDER FOREIGN KEY (ECOMMERCE_ORDER_ID) REFERENCES ECOMMERCE_ORDER(ECOMMERCE_ORDER_ID) ON DELETE CASCADE,
    CONSTRAINT FK_PRODUCT FOREIGN KEY (ASIN) REFERENCES PRODUCT_ECOMMERCE(ASIN) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS FAVORITE_PRODUCT (
    FAVORITE_PRODUCT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID BIGINT NOT NULL,
    ASIN BIGINT NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES USER_ECOMMERCE(USER_ID),
    FOREIGN KEY (ASIN) REFERENCES PRODUCT_ECOMMERCE(ASIN)
);

CREATE TABLE IF NOT EXISTS ADDRESS (
    ADDRESS_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    STREET VARCHAR(255),
    CITY VARCHAR(255),
    POSTAL_CODE VARCHAR(20),
    COUNTRY VARCHAR(100),
    IS_DEFAULT VARCHAR(5),
    USER_ID BIGINT NOT NULL,
    ORDER_ID BIGINT,
    FOREIGN KEY (USER_ID) REFERENCES USER_ECOMMERCE(USER_ID) ON DELETE CASCADE,
    FOREIGN KEY (ORDER_ID) REFERENCES ECOMMERCE_ORDER(ECOMMERCE_ORDER_ID) ON DELETE CASCADE
);

