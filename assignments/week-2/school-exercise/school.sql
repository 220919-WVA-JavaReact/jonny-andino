-- create tables with no foreign keys first --

CREATE TABLE students (
	"id"    serial PRIMARY KEY,
	"name"  varchar(32) NOT NULL,
	"email" varchar(32) NOT NULL UNIQUE
);

CREATE TABLE teachers (
	"id"    serial PRIMARY KEY,
	"name"  varchar(32) NOT NULL,
	"email" varchar(32) NOT NULL UNIQUE
);

CREATE TABLE topics (
	"id"   serial PRIMARY KEY,
	"name" varchar(32) NOT NULL UNIQUE
);

-- create other tables --

CREATE TABLE courses (
	"course_num" int PRIMARY KEY,
	"title" varchar(255) NOT NULL,
	"instructor_id" int REFERENCES teachers
);

-- junctions --

CREATE TABLE students_courses ( 
	"student_id" int REFERENCES students,
	"course_id" int REFERENCES courses
);

CREATE TABLE courses_topics ( 
	"course_id" int REFERENCES courses,
	"topic_id" int REFERENCES topics
);

-- adding in data --

INSERT INTO students ("name", "email")
VALUES 
	('Frisk', 'fdreemur@underground.net'),
	('Niko', 'myburdenislight@refuge.sh'),
	('Asriel', 'savetheworld@gmail.com'),
	('Kip', 'redphosphor@refuge.sh'),
	('Chara', 'bestnightmare@underground.net');
	
INSERT INTO teachers ("name", "email")
VALUES 
	('Toriel', 'homesweethome@underground.net'),
	('Silver', 'bluephosphor@refuge.sh'),
	('Undyne', 'aaaaahhhh@undererground.net');

INSERT INTO topics ("name")
VALUES 
	('Magic'),
	('General Studies'),
	('Physical Education'),
	('Mathemetics');


--insert courses with corresponding instructors

INSERT INTO courses
VALUES
	(101, 'What not to do at a stoplight', 1),
	(202, 'Combat and magic and you',      3),
	(64,  'How to count to 3ABCDF',        2);

--populate junctions--

INSERT INTO students_courses 
VALUES
	(1, 202),
	(2, 202),
	(3, 101),
	(4, 64),
	(2, 64);
	
INSERT INTO courses_topics
VALUES
	(101, 2),
	(202, 3),
	(202, 1),
	(64, 4);