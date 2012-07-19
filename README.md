Ara
===

The Ara (Advanced Realtime Analytics) toolkit is a suite of tasks in context of Big Data.
It is then possible to:

-Continuously connect to streams (the best example is Twitter 1% sample streaming)
-Store data in relational databases (MySQL) and NoSQL databases (MongoDB)
-Apply some filters on data 
-Realise analysis in both realtime and batch computation

The different tasks are arranged into workflows

Ara toolkit borrows from realtime computation (Storm), batch computation (Hadoop) and analytics (Pig and Hive)

It is easy to use: 

-Create a file "config.xml" (named it as you want) like this: 
<?xml version="1.0" encoding="UTF-8"?>
<config>
  <login>LOGIN</login>
	<password>PASSWORD</password>
	<URL>https://stream.twitter.com/1/statuses/sample.json</URL>	
</config>
-Replace LOGIN and PASSWORD by your own login and password for the streaming
-Run Ara as follows: java makesense.ara.Ara config.xml

If everything is in order, you should see your streaming on the standard output