# Project Title : Configure and Connect a MySQL Database Instance with a Web Server

## DESCRIPTION 
You are working as a database administrator for an IT firm. You have been asked to create a new database instance on AWS cloud and connect it with the employee management portal hosted on a web server.

### Background of the problem statement: 
Your organization wants to deploy a new multi-tier application. The application will take live inputs from the employees and it will be hosted on a web server running on the AWS cloud. 
The development team has asked you to set up the web server and configure it to scale automatically in cases of a traffic surge, to make the application highly available. They have also asked you to take the inputs from the employees and store them securely in the database.
 
### You must use the following:

#### Create a Database Instance with the following specifications: <br>
**Database creation method:** Standard Create <br>
**Engine:** MySQL <br>
**Database Instance size:** db.t2.micro <br>
 
#### Create an EC2 Instance with the following specifications: 
**AMI:** Amazon Linux  <br>
**Region:** Use only US East (N Virginia), us-east-1, and us-east-2 <br>
**Instance types:** t2.micro and t3.micro <br>
**Allowed EBS types:** GP2 and Standard <br>

### Following requirements should be met: 

Follow the above-mentioned specifications <br>
Make sure that the Availability Zone is similar throughout the instances and volumes <br>
Ensure that the server scales automatically and the traffic is optimally routed among the scaled servers <br>
Document the step-by-step process involved in completing this task <br>
 
### Proposed Solution – Architecture Diagram 
<i> Note: Security Group and Route tables are available in screenshots of project documents </i>

 ![image](https://github.com/nilesh-shardul/Employee_management_portal/assets/40804989/007302b6-b968-48e3-b814-ebd63d177fcf)


## Project Execution Steps in AWS  <br>
Make sure first you install the Backend application. All the below steps with screenshots are available in the ppt file uploaded in the project  <br>

### 1.	Network setup (VPC, Subnet, Internet Gateway, Route tables) <br>
In this step, new VPC is created for MyProject and two public subnets are created in AZ us-east-1a, us-east-1b. New internet Gateway is created and attached to VPC. In the route table created for VPC, inbound traffic from internet is linked to internet Gateway. <br>

### 2.	RDS – MySQL DB (Subnet group, DB setup and configure) <br>
In this, first create subnet group and attach VPC and its subnets. Then create MySQL RDS with standard, free-tier instance setup with auto-scaling, backup and minor version upgrade enabled. <br>
This DB should be created to VPC and the new subnet group created for the VPC.  <br>

### 3.	EC2 instance creation (Configure MySQL in Security Group) <br>
Create EC 2 instance (in free-tier) with the user data to configure Apache HTTP server and MySQL client. Add Entry for MySQL/Aurora at port 3306 in security group.  <br>

### 4.	Configure RDS Security Group to EC2 Security Group <br>
In RDS instance, add inbound rule for type MySQL/Aurora (port 3306) pointing to source as security group created for EC2 instances <br>

### 5.	Login to EC2 and test DB from MYSQL client, create tables <br>
From EC2 connect, login to DB using MySQL client, create table and add some records to verify the connectivity from EC2 <br>

### 6.	Create new AMI and test creating new instances with the new AMI <br>
From the created EC2 instance (which is already tested with MySQL client), create new AMI. Later create and test new EC2 instance with new AMI <br>

### 7.	Create Load Balancer for EC2  (Load Balancer, Target Group) <br>
Create load balancer with Target group for monitoring all the instances with health check. Also test the new domain link created by load balancer  <br>
 
### 8.	Create Scaling for EC2 (Auto Scaling Group, Launch Configuration) <br>
Create a new launch template for EC2 instance from the already created AMI. In Auto Scaling Group configure launch template, VPC, subnets. Select health check from already created Load Balancer.  Also, mention min, max and designed CPU instances based on auto scaling  policy  <br>


