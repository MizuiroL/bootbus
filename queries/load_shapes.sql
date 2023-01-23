LOAD DATA INFILE 'shapes.txt' INTO TABLE shapes
FIELDS TERMINATED BY ','
ENCLOSED BY '\"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(shape_id,shape_pt_lat,shape_pt_lon,shape_pt_sequence,shape_dist_traveled);