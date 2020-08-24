//수정전
CREATE TABLE order
(
    `order_id`        Long            NOT NULL    AUTO_INCREMENT,
    `order_date`      Localdate      NULL,
    `moving_to`       VARCHAR(45)    NULL,
    `moving_type`     VARCHAR(45)    NULL,
    `moving_price`    VARCHAR(45)    NULL,
    `payment_status`  VARCHAR(45)    NULL,
    `payment_method`  VARCHAR(45)    NULL,
    `square`          VARCHAR(45)    NULL,
    `moving_date`     Localdate     NULL,
    `moving_from`     VARCHAR(45)    NULL,
    `payment_date`    Localdate      NULL,
    PRIMARY KEY (order_id)
);


//수정후
CREATE TABLE order
(
    `order_id`            Long            NOT NULL    AUTO_INCREMENT,
    `order_date`          Localdate      NULL,
    `moving_to`           VARCHAR(45)    NULL,
    `moving_type`         VARCHAR(45)    NULL,
    `moving_price`        VARCHAR(45)    NULL,
    `payment_status`      VARCHAR(45)    NULL,
    `payment_method`      VARCHAR(45)    NULL,
    `square`              VARCHAR(45)    NULL,
    `moving_date`         Localdate      NULL,
    `moving_from`         VARCHAR(45)    NULL,
    `payment_date`        Localdate      NULL,
    `optional_addr_to`    VARCHAR(45)    NULL,
    `optional_addr_from`  VARCHAR(45)    NULL,
    PRIMARY KEY (order_id)
);