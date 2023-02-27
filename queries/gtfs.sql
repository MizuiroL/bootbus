DROP TABLE IF EXISTS shapes;
DROP TABLE IF EXISTS stop_times;
DROP TABLE IF EXISTS trips;
DROP TABLE IF EXISTS calendar_dates;
DROP TABLE IF EXISTS calendar;
DROP TABLE IF EXISTS routes;
DROP TABLE IF EXISTS stops;
DROP TABLE IF EXISTS agency;

CREATE TABLE `agency` (
  agency_id VARCHAR(50) PRIMARY KEY,
  agency_name VARCHAR(255),
  agency_url VARCHAR(255),
  agency_timezone VARCHAR(50),
  agency_lang VARCHAR(10),
  agency_phone VARCHAR(50),
  agency_fare_url VARCHAR(50),
  agency_email VARCHAR(50)
);

CREATE TABLE `stops` (
  stop_id VARCHAR(50) PRIMARY KEY,
  stop_code VARCHAR(50),
  stop_name VARCHAR(255),
  tts_stop_name VARCHAR(255),
  stop_desc VARCHAR(500),
  stop_lat DOUBLE,
  stop_lon DOUBLE,
  zone_id VARCHAR(50),
  stop_url VARCHAR(255),
  location_type INT,
  parent_station VARCHAR(50),
  stop_timezone VARCHAR(50),
  wheelchair_boarding INT,
  level_id VARCHAR(50),
  platform_code VARCHAR(50)
  );

CREATE TABLE `routes` (
  route_id VARCHAR(50) PRIMARY KEY,
  agency_id VARCHAR(50),
  route_short_name VARCHAR(50),
  route_long_name VARCHAR(255),
  route_desc VARCHAR(500),
  route_type INT,
  route_url VARCHAR(255),
  route_color VARCHAR(7),
  route_text_color VARCHAR(7),
  route_sort_order INT UNSIGNED,
  continuous_pickup INT,
  continuous_drop_off INT,
  network_id VARCHAR(50),
FOREIGN KEY (agency_id) REFERENCES agency(agency_id)
);

CREATE TABLE `calendar` (
  service_id VARCHAR(50) PRIMARY KEY,
  monday TINYINT,
  tuesday TINYINT,
  wednesday TINYINT,
  thursday TINYINT,
  friday TINYINT,
  saturday TINYINT,
  sunday TINYINT,
  start_date VARCHAR(8),
  end_date VARCHAR(8)
);

CREATE TABLE `calendar_dates` (
  service_id VARCHAR(50),
  `date` VARCHAR(10),
  exception_type INT,
  PRIMARY KEY (service_id, `date`)
);

CREATE TABLE `trips` (
  route_id VARCHAR(50),
  service_id VARCHAR(50),
  trip_id VARCHAR(50) PRIMARY KEY,
  trip_headsign VARCHAR(255),
  trip_short_name VARCHAR(50),
  direction_id INT,
  block_id VARCHAR(50),
  shape_id VARCHAR(50),
  wheelchair_accessible INT,
  bikes_allowed INT,
  FOREIGN KEY (route_id) REFERENCES routes(route_id),
  FOREIGN KEY (service_id) REFERENCES calendar_dates(service_id)
);

CREATE TABLE `stop_times` (
  trip_id VARCHAR(50),
  arrival_time VARCHAR(8),
  departure_time VARCHAR(8),
  stop_id VARCHAR(50),
  stop_sequence INT UNSIGNED,
  stop_headsign VARCHAR(50),
  pickup_type INT,
  drop_off_type INT,
  continuous_pickup INT,
  continuous_drop_off INT,
  shape_dist_traveled DOUBLE,
  timepoint INT,
  PRIMARY KEY (trip_id, stop_sequence),
  FOREIGN KEY (stop_id) REFERENCES stops(stop_id),
  FOREIGN KEY (trip_id) REFERENCES trips(trip_id)
);

CREATE TABLE `shapes` (
  shape_id VARCHAR(50),
  shape_pt_lat DOUBLE,
  shape_pt_lon DOUBLE,
  shape_pt_sequence INT,
  shape_dist_traveled INT,
  PRIMARY KEY (shape_id, shape_pt_sequence)
);
