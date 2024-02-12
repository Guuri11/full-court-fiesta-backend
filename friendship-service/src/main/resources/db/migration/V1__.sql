CREATE TABLE friendship
(
    id           BIGSERIAL NOT NULL,
    player_id   UUID,
    follower_id UUID,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_friendship PRIMARY KEY (id)
);

CREATE TABLE player
(
    id          UUID NOT NULL,
    email      VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL,
    full_name  VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_player PRIMARY KEY (id)
);

ALTER TABLE player
    ADD CONSTRAINT uc_player_email UNIQUE (email);

ALTER TABLE player
    ADD CONSTRAINT uc_player_username UNIQUE (username);

ALTER TABLE friendship
    ADD CONSTRAINT FK_FRIENDSHIP_ON_FOLLOWER FOREIGN KEY (follower_id) REFERENCES player (id);

ALTER TABLE friendship
    ADD CONSTRAINT FK_FRIENDSHIP_ON_PLAYER FOREIGN KEY (player_id) REFERENCES player (id);
