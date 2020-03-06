
Leefy
=====

If you are interested in learning different languages?
Are you willing to help others who are learning the language you are competent in?

If so, this will be a good place for you to start. A simple social network to narrow the gap between people speaking different languages and who are willing to help others.

This document will provide all the information that you are required to setup Leefy for development in your development environment.


Table of Contents

=================

1.  Setting up Environment

    1.1. Pre-requisites

    1.2. Installation Requirements

2.  Installation Instructions

    2.1. Pre-installation Verification

    2.2. Database setup

    2.3. Change the configuration files

    2.4. Deploy the Leefy system

3.  Obtaining the Source Code

4.  Additional Information

5.  Licensing Information


How to install Leefy without building from the source
======================================================
1. If you just want to check it out, it is easy to get Leefy up and running in your local machine without building it from the source.

2. All the dependent softwares, requires to run Leefy is free and open source. The list of required software are as follows.
    * Java 8 or above
    * MySQL 5.7 Community Edition
    * Tomcat 9.0.14
3. Make sure that you have installed the required softwares in your machine.
4. Go to the binaries folder in the leefy project and download the "leefy-web.war" file.
5. Copy the war file into the webapps directory in Tomcat.

To Be Continued...

Version
=====
alpha 1.0

Contributors
=====
Jeewantha Samaraweera

How to contribute?
==================
If you would like to contribute,
* Report bugs and issues
* Submit pull requests to fix issues
* Create documentation(DOC will be available soon)
* Document feature request(Preferably with code that implements the feature)

** Please feel free to contribute to the project in any way you like!

License
=======
GNU GPL v 3.0

Step By Step Guide To Setup The Development Environment For Leefy
=================================================================

Prereqisites
============
1. Leefy is developed with Java 8, you need JDK 8 or higher.
2. MySQL community edition 5.7 or higher is required for the database.
3. Tomcat 9 or higher is required to deploy Leefy.
4. Maven 3.6

How to configure
================
1. Fork and clone the latest version of leefy from Github.

	https://github.com/{YOUR_GITHUB_USERNAME}/leefy.git

2. Once you have the leefy code on your machine, first step is to setup the Database for Leefy.

	2.1 Navigate to the location where database scripts are located.
		Eg: If you cloned it to a location as below.
	
		/home/Github/Projects/GitRepositories/leefy

	You will find the database scripts in,
		
		/home/Github/Projects/GitRepositories/leefy/leefy/leefy-api/db scripts

	2.2 Once you are in the "db scripts" directory. Open a command line in that location. If you have installed the MySQL
	commandline during your MySQL installation, you should be able to login to your mysql with username and password that
	you have provided during the installation.
	
	    >mysql -u root -p
	    Enter password:
	    
	    mysql>source leefy_db_execute.sql
	
	2.3 Above command will create the Database for leefy in MySQL, you don't have to do anything else. Verify your installtion 
	by executing the below listed commands in MySQL.
	    
	    mysql>show databases;
	    
	Make sure that leefy is listed in the results.
	
	    mysql>use leefy;
	    
	    mysql>show tables;
	
	Make sure the resulting list has the below listed tables.
	
		+-------------------------+
		| Tables_in_leefy         |
		+-------------------------+
		| country                 |
		| module                  |
		| page                    |
		| privilege               |
		| privilege_dependency    |
		| role_privilege          |
		| role_tab                |
		| security_questions      |
		| tab                     |
		| user_login              |
		| user_role               |
		| user_security_questions |
		+-------------------------+
        
3. Once the DB is up and running you can start setting up your development environment for leefy. To build the project you
need Maven to be installed in your local environment.
    
    3.1 Once you have Maven installed in your local environment.
    
    3.2 In your commandline navigate to the main directory of leefy where the main(parent) POM is available.
    
            cd /home/Github/Projects/GitRepositories/leefy/leefy
    
    3.3 Execute the below command to build the project.
            
            >mvn clean install -DskipTests
            
    3.4 Once the build process is successful. You will have the binaries for leefy.
    
    3.5 OPTIONAL : If you use eclipse as you IDE, you can execute the following command to create eclipse workspace 
    related changes for leefy.
    
            >mvn eclipse:eclipse
            

Updates are coming soon.
    
To Be Continued...
