CREATE TABLE task
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime NOT NULL,
    updated_at    datetime NULL,
    deleted       BIT(1)   NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    priority      SMALLINT NULL,
    status        SMALLINT NULL,
    due_date      datetime NULL,
    user_id       BIGINT NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

CREATE TABLE user
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_at   datetime NOT NULL,
    updated_at   datetime NULL,
    deleted      BIT(1)   NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    username     VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);