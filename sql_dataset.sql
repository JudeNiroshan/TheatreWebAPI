

INSERT INTO movie_api.movie (name,director,ratings,released_year) VALUES 
('The Mummy', 'John Carter', '3/5', 2007),
('Wonder Woman', 'Russel Fernando', '4/5', 2017),
('The Lovers','Nimal Perera', '1/5', 2012),
('The Boss Baby','Chathua Senarathna', '1/5', 2017),
('Pirates if the Caribbean','Shawn Mendis', '5/5', 2011),
('Past Life','Darrel Samuael', '4/5', 2010),
('Be Afraid','Darius Ferdo', '3/5', 2012),
('Beauty And The Beast','Annie Jones', '4/5', 2009),
('All Nighter','Nowman Andersson', '2/5', 2017);

INSERT INTO movie_api.theater (name,location,no_of_seats) VALUES 
('Majestic City Cinema','Colombo-04',65),
('Liberty Cinema','Colombo-03',50),
('Savoy 3D Cinema','Colombo',45),
('Empire Cinema','Bauddhaloka Mawatha',76),
('Arena','Kandy',69);

INSERT INTO movie_api.showtime (show_time,movie_id,theater_id) VALUES 
('07:00:00',1,1),
('16:00:00',2,1),
('21:00:00',1,1),
('07:00:00',2,2),
('16:00:00',2,2),
('21:00:00',2,2);

INSERT INTO movie_api.movie_theater (theater_id,movie_id) VALUES 
(1,1),
(1,2),
(1,3),
(2,4),
(2,5);


INSERT INTO movie_api.seat (availability,seat_no,theater_id, price) VALUES 
(1,1,1, 250),
(1,2,1, 150),
(1,3,1, 155),
(1,4,1, 450),
(1,5,1, 420),
(1,1,2, 320),
(1,2,2, 320),
(1,3,2, 300),
(1,4,2, 100),
(1,5,2, 455);

INSERT INTO movie_api.booking(movie_id,seat_id,showtime_id,theater_id) VALUES 
(1,1,1,1),
(1,2,1,1),
(1,3,1,1),
(2,4,1,1),
(2,5,1,1),
(2,6,1,1);



