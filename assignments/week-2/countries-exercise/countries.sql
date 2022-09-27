/*

1. Construct a table for country information, it can include any columns you want. Try to have at least 5 columns for information about a country.
You may want to include information about country names or abbreviations, region of the world, population or landmass size, or maybe some economic
information too. This is designed to be open ended so you can add whatever information you want! Remember, not all data will fall
into the datatypes we've been actively using so far (int, varchar, and bool) so don't be afraid to look up the different postgresql data types
to find what you're looking for!

After constructing the table attempt to add in at least 5 countries, if you can't find a specific piece of info 
for a country, try to leave it null and see how the end result looks. Don't forget to refresh your database as you go along.

After you finish, right-click on the name of the file at the top, and attempt to copy the file (you may have to go to the file explorer or similar)
and move a copy into your personal repository and push that up to GitHub. Bonus points for navigating to the file using the command line and moving 
a copy that way. Be prepared to share after completed.

*/
-------------------------------------------------------------------------------

--1: create the table
CREATE TABLE countries (
	"name"       varchar(32),
	"capitol"    varchar(32),
	"leader"     varchar(32),
	"population" bigint,
	"currency"   varchar(16),
	"language"   varchar(32)
);

--2: add the information for several entries
INSERT INTO countries 
VALUES ('Spain', 'Madrid', 'Felipe VI of Spain', 47350000, 'Euro', 'Spanish');

INSERT INTO countries 
VALUES ('Cambodia', 'Phnom Penh', null, 16720000, 'USD, Riel', 'Khmer');

INSERT INTO countries 
VALUES ('Egypt', 'Cairo', 'Abdel Fattah El-Sisi', 102300000, null, 'Arabic');

INSERT INTO countries 
VALUES ('Canada', 'Ottawa', 'Justin Trudeau', 38010000, 'Canadian Dollar', 'English, French');

INSERT INTO countries 
VALUES ('India', 'New Delhi', 'Droupadi Murmu', 1380000000, 'Indian Rupee', 'Hindi, English');
