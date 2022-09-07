INSERT into Nacionalnost
values
(nextval('Nacionalnost_seq'),'Srpska', 'SRB'),
(nextval('Nacionalnost_seq'),'Ruska', 'RUS'),
(nextval('Nacionalnost_seq'),'Italijanska', 'ITL'),
(nextval('Nacionalnost_seq'),'Å panska', 'ESP'),
(nextval('Nacionalnost_seq'),'GrÄ�ka', 'HEL');

INSERT into Liga
values
(nextval('Liga_seq'),'Superliga Srbije', 'SLS'),
(nextval('Liga_seq'),'Prva liga Srbije', 'PLS'),
(nextval('Liga_seq'),'La Liga', 'LLG'),
(nextval('Liga_seq'),'La Liga 2', 'LLG2'),
(nextval('Liga_seq'),'Serie A', 'SA'),
(nextval('Liga_seq'),'Serie B', 'SB'),
(nextval('Liga_seq'),'Russian Premier League', 'RPL'),
(nextval('Liga_seq'),'Russian Football National League', 'RFNL'),
(nextval('Liga_seq'),'Super League Greece', 'SLG'),
(nextval('Liga_seq'),'Super League Greece 2', 'SLG2');

INSERT into tim
values (nextval('tim_seq'), 'Crvena Zvezda', '1890-01-02', 'Bulevar Oslobodjenja 1', 1),
(nextval('tim_seq'), 'Partizan', '1907-02-03', 'Bulevar Patrijarha Pavla 1', 1),
(nextval('tim_seq'), 'Kabel', '1990-03-04', 'Fruskogorska 14', 2),
(nextval('tim_seq'), 'Zvezda', '1980-04-05', 'Branka Ilica 16', 2),
(nextval('tim_seq'), 'Barselona', '1880-05-06', 'Trg Mladenaca 12', 3),
(nextval('tim_seq'), 'Real Madrid', '1888-07-08', 'Zmaj Jovina 16', 3),
(nextval('tim_seq'), 'Almerija', '1980-06-07', 'Save Mrkalja 1', 4),
(nextval('tim_seq'), 'Ibiza', '1980-08-09', 'Branka Ilica 16', 4),
(nextval('tim_seq'), 'Juventus', '1780-09-10', 'Romula i Rema 2', 5),
(nextval('tim_seq'), 'Roma', '1680-10-11', 'Majke Majkla Dzeksona 3', 5),
(nextval('tim_seq'), 'Monca', '1897-11-12', 'Krivog tornja 4', 6),
(nextval('tim_seq'), 'Parma', '1777-12-13', 'Njegoseva 113', 6),
(nextval('tim_seq'), 'Zenit', '1778-01-22', 'Gogoljeva 12', 7),
(nextval('tim_seq'), 'Spartak Moskva', '1878-02-11', 'Kralja Petra Prvog 12', 7),
(nextval('tim_seq'), 'Rotor', '1920-03-17', 'Mongolskih ratnika 2', 8),
(nextval('tim_seq'), 'Torpedo', '1921-04-15', 'Ahilove pete 3', 8),
(nextval('tim_seq'), 'AEK', '1780-05-17', 'Ribareva 6', 9),
(nextval('tim_seq'), 'Olimpijakos', '1970-06-18', 'Brkatog Cike 12', 9),
(nextval('tim_seq'), 'Diagoras', '1780-09-19', 'Perikleova 2', 10),
(nextval('tim_seq'), 'Karditsa', '1980-02-22', 'Kirilova 17', 10);

INSERT into igrac(id, ime, prezime, broj_registracije, datum_rodjenja, nacionalnost, tim)
values 
(nextval('igrac_seq'), 'Bosko','Vujanovic','1111111111','2001-02-13',1,1),
(nextval('igrac_seq'), 'Milos','Vujanovic','2222222222','1972-06-22',1,2),
(nextval('igrac_seq'), 'Borislav','Tosic','3333333333','2000-05-19',2,3),
(nextval('igrac_seq'), 'Alan','Bojovic','4444444444','2000-08-05',2,4),
(nextval('igrac_seq'), 'Stevan','Milicic','5555555555','2000-08-25',3,5),
(nextval('igrac_seq'), 'Gligorije','Josimov','6666666666','2000-05-25',3,6),
(nextval('igrac_seq'), 'David','Joksimovic','7777777777','2000-07-22',4,7),
(nextval('igrac_seq'), 'Borko','Zaharic','8888888888','2000-08-08',4,8),
(nextval('igrac_seq'), 'Mirko','Mirkovic','1010101010','1999-08-09',1,9),
(nextval('igrac_seq'), 'Marko','Markovic','1111111111','1989-10-10',1,10),
(nextval('igrac_seq'), 'Petar','Petrovic','1212121212','1998-10-15',2,11),
(nextval('igrac_seq'), 'Aleksa','Aleksic','1313131313','1978-11-18',2,12),
(nextval('igrac_seq'), 'Mitar','Mitrovic','1414141414','1988-07-07',3,13),
(nextval('igrac_seq'), 'Sergej','Jandric','1515151515','1977-02-03',3,14),
(nextval('igrac_seq'), 'Marko','Aleksic','1616161616','1966-10-22',4,15),
(nextval('igrac_seq'), 'Aksentije','Aksentijevic','1717171717','1977-04-04',4,16),
(nextval('igrac_seq'), 'Milutin','Milankovic','1818181818','1999-06-06',1,17),
(nextval('igrac_seq'), 'Nikola','Tesla','1919191919','1998-08-08',2,18),
(nextval('igrac_seq'), 'Aleksandar','Mitrovic','2020202020','1977-12-17',3,19),
(nextval('igrac_seq'), 'Aleksandar','Tirnanic','2121212121','1982-12-22',4,20);


