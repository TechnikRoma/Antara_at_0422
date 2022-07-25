/*Задание: 1 (Serge I: 2002-09-30)
Найдите номер модели, скорость и размер жесткого диска для всех ПК стоимостью менее 500 дол. Вывести: model, speed и hd*/

Select model, speed, hd
from pc
where price <500

/*Задание: 2 (Serge I: 2002-09-21)
Найдите производителей принтеров. Вывести: maker*/
Select maker
from product 
where type like 'printer'
group by maker;

/*Задание: 3 (Serge I: 2002-09-30)
Найдите номер модели, объем памяти и размеры экранов ПК-блокнотов, цена которых превышает 1000 дол.*/
Select model, ram, screen
from laptop
where price > 1000;

/*Задание: 4 (Serge I: 2002-09-21)
Найдите все записи таблицы Printer для цветных принтеров.*/
Select *
from printer
where color like 'y'

/*Задание: 5 (Serge I: 2002-09-30)
Найдите номер модели, скорость и размер жесткого диска ПК, имеющих 12x или 24x CD и цену менее 600 дол.*/
Select  model, speed, hd
from pc
where cd in ('12x','24x') and price <600;

/*Задание: 6 (Serge I: 2002-10-28)
Для каждого производителя, выпускающего ПК-блокноты c объёмом жесткого диска не менее 10 Гбайт, найти скорости таких ПК-блокнотов. Вывод: производитель, скорость.*/
Select distinct maker, speed
from laptop l join  product p on l.model = p.model
where hd >= 10

/*Задание: 7 (Serge I: 2002-11-02)
Найдите номера моделей и цены всех имеющихся в продаже продуктов (любого типа) производителя B (латинская буква).*/
Select distinct product.model, pc.price
from Product join pc ON product.model = pc.model where maker = 'B'
UNION
Select distinct product.model, laptop.price
from product join laptop ON product.model=laptop.model where maker='B'
UNION
Select distinct product.model, printer.price
from product join printer ON product.model=printer.model where maker='B';

/*Задание: 8 (Serge I: 2003-02-03)
Найдите производителя, выпускающего ПК, но не ПК-блокноты.*/
Select distinct maker
from product
where type = 'PC'
EXCEPT
Select distinct maker
from product
where type= 'Laptop'

/*Задание: 9 (Serge I: 2002-11-02)
Найдите производителей ПК с процессором не менее 450 Мгц. Вывести: Maker*/
Select DISTINCT maker
from product join pc ON product.model=pc.model
where pc.speed>=450;

/*Задание: 10 (Serge I: 2002-09-23)
Найдите модели принтеров, имеющих самую высокую цену. Вывести: model, price*/
Select model, price
from printer
where price =
(
Select MAX(price) from printer
);

/*Задание: 11 (Serge I: 2002-11-02)
Найдите среднюю скорость ПК.*/
Select AVG(speed)
from pc;

/*Задание: 12 (Serge I: 2002-11-02)
Найдите среднюю скорость ПК-блокнотов, цена которых превышает 1000 дол.*/
Select AVG(speed)
from laptop
where price>1000

/*Задание: 13 (Serge I: 2002-11-02)
Найдите среднюю скорость ПК, выпущенных производителем A.*/
Select AVG(speed)
from pc LEFT join product ON product.model=pc.model
where product.maker='A';

/*Задание: 14 (Serge I: 2002-11-05)
Найдите класс, имя и страну для кораблей из таблицы Ships, имеющих не менее 10 орудий.*/
Select c.class, name, country
from Classes c LEFT join ships s on c.class = s.class
where numguns>=10 AND name!='null'

/*Задание: 15 (Serge I: 2003-02-03)
Найдите размеры жестких дисков, совпадающих у двух и более PC. Вывести: HD*/
Select hd
from pc
group by hd
having count(hd)>1


/*Задание: 16 (Serge I: 2003-02-03)
Найдите пары моделей PC, имеющих одинаковые скорость и RAM. В результате каждая пара указывается только один раз, т.е. (i,j), но не (j,i), Порядок вывода: модель с большим номером, модель с меньшим номером, скорость и RAM.*/
Select distinct pc1.model, pc2.model, pc1.speed, pc1.ram
from pc AS pc1, pc AS pc2
where pc1.model>pc2.model AND pc1.speed=pc2.speed AND pc1.ram=pc2.ram;

/*Задание: 17 (Serge I: 2003-02-03)
Найдите модели ПК-блокнотов, скорость которых меньше скорости каждого из ПК.
Вывести: type, model, speed*/
Select DISTINCT product.type, laptop.model, laptop.speed
from laptop, product
where speed <
(
Select min(speed) from pc
)
AND product.type='Laptop';

/*Задание: 18 (Serge I: 2003-02-03) Найдите производителей самых дешевых цветных принтеров. Вывести: maker, price*/
Select DISTINCT maker, price
from product p join printer pr ON p.model=pr.model
where price=
(
Select min(price)
from printer
where color='y'
)
AND color='y'

/*Задание: 19 (Serge I: 2003-02-13)
Для каждого производителя, имеющего модели в таблице Laptop, найдите средний размер экрана выпускаемых им ПК-блокнотов.
Вывести: maker, средний размер экрана.*/
Select maker, AVG(screen)
from product p join laptop l ON p.model=l.model
group by maker

/*Задание: 20 (Serge I: 2003-02-13)
Найдите производителей, выпускающих по меньшей мере три различных модели ПК. Вывести: Maker, число моделей ПК.*/
Select maker, count(model)
from product
where type='pc'
group by maker
having count(model)>=3;

/*Задание: 21 (Serge I: 2003-02-13)
Найдите максимальную цену ПК, выпускаемых каждым производителем, у которого есть модели в таблице PC.
Вывести: maker, максимальная цена*/
Select maker, max(price)
from product join pc ON product.model=pc.model
group by maker;