LOAD DATA INFILE 'stop_times.txt' INTO TABLE stop_times
FIELDS TERMINATED BY ','
ENCLOSED BY '\"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(trip_id,arrival_time,departure_time,stop_id,stop_sequence,shape_dist_traveled);