LOAD DATA INFILE 'agency.txt' INTO TABLE agency
FIELDS TERMINATED BY ','
ENCLOSED BY '\"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(agency_id,agency_name,agency_url,agency_timezone,agency_lang,agency_phone);
