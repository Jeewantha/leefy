
Leefy
=====

If you are interested in learning different languages?
Are you willing to help others who are learning the language you are competent in?

If so, this will be a good place for you to start. A simple social network to narrow the gap between people speaking different languages and who are willing to help others.

This document will provide all the information that you are required to setup Leefy for development in your development environment.

How to install Leefy without building from the source
======================================================
1. If you just want to check it out, it is easy to get Leefy up and running in your local machine without building it from the source.

2. All the dependent softwares, requires to run Leefy is free and open source. The list of required softwares are as follows.
    * Java 8 or above
    * MySQL 5.7 Community Edition
    * Tomcat 9.0.14

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
1. Clone the latest version of leefy from Github.
	
	https://github.com/{YOUR_GITHUB_USERNAME}/leefy.git

2. Once you have the leefy code on your machine, first step is to setup the Database for Leefy.
	
	2.1 Navigate to the location where database scripts are located.
		Eg: If you cloned it to a location as below.
	
		/home/jeewantha/Projects/GitRepositories/leefy

		You will find the database scripts in,
		
		/home/jeewantha/Projects/GitRepositories/leefy/leefy/leefy-api/db scripts

	2.2 Once you are in the "db scripts" directory. Open a command line in that location. If you have installed the MySQL
	commandline during your MySQL installation, you should be able to login to your mysql 
	
To Be Continued...
