CREATE TABLE event
(
    id          BIGSERIAL NOT NULL,
    player_id   BIGSERIAL,
    title       VARCHAR(255),
    description VARCHAR(255),
    date_time   TIMESTAMP WITHOUT TIME ZONE,
    court_id    BIGSERIAL,
    event_state SMALLINT,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_event PRIMARY KEY (id)
);

CREATE TABLE court
(
    id           BIGSERIAL NOT NULL,
    name         VARCHAR(255),
    direction    VARCHAR(255),
    latitude     VARCHAR(255),
    longitude    VARCHAR(255),
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_court PRIMARY KEY (id)
);

CREATE TABLE player
(
    id          BIGSERIAL NOT NULL,
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

ALTER TABLE event
    ADD CONSTRAINT FK_EVENT_ON_COURT FOREIGN KEY (court_id) REFERENCES court (id);

ALTER TABLE event
    ADD CONSTRAINT FK_EVENT_ON_PLAYER FOREIGN KEY (player_id) REFERENCES player (id);
