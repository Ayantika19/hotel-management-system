# hotel_management_system

# Steps to build the application :

# DB :

~~~
sudo apt-get install mysql-server
~~~
~~~
sudo mysql --password 
~~~
~~~
press enter
~~~
~~~
create database hmdb;
~~~
~~~
create user 'hmuser'@'%' identified by 'admin123';
~~~
~~~
grant all on hmdb.* to 'hmuser'@'%';
~~~
~~~
use hmdb;
~~~
# Backend application :

~~~
cd backend/
~~~
~~~
./gradlew clean build
~~~
~~~
./gradlew bootRun
~~~

# Frontend application :

~~~
cd frontend/
~~~
~~~
npm install
~~~
~~~
npm run build
~~~
~~~
npm run start
~~~

Open Web Browser and go to http://localhost:4200

# Add roles to the database
~~~
INSERT INTO roles(roleid, name) VALUES(1,'ROLE_GUEST');
INSERT INTO roles(roleid,name) VALUES(2,'ROLE_MANAGER');
INSERT INTO roles(roleid,name) VALUES(3,'ROLE_ADMIN');
INSERT INTO roles(roleid,name) VALUES(4,'ROLE_FRONTENDEMPLOYEE'); 
~~~
