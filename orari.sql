SELECT *
FROM stop_times AS partenza, stop_times AS arrivo, trips AS t, calendar_dates AS cd
WHERE partenza.stop_id='RUF020_600'
AND arrivo.stop_id='PEG077_600'
AND partenza.trip_id=arrivo.trip_id
AND partenza.trip_id=t.trip_id
AND t.service_id=cd.service_id
AND cd.`date`=CURDATE()
ORDER BY partenza.departure_time;