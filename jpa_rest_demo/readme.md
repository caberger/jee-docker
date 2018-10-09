Demo Maven Project
===

This is a demo how to use maven to deploy an application to the wildfly application server
running on the jee-docker stack. 

How to build and deploy
---

To compile and deploy the war run the following command in a terminal:
```bash
mvn clean install
```

After that you should be able to see the html - [welcome page](http://localhost/srv/jee/index.html) from the application server. http://localhost/srv/jee/index.html hast to links that return the json content from the database.
