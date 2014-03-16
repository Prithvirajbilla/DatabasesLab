### Name
Prithviraj M Billa

### Roll No 

110050065

### Files included

lab7.war
dbms.sql
(src-folder) lab7/

### Web app Structure

/lab7/index.jsp -- Login form

Username	pass	role
user1		pass1	reader
user2		pass2	writer
user3		pass3	reader
user4		pass4	writer

/lab7/query.jsp  --- Query Form

/lab7/write.jsp  --- add | delete movie details

/lab7/writeaward.jsp  --- add|delete movie awards

/lab7/logout.jsp       --- logout


/lab7/Login -- receive post request from login form

/lab7/Write  -- receive post request from write.jsp

/lab7/WriteAward -- receive post request from writeaward.jsp


to run the script
psql -h hostname -U username dbms < dbms.sql

this command populates the psql database.

run the tomcat server.

:)
