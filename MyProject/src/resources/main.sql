use EmployeeManagement;

drop table Employee;

CREATE TABLE IF NOT EXISTS Employee (
	emp_id INT AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	PRIMARY KEY (emp_id)
);

INSERT INTO Employee (first_name,last_name,email) VALUES ('Sachin','Tendulkar','st@abc.com');
INSERT INTO Employee (first_name,last_name,email) VALUES ('Rahul','Dravid','rd@abc.com');


select * from Employee;