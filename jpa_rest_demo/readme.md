Demo Maven Project
===

This is a demo how to use maven to deploy an application to the wildfly application server
running on the jee-docker stack. 

How to build and deploy
---

To compile and deploy the war run the following command in a terminal:
```bash
mvn install
```

After that you should be able to see the JSON - REST response
by navigating to the [department controller](http://localhost/srv/jee/app/dept). There is also a 
[servlet](http://localhost/srv/jee/hello).