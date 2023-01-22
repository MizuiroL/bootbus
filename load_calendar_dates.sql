LOAD DATA INFILE 'calendar_dates.txt' INTO TABLE calendar_dates
FIELDS TERMINATED BY ','
ENCLOSED BY '\"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(service_id,date,exception_type);