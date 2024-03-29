CREATE TABLE PETROL_USER (
    ID INTEGER GENERATED ALWAYS AS IDENTITY,
    USER_NAME varchar2(20) NOT NULL,
    PASSWORD varchar(120) DEFAULT NULL,
    EMAIL varchar(50) NOT NULL,
    PRIMARY KEY (ID)
);

ALTER TABLE PETROL_USER
  ADD  CONSTRAINT UK_UserName UNIQUE (USER_NAME);

ALTER TABLE PETROL_USER
  ADD  CONSTRAINT UK_Email UNIQUE (EMAIL);

CREATE TABLE ROLE (
    ID INTEGER GENERATED ALWAYS AS IDENTITY,
    NAME varchar2(20) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE PETROL_USER_ROLE (
    ID INTEGER GENERATED ALWAYS AS IDENTITY,
    PETROL_USER_ID INTEGER NOT NULL,
    ROLE_ID INTEGER NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_USER
        FOREIGN KEY (PETROL_USER_ID)
        REFERENCES PETROL_USER(ID),
    CONSTRAINT FK_ROLE
        FOREIGN KEY (ROLE_ID)
        REFERENCES ROLE(ID)

);
