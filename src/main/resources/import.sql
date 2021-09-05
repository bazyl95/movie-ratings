DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS movie;
CREATE TABLE movie (id bigint AUTO_INCREMENT PRIMARY KEY, name varchar(50), director varchar (100), release_date timestamp);
CREATE TABLE review (id bigint AUTO_INCREMENT PRIMARY KEY, text varchar(255), mark integer, movie_id bigint, foreign key (movie_id) references movie(id));


INSERT INTO movie (name, director, release_date) VALUES ('Lords of the Rings', 'Peter Jackson', '2001-12-19');
INSERT INTO movie (name, director, release_date) VALUES ('Matrix', 'Lana Wachowski & Lilly Wachowski', '1999-03-31');
INSERT INTO movie (name, director, release_date) VALUES ('Avengers', 'Joss Wheadon', '2012-05-01');
INSERT INTO movie (name, director, release_date) VALUES ('ZS Justice League', 'Zack Snyder', '2021-03-18');
INSERT INTO movie (name, director, release_date) VALUES ('Bad Boys For life', 'Adil El Arbi & Bilall Fallah', '2020-01-17');
INSERT INTO movie (name, director, release_date) VALUES ('Doom', 'Andrzej Bartkowiak', '2005-10-21');

--INSERT INTO review (text, mark, movie_id) VALUES ('Cool movie', 10, (SELECT id FROM movie WHERE name = 'Lords of the Rings'));
--INSERT INTO review (text, mark, movie_id) VALUES ('Outstanding experience', 9, (SELECT id FROM movie WHERE name = 'Lords of the Rings'));
--INSERT INTO review (text, mark, movie_id) VALUES ('New Zealand is the best', 10, (SELECT id FROM movie WHERE name = 'Lords of the Rings'));