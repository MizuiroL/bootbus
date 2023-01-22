LOAD DATA INFILE 'trips.txt' INTO TABLE trips
FIELDS TERMINATED BY ','
ENCLOSED BY '\"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(route_id,service_id,trip_id,trip_headsign,trip_short_name,direction_id,shape_id);
