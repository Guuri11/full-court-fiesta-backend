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

