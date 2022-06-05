/*--1.Вывести список самолетов с кодами 320, 321, 733*/
SELECT *
FROM AIRCRAFTS_DATA ad 
WHERE AIRCRAFT_CODE IN ('320', '321', '733'); 
/*--2.Вывести список самолетов с кодом не на 3*/
SELECT *
FROM FLIGHTS f 
WHERE AIRCRAFT_CODE NOT LIKE '3%';
/*--3.Найти билеты оформленные на имя «OLGA», с емайлом «OLGA» или без емайла*/
SELECT *
FROM TICKETS
WHERE  (upper(EMAIL) LIKE '%OLGA%' AND UPPER(PASSENGER_NAME) LIKE '%OLGA%') OR (upper(EMAIL) IS NULL AND UPPER(PASSENGER_NAME)LIKE '%OLGA%');
/*--4.Найти самолеты с дальностью полета 5600, 5700. Отсортировать список по убыванию дальности полета;*/
SELECT *
FROM AIRCRAFTS_DATA
WHERE "RANGE" IN ('5600', '5700')
ORDER BY "RANGE" DESC ;
/*--5.Найти аэропорты в Moscow. Вывести название аэропорта вместе с городом. Отсортировать по полученному названию;*/
SELECT AIRPORT_NAME, CITY
FROM AIRPORTS_DATA
WHERE CITY = 'Moscow'
ORDER BY AIRPORT_NAME ASC ;
/*--6.Вывести список всех городов без повторов в зоне «Europe»;*/
SELECT DISTINCT CITY
FROM AIRPORTS_DATA
WHERE TIMEZONE LIKE '%Europe%';
/*--7.Найти бронирование с кодом на «3A4» и вывести сумму брони со скидкой 10%*/
SELECT SUM(TOTAL_AMOUNT * 0.9) 
FROM BOOKINGS 
WHERE BOOK_REF LIKE '3A4%';
/*--8.Вывести все данные по местам в самолете с кодом 320 и классом «Business»в формате «Данные по месту: номер места»*/
SELECT AIRCRAFT_CODE || FARE_CONDITIONS ||s.SEAT_NO 
FROM SEATS s 
WHERE AIRCRAFT_CODE = '320' AND FARE_CONDITIONS = 'Business' ;
/*--9. Найти максимальную и минимальную сумму бронирования в 2017 году;*/
SELECT MAX(TOTAL_AMOUNT) AS max, MIN(TOTAL_AMOUNT) AS min
FROM BOOKINGS
WHERE TRUNC(BOOK_DATE, 'year') = to_date('01-01-2017','dd.mm.yyyy');
/*--10.Найти количество мест во всех самолетах нужна инфа в виде самолет, кол-во мест, то есть группировка по самолетам;*/
SELECT MODEL, COUNT(seat_no) AS cnt
FROM AIRCRAFTS_DATA ad JOIN SEATS s ON ad.AIRCRAFT_CODE =s.AIRCRAFT_CODE
GROUP BY MODEL ;
/*-- 11.Найти количество мест во всех самолетах с учетом типа места;*/
SELECT MODEL,FARE_CONDITIONS , COUNT(*) AS CNT
FROM AIRCRAFTS_DATA ad JOIN SEATS s ON ad.AIRCRAFT_CODE =s.AIRCRAFT_CODE 
GROUP BY MODEL,FARE_CONDITIONS
ORDER BY 1;
/*-- 12.Найти количество билетов пассажира ALEKSANDR STEPANOV, телефон которого заканчивается на 11;*/
SELECT COUNT(TICKET_NO) AS cnt
FROM TICKETS  
WHERE PASSENGER_NAME LIKE 'ALEKSANDR STEPANOV' AND PHONE LIKE '%11';
/*-- 13.Вывести всех пассажиров с именем ALEKSANDR, у которых количество билетов больше 2000. Отсортировать по убыванию количества билетов;*/
SELECT PASSENGER_NAME, count(*) AS cnt
FROM TICKETS WHERE PASSENGER_NAME LIKE 'ALEKSANDR %' 
GROUP BY PASSENGER_NAME
HAVING count(*) > 2000
ORDER BY cnt DESC ;
/*--14.Вывести дни в сентябре 2017 с количеством рейсов больше 500.*/
SELECT TRUNC(f.DATE_DEPARTURE) DATE_DEPARTURE 
, COUNT(*) cnt
FROM FLIGHTS f
WHERE TRUNC(f.date_departure, 'mm')=to_date('01.09.2017','dd.mm.yyyy')
GROUP BY TRUNC(f.date_departure)
HAVING COUNT(*)>500
ORDER BY 1;
/*--15.Вывести список городов, в которых несколько аэропортов*/
SELECT CITY FROM AIRPORTS_DATA ad2 GROUP BY CITY HAVING count (*)> 1;
/*--16.Вывести модель самолета и список мест в нем*/
SELECT  MODEL, SEAT_NO
FROM AIRCRAFTS_DATA ad JOIN SEATS s ON ad.AIRCRAFT_CODE =s.AIRCRAFT_CODE
ORDER BY MODEL, SEAT_NO;
/*--17.  Вывести информацию по всем рейсам из аэропортов в г.Москва за сентябрь 2017*/
SELECT * 
FROM FLIGHTS f JOIN AIRPORTS_DATA ad ON f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE 
WHERE CITY ='Moscow' AND TRUNC(f.date_departure, 'mm')=to_date('01.09.2017','dd.mm.yyyy') ;
/*--18.  Вывести кол-во рейсов по каждому аэропорту в г.Москва за 2017*/
SELECT AIRPORT_NAME, COUNT(*) AS cnt
FROM FLIGHTS f JOIN AIRPORTS_DATA ad ON f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE 
WHERE CITY ='Moscow' AND TRUNC(f.date_departure, 'yyyy')=to_date('01.01.2017','dd.mm.yyyy')
GROUP BY AIRPORT_NAME;
/*--19.  Вывести кол-во рейсов по каждому аэропорту, месяцу в г.Москва за 2017*/
SELECT AIRPORT_NAME,TO_CHAR(date_departure, 'MM') AS m, count(*) AS cnt
FROM FLIGHTS f  JOIN AIRPORTS_DATA ad ON f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE 
WHERE TRUNC(f.date_departure, 'MM')>=to_date('2017.01.01','yyyy.mm.dd.') AND TRUNC(f.date_departure, 'MM')<=to_date('2017.12.31','yyyy.mm.dd.') AND CITY ='Moscow' 
GROUP BY  TO_CHAR(date_departure, 'MM'),AIRPORT_NAME
ORDER BY 1,2;
/*--20. Найти все билеты по бронированию на «3A4B»*/
SELECT TICKET_NO , BOOK_REF
FROM TICKETS
WHERE BOOK_REF LIKE '3A4B%';
/*--21 Найти все перелеты по бронированию на «3A4B»*/
SELECT FLIGHT_ID
FROM TICKET_FLIGHTS tf JOIN 
TICKETS t ON tf.TICKET_NO = t.TICKET_NO 
WHERE BOOK_REF LIKE '3A4B%'; 

