
create table department
	(dept_id	numeric(2,0),
	dept_name		varchar(20), 
	primary key (dept_id)
	);
create table student
	(user_id		varchar(15),
	 password		varchar(7),
	 rollno		varchar(10),
	 name		varchar(20),
	 dept_id numeric(2,0),
	 email    varchar(30,0),
	 primary key (userid),
	 foreign key (dept_id) references department
	 on delete set null
	);

create table course
	(course_id		varchar(8), 
	 title			varchar(50), 
	 dept_id		numeric(2,0),
	 rating numeric(3,2) check (rating>0.0and rating<6.0),
	 primary key (course_id),
	 foreign key (dept_id) references department
		on delete set null
	);

create table instructor
	(instructor_id			varchar(5), 
	 name			varchar(20) not null, 
	 dept_id		numeric(2,0), 
	 rating numeric(3,2) check (rating>0 and rating<6),
	 primary key (instructor_id),
	 foreign key (dept_id) references department
		on delete set null
	);

create table follow
	(user_id		varchar(8), 
     course_id			varchar(8),
	 primary key (course_id, user_id),
	 foreign key (course_id) references course
		on delete cascade,
	 foreign key (user_id) references student
		on delete cascade,
	);

