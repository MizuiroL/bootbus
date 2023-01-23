LOAD DATA INFILE 'routes.txt' INTO TABLE routes
FIELDS TERMINATED BY ','
ENCLOSED BY '\"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(route_id,agency_id,route_short_name,route_long_name,route_type,route_color,route_text_color);