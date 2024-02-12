CREATE TABLE player
(
    id           BIGSERIAL NOT NULL,
    email      VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL,
    full_name  VARCHAR(255),
    password   VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_player PRIMARY KEY (id)
);

ALTER TABLE player
    ADD CONSTRAINT uc_player_email UNIQUE (email);

ALTER TABLE player
    ADD CONSTRAINT uc_player_username UNIQUE (username);