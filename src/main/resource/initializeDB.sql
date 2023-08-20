CREATE DATABASE shopping;
CREATE USER shopmanager WITH PASSWORD 'secret';




GRANT ALL PRIVILEGES ON DATABASE shopping TO shopmanager;
GRANT ALL ON SCHEMA public TO shopmanager;