DROP TABLE IF EXISTS property;


CREATE TABLE property
(
  id character varying(64) NOT NULL,
  string character varying(512) NOT NULL,
  CONSTRAINT property_ok PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE property
  OWNER TO thjug;

INSERT INTO property(id, string) VALUES ('VERSION', '1.0.0');




DROP TABLE IF EXISTS ACCOUNTROLE;
DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS ROLES;

CREATE TABLE ACCOUNT
(
  ID            serial,
  TYPE          character(1) NOT NULL,
  ENABLE        character(1) NOT NULL,
  USERNAME      character varying(64) NOT NULL,
  PASSWD        character varying(64) NOT NULL,
  EMAIL	        character varying(128) NOT NULL,
  FIRSTNAME     character varying(64),
  LASTNAME      character varying(64),
  TWITTER       character varying(32),
  BIO           character varying(128),
  AVATARPATH    character varying(256),

  CREATED       timestamp with time zone,
  UPDATED       timestamp with time zone,
  UPDATEBY      integer,

  CONSTRAINT ACCOUNT_PK PRIMARY KEY (ID),
  CONSTRAINT ACCOUNT_UNI0 UNIQUE (USERNAME),
  CONSTRAINT ACCOUNT_UNI1 UNIQUE (EMAIL)
)
WITH (
  OIDS = FALSE
) TABLESPACE pg_default;
ALTER TABLE ACCOUNT     OWNER TO thjug;

CREATE TABLE ROLES
(
  ID            serial,
  ROLENAME      character varying(64) NOT NULL,
  DESCRIPTION   character varying(512),

  CREATED       timestamp with time zone,
  UPDATED       timestamp with time zone,
  UPDATEBY      integer,

  CONSTRAINT ROLE_PK PRIMARY KEY (ID),
  CONSTRAINT ROLE_UNI0 UNIQUE (ROLENAME)
)
WITH (
  OIDS = FALSE
) TABLESPACE pg_default;
ALTER TABLE ROLE     OWNER TO thjug;


CREATE TABLE ACCOUNTROLE
(
  ID            serial,
  ACCOUNTID     integer NOT NULL,
  ROLEID        integer NOT NULL,

  CREATED       timestamp with time zone,
  UPDATED       timestamp with time zone,
  UPDATEBY      integer,

  CONSTRAINT accountrole_pk PRIMARY KEY (id),
  CONSTRAINT accountrole_fk1 FOREIGN KEY (accountid)
      REFERENCES account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT accountrole_fk2 FOREIGN KEY (roleid)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT accountrole_uni0 UNIQUE (accountid, roleid)
)
WITH (
  OIDS = FALSE
) TABLESPACE pg_default;
ALTER TABLE ACCOUNTROLE     OWNER TO thjug;
