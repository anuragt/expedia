1. Make sure you have maven installed and working. 
2. Make sure you have internet connection for connecting to maven repository. 
3. Download the java project WeatherHelper.
4. In your tomcat installation, go to path {tomcat_home}/conf/tomcat-users.xml
5. Make sure you have a user for admin,manager role as mentioned below. 

<?xml version='1.0' encoding='utf-8'?>
<tomcat-users>
  <role rolename="manager"/>
  <role rolename="admin"/>
  <user username="admin" password="password" roles="admin,manager"/>
</tomcat-users>

6. Go to {Maven_HOME}/conf/settings.xml

7. Make sure you have entry like this. Keep the id as "TomcatServer" which is being referenced in maven script.

<server>
	<id>TomcatServer</id>
	<username>admin</username>
	<password>password</password>
</server> 

8. start your tomcat.
9. Open command prompt and Go to the project home directory.
10. run "mvn clean package tomcat:deploy" to deploy app. run "mvn clean package tomcat:undeploy tomcat:deploy" if you want to override.
11. go to localhost:8080/weatherhelper/cityInfo.do and use the application. 