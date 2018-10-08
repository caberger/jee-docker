#!/bin/bash
# wait until MySQL is really available
maxcounter=60
 
counter=1
while ! mysql -h mysql -u"root" -p"$MYSQL_ROOT_PASSWORD" -e "show databases;"; do
    echo "waiting for Godot..."
    sleep 1
    counter=`expr $counter + 1`
    if [ $counter -gt $maxcounter ]; then
        >&2 echo "We have been waiting for MySQL too long already; failing."
        exit 1
    fi;
done
echo "yeah, mysql available, so lets go..."
#see https://stackoverflow.com/questions/20965737/docker-jboss7-war-commit-server-boot-failed-in-an-unrecoverable-manner:
rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/current/*
/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 --debug

