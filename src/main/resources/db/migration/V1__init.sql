CREATE TABLE IF NOT EXISTS film(
    id SERIAL,
    title VARCHAR(100),
    director VARCHAR(100),
    duration INT,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS scene(
    id SERIAL,
    description VARCHAR(100),
    budget DECIMAL(7,2),
    minutes INT,
    film_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES film(id)
    );

CREATE TABLE IF NOT EXISTS characters(
    id SERIAL,
    description VARCHAR(100),
    cost DECIMAL(7,2),
    scene_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (scene_id) REFERENCES scene(id)
    );
