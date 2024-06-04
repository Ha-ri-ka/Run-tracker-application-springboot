CREATE TABLE IF NOT EXISTS Run(
    Id INT NOT NULL PRIMARY KEY,
    title varchar(250) NOT NULL,
    started timestamp NOT NULL,
    ended timestamp NOT NULL,
    distance INT NOT NULL,
    location varchar(10) NOT NULL
);