CREATE TABLE product
		(id        SERIAL PRIMARY KEY NOT NULL, --auto-generated integer key
		 name   VARCHAR(50)        NOT NULL, --variable-length text, 50 chars at most
         category  VARCHAR(50)        NOT NULL,
		 price     REAL);