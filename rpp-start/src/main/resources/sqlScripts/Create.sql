DROP TABLE IF EXISTS Nacionalnost CASCADE;
DROP TABLE IF EXISTS Liga CASCADE;
DROP TABLE IF EXISTS Igrac CASCADE;
DROP TABLE IF EXISTS Tim CASCADE;

DROP SEQUENCE IF EXISTS Nacionalnost_seq;
DROP SEQUENCE IF EXISTS Igrac_seq;
DROP SEQUENCE IF EXISTS Tim_seq;
DROP SEQUENCE IF EXISTS Liga_seq;

CREATE Table Nacionalnost(
	id integer not null,
	naziv varchar(100),
	skracenica varchar(50)
);
CREATE Table Liga (
	id int not null,
	naziv varchar(100),
	oznaka varchar(100)
);
CReate Table Igrac(
id int not null,
	ime varchar(50),
	prezime varchar(50),
	broj_registracije varchar(50),
	datum_rodjenja date,
	nacionalnost int not null,
	tim int not null
);
CREATE Table Tim(
id int not null,
	naziv varchar(50),
	osnovan date,
	sediste varchar(100),
	liga int not null
);

ALTER TABLE Nacionalnost
ADD CONSTRAINT pk_Nacionalnost PRIMARY KEY(id);
ALTER TABLE Igrac
ADD CONSTRAINT pk_Igrac PRIMARY KEY(id);
ALTER TABLE Tim
ADD CONSTRAINT pk_Tim PRIMARY KEY(id);
ALTER TABLE Liga
ADD CONSTRAINT pk_Liga PRIMARY KEY(id);

ALTER TABLE Igrac
ADD CONSTRAINT fk_Igrac_nacionalnost FOREIGN KEY(nacionalnost)
REFERENCES Nacionalnost(id);

ALTER TABLE IGRAC
ADD CONSTRAINT fk_Igrac_tim FOREIGN KEY(tim)
REFERENCES Tim(id);

ALTER TABLE Tim 
ADD CONSTRAINT fk_Tim_liga FOREIGN KEY(liga)
REFERENCES Liga(id);

CREATE INDEX idx_pk_Nacionalnost on Nacionalnost(id);
CREATE INDEX idx_pk_Igrac on Igrac(id);
CREATE INDEX idx_Tim on Tim(id);
CREATE INDEX idx_Liga on Liga(id); 

CREATE INDEX idx_fk_Igrac_nacionalnost on Igrac(nacionalnost);
CREATE INDEX idx_fk_Igrac_tim on Igrac(tim);
CREATE INDEX idx_fk_Tim_liga on Tim(liga);

CREATE SEQUENCE IF NOT EXISTS Nacionalnost_seq INCREMENT 1 START 1; 
CREATE SEQUENCE IF NOT EXISTS Igrac_seq INCREMENT 1 START 1; 
CREATE SEQUENCE IF NOT EXISTS Tim_seq INCREMENT 1 START 1; 
CREATE SEQUENCE IF NOT EXISTS Liga_seq INCREMENT 1 START 1; 