//수정전
CREATE TABLE files
(
    `file_id`    Long            NOT NULL    AUTO_INCREMENT,
    `file_type`  VARCHAR(45)    NULL,
    `file_name`  VARCHAR(45)    NULL,
    `file_date`  Localdate      NULL,
    `file_size`  byte           NULL,
    PRIMARY KEY (file_id)
);

//수정후
CREATE TABLE izzifile
(
    `id`    VARCHAR(45)    NOT NULL,
    `type`  VARCHAR(45)    NULL,
    `name`  VARCHAR(45)    NULL,
    `data`  byte           NULL,
    PRIMARY KEY (id)
);
