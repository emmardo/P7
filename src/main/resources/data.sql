
DROP TABLE IF EXISTS BidList;

CREATE TABLE BidList (
  bidListId tinyint(4) NOT NULL AUTO_INCREMENT,
  account VARCHAR(30) NOT NULL,
  type VARCHAR(30) NOT NULL,
  bidQuantity DOUBLE,
  askQuantity DOUBLE,
  bid DOUBLE ,
  ask DOUBLE,
  benchmark VARCHAR(125),
  bidListDate TIMESTAMP,
  commentary VARCHAR(125),
  security VARCHAR(125),
  status VARCHAR(10),
  trader VARCHAR(125),
  book VARCHAR(125),
  creationName VARCHAR(125),
  creationDate TIMESTAMP ,
  revisionName VARCHAR(125),
  revisionDate TIMESTAMP ,
  dealName VARCHAR(125),
  dealType VARCHAR(125),
  sourceListId VARCHAR(125),
  side VARCHAR(125),

  PRIMARY KEY (bidListId)
);

DROP TABLE IF EXISTS Trade;

CREATE TABLE Trade (
  tradeId tinyint(4) NOT NULL AUTO_INCREMENT,
  account VARCHAR(30) NOT NULL,
  type VARCHAR(30) NOT NULL,
  buyQuantity DOUBLE,
  sellQuantity DOUBLE,
  buyPrice DOUBLE ,
  sellPrice DOUBLE,
  tradeDate TIMESTAMP,
  security VARCHAR(125),
  status VARCHAR(10),
  trader VARCHAR(125),
  benchmark VARCHAR(125),
  book VARCHAR(125),
  creationName VARCHAR(125),
  creationDate TIMESTAMP ,
  revisionName VARCHAR(125),
  revisionDate TIMESTAMP ,
  dealName VARCHAR(125),
  dealType VARCHAR(125),
  sourceListId VARCHAR(125),
  side VARCHAR(125),

  PRIMARY KEY (tradeId)
);

DROP TABLE IF EXISTS CurvePoint;

CREATE TABLE CurvePoint (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  asOfDate TIMESTAMP,
  term DOUBLE ,
  value DOUBLE ,
  creationDate TIMESTAMP ,

  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Rating;

CREATE TABLE Rating (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  moodysRating VARCHAR(125),
  sandPRating VARCHAR(125),
  fitchRating VARCHAR(125),
  orderNumber tinyint,

  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS RuleName;

CREATE TABLE RuleName (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  name VARCHAR(125),
  description VARCHAR(125),
  json VARCHAR(125),
  template VARCHAR(512),
  sqlStr VARCHAR(125),
  sqlPart VARCHAR(125),

  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  username VARCHAR(125),
  password VARCHAR(125),
  fullname VARCHAR(125),
  role VARCHAR(125),

  PRIMARY KEY (id)
);

insert into Users(fullname, username, password, role) values('Administrator', 'admin', '$2y$12$/dT3sa0kEuQ4VQl1SLl23u2P9AhF5BOW8VVbEy7ElMKDU8aWMmHzy', 'ADMIN');
insert into Users(fullname, username, password, role) values('User', 'user', '$2y$12$RVDjOGMDP28PIVaETXxnduddMqA1sRfNGcWKqtBD5QbnhNLNm.EU2', 'USER');