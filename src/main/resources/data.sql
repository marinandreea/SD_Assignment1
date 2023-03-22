insert into user(id_user,password, roles, username) values (1,'YW5hMTEyMjM=','CASHIER','Mike');
insert into user(id_user,password, roles, username) values (2,'$2a$10$lucSaiBkAtS5WyiuD.DRNOWduUo3yjPQAKWGHaTkKLr9qA0NnqPeq','CASHIER','cashier');
insert into user(id_user,password, roles, username) values (3,'$2a$10$1/NJlHalAR3uTDI3I2KDkOn4HzPIQuw36DqZ9kfHhaoQxYE8CBxDm','ADMIN','admin1');

insert into band(id_band,genre, name) values (1,'pop','band1');
insert into band(id_band,genre, name) values (2,'techno','band2');
insert into band(id_band,genre, name) values (3,'rap','band3');

insert into concert(id_concert,date, name, nr_tickets, time) values (1,'11 Martie', 'Concert1', 1000, '1pm');
insert into concert(id_concert,date, name, nr_tickets, time) values (2,'23 Aprilie', 'Concert2', 300, '7pm');
insert into concert(id_concert,date, name, nr_tickets, time) values (3,'26 iunie', 'Concert3', 550, '1pm');

insert into concert_bands(id,band_id, concert_id) values (1,1,1);
insert into concert_bands(id,band_id, concert_id) values (2,2,2);
insert into concert_bands(id,band_id, concert_id) values (3,3,3);

insert into ticket(id_ticket,concert_id, name, places, price) values (1,1,'Andreea Marin', 5, 150);
insert into ticket(id_ticket,concert_id, name, places, price) values (2,1,'Razvan Marin', 10, 600);
insert into ticket(id_ticket,concert_id, name, places, price) values (3,1,'Tessa Young', 15, 1000);
insert into ticket(id_ticket,concert_id, name, places, price) values (4,2,'Ion Popescu', 2, 500);
insert into ticket(id_ticket,concert_id, name, places, price) values (5,3,'Bianca Mijea', 3, 457);
