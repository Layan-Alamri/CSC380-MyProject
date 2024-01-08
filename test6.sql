CREATE DATABASE CINEMA;
use CINEMA;

CREATE TABLE MOVIE (
Title VARCHAR(30)  NOT NULL, 
MovieLanguage  VARCHAR(10),
SuitableFor  VARCHAR(2)  NOT NULL,

PRIMARY KEY(Title)  
);

CREATE TABLE CUSTOMER (
Phone CHAR(10)  NOT NULL,
Name VARCHAR(15) NOT NULL,
DoB DATE NOT NULL,

PRIMARY KEY(Phone)    
);

CREATE TABLE TICKET (
SN  INT  NOT NULL,
CHN  INT NOT NULL,
Time  CHAR(5) NOT NULL,
Seatnum INT NOT NULL,
Customerphone CHAR(10) NOT NULL,
Movietitle  VARCHAR(15)  NOT NULL,

PRIMARY KEY(SN),
FOREIGN KEY(Movietitle) REFERENCES MOVIE(Title),
FOREIGN KEY(Customerphone) REFERENCES CUSTOMER(Phone)   
);

CREATE TABLE CINEMAHALL (
Number INT  NOT NULL,
Seats VARCHAR(10) NOT NULL,
NumOfSeats INT NOT NULL,

PRIMARY KEY(Number)   
);

CREATE TABLE DISPLAYED_IN (
Titledisplayed  VARCHAR(15)  NOT NULL,
HallNum  INT  NOT NULL, 

PRIMARY KEY(Titledisplayed,HallNum),
FOREIGN KEY(Titledisplayed) REFERENCES MOVIE(Title),
FOREIGN KEY(HallNum) REFERENCES CINEMAHALL(Number)
);


CREATE VIEW worker_view AS
SELECT
    T.SN,
    T.CHN,
    T.Time,
    T.Seatnum,
    T.Customerphone,
    T.Movietitle,
    M.Title, -- Add a comma here
    M.MovieLanguage,
    M.SuitableFor,
    C.Phone,
    C.Name,
    C.DoB,
    D.Titledisplayed,
    D.Hallnum,
    H.Number,
    H.Seats,
    H.NumOfSeats
FROM
    TICKET AS T
JOIN
    MOVIE AS M ON T.Movietitle = M.Title
JOIN
    DISPLAYED_IN AS D ON M.Title = D.Titledisplayed
JOIN
    CINEMAHALL AS H ON D.Hallnum = H.Number
JOIN
    CUSTOMER AS C ON T.Customerphone = C.Phone;
    
    
CREATE VIEW Moviedisplayer_view 
AS SELECT 
M.Title, 
M.MovieLanguage, 
M.SuitableFor, 
D.Titledisplayed, 
D.Hallnum, 
CH.Number
FROM MOVIE AS M, DISPLAYED_IN AS D, CINEMAHALL AS CH
WHERE M.Title = D.Titledisplayed AND D.Hallnum = CH.Number;
