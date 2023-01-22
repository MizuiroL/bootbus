LOAD DATA INFILE 'stops.txt' INTO TABLE stops
FIELDS TERMINATED BY ','
ENCLOSED BY '\"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(stop_id,stop_name,stop_lat,stop_lon,stop_code);
