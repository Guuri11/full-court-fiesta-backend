CREATE TABLE player
(
    id           BIGSERIAL NOT NULL,
    email      VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL,
    full_name  VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_player PRIMARY KEY (id)
);

CREATE TABLE message
(
    id           BIGSERIAL NOT NULL,
    sender_id  BIGSERIAL,
    receiver_id  BIGSERIAL,
    content    VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_message PRIMARY KEY (id)
);
ALTER TABLE player
    ADD CONSTRAINT uc_player_email UNIQUE (email);

ALTER TABLE player
    ADD CONSTRAINT uc_player_username UNIQUE (username);

ALTER TABLE message
    ADD CONSTRAINT FK_MESSAGE_ON_SENDER FOREIGN KEY (sender_id) REFERENCES player (id);

ALTER TABLE message
    ADD CONSTRAINT FK_MESSAGE_ON_RECEIVER FOREIGN KEY (receiver_id) REFERENCES player (id);
