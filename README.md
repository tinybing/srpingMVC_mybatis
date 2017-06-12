SpringMVC+Spring+MyBatis
========================

Frameworks and Tools
-----------------------------------
* Java&IDE: JDK8 Intellj
* Backend:  SpringMVC4.3.5.RELEASE Spring4.3.5.RELEASE MyBatis3.4.2
* Database: mysql
* Web Server: Tomcat 7
* Build Tool: Maven
* Other: Druid(database connection pool) JUnit Log4j Jackson FastJson page plugin:pagehelper mybatis-generator

System Features
-----------------------------------
* Integration of Spring core, Spring MVC, and MyBatis
* Management of users through CRUD interface

Code Generator for MyBatis
-----------------------------------
* You can find code generator from [the link](http://mybatis.github.io/generator/)
* In the folder of mybatis-generator, you can find generator.xml and mybatis-generator-core-1.3.5.jar. 
* Download these two files in the folder of C:\mybatis, and run the following command:
  java -jar mybatis-generator-core-1.3.5.jar -configfile generator.xml -overwrite
* Then Java POJOs that match the table structure will be generated.
* You also can do it in project by run maven command "mvn mybatis-generator:generate" 
  generator configfile path: resurces/generator/generatorConfig.xml ,you can modify the folder.
  
About
-----------------------------------
* [Github link](https://github.com/tinybing/srpingMVC_mybatis)
* reference to [Github link](https://github.com/ZhibingXie)  


