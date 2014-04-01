DROP TABLE property;

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
