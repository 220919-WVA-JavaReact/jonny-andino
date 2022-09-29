-- 1. Create a table named `inventory` with the following fields
--    1. ID (number) PRIMARY KEY
--    2. name (varchar)
--    3. price (number; choose a type that supports at least two decimal places)
--    4. description (varchar)
--    5. quantity (number)

CREATE TABLE inventory (
	"id"           int PRIMARY KEY,
	"name"         varchar(32),
	"price"        float,
	"description"  varchar(255),
	"quantity"     int
);

-- 2. Insert the following records to your table so that it looks like the following:

INSERT INTO inventory 
VALUES
(1001,	'Hershey Bar',	    3.45,	'A small chocolate bar',	                    50),
(1002,	'Skittles',	        3.05,	'A bag of rainbow colored candies',	            100),
(2003,	'Gummy Bears',	    5.55,	'A large bag of chewy fruit-flavored bears',	48),
(2005,	'Sour Gummy Worms',	9.55,	'A very large bag of gelatin worms',	        20),
(3008,	'Lollipop',	        2.25,	'A hard candy atop a stick',	                268),
(9007,	'M&Ms',	            1.95,	'A bag of small chocolate candies',	            58);

-- 3. Run a query to read and display all records in our table

SELECT * FROM inventory;

-- 4. A customer has just purchased 2 Hershey Candy Bars. Update the inventory to be 48 now. 

UPDATE inventory SET "quantity" = 48 WHERE "name" = 'Hershey Bar';

-- 5. Run a query to return only the descriptions of all records in the table. 

SELECT "description" FROM inventory;

-- 6. A customer wants to see all items in your store and their prices. 
-- Run a query to return the name and price only of all records in the table. 

SELECT "name", "price"
FROM inventory;

-- 7. Change the description of the Sour Gummy Worms to be 'A very large, delicious bag of worms'.

UPDATE inventory SET "description" = 'A very large, delicious bag of worms' WHERE "name" = 'Sour Gummy Worms';

-- 8. You've received a shipment of M&Ms just now! Update the quantity to 100. 

UPDATE inventory SET "quantity" = 100 WHERE "name" = 'M&Ms';

-- 9. You are getting a lot of demand for lollipops. Update the price to $2.50. 

UPDATE inventory SET "price" = 2.50 WHERE "id" = 3008;

-- 10. Create a table named `employees` with the following fields
--    1. ID (number)
--    2. name (varchar)
--    3. favorite_candy (should reference the Primary Key of inventory)

CREATE TABLE employees (
	"id"             int PRIMARY KEY,
	"name"           varchar(32),
	"favorite_candy" int REFERENCES inventory
);

-- 11. Insert the following data into your employees table so it looks like the following

INSERT INTO employees
VALUES
	(4001,	'Willy Wonka',	    2005),
	(4002,	'Milton Hershey',	1001),
	(4003,	'Franklin Mars',	9007),
	(4004,	'John Cadbury',	    NULL);

-- 12. Run a query to print the name of each employee and their favorite candy if they have one

SELECT e."name", i."name"
FROM employees e
JOIN inventory i ON e."favorite_candy" = i."id";

-- 13. Run a query to display the names of all candies and the name of the corresponding employee who likes them. For this make sure the names of all the candies print out, even if none of the employees like them.

SELECT i."name", e."name"
FROM inventory i
RIGHT JOIN employees e ON i."id" = e."favorite_candy";

-- Bonus Questions:

-- 14. What is the total cost to purchase all remaining M&Ms in your store?
SELECT SUM("price" * "quantity")
FROM inventory
WHERE "name" = 'M&Ms';

-- 15. Run a query to return the name and price of the candy item that costs the least amount of money. 
SELECT "name", "price"
FROM inventory
ORDER BY "price" DESC
LIMIT 1;

-- 16. Run a query to return the candy item with the largest quantity in inventory. Return just the name and the quantity left. 
SELECT "name", "quantity"
FROM inventory
ORDER BY "quantity"
LIMIT 1;

-- 17. Run a query to return the 3 most expensive candy items. Return all columns. 
SELECT * FROM inventory
ORDER BY "price"
LIMIT 3;

-- 18. Run a query to return the average cost of all the candies in the shop
SELECT AVG("price") FROM inventory; 

-- 19. Run a query to print out the name of an employee and how much they'd have to spend to buy the entire stock of their favorite candy
SELECT e."name", SUM(i."quantity" * i."price") AS "stock_price"
FROM employees e 
JOIN inventory i ON e."favorite_candy" = i."id"
GROUP BY e."name";

-- 20. Run a query to print out the names of employees whose favorite candy have 'chocolate' in the description
SELECT e."name"
FROM employees e 
JOIN inventory i ON e."favorite_candy" = i."id"
WHERE i."description" LIKE 'chocolate';

-- ^ still trying to figure this one out --