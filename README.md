
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

2. All the dependent softwares, requires to run Leefy is free and open source. The list of required softwares are as follows.
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
* Document feature request(Preferebly with code that implements the feature)

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

How to configure
================
1. Fork and clone the latest version of leefy from Github.

	https://github.com/{YOUR_GITHUB_USERNAME}/leefy.git

2. Once you have the leefy code on your machine, first step is to setup the Database for Leefy.

	2.1 Navigate to the location where database scripts are located.
		Eg: If you cloned it to a location as below.

		/home/jeewantha/Projects/GitRepositories/leefy

	You will find the database scripts in,

		/home/jeewantha/Projects/GitRepositories/leefy/leefy/leefy-api/db scripts

  2.2 Once you navigate to the "db scripts" directory, login to your MySQL command-line and
  execute the SQL script as follows.

      mysql> ./leefy_db_execute.sql

  2.3 This will execute all necessary scripts and you will have an up and running database for Leefy
  in no time.



	If you have installed MySQL command-line during your MySQL installation, you should be able
	to login to your MySQL server with your username and password.

		  >mysql -u root -p  (Press Enter)

  provide the password for the root user or to your database user with proper privileges if you are using a different user for MySQL(To simplify things I am using the root user)

 2.3 After successful login into the MySQL server. Execute the following command.
