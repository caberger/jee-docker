FROM jboss/wildfly

USER root

COPY docker-entrypoint.sh /usr/local/bin/

RUN chmod +x /usr/local/bin/docker-entrypoint.sh && \
    yum -y install bash mysql-connector-java mysql && \
    yum clean all && \
    rm -f /var/log/yum.log

USER jboss
RUN mkdir -p /opt/jboss/tmp
COPY wildflyconf.cli /opt/jboss/tmp/

RUN /opt/jboss/wildfly/bin/add-user.sh --user root --password root
RUN rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/current/*
    # last line is a workaround due to https://issues.jboss.org/browse/WFCORE-1501

RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/jboss/tmp/wildflyconf.cli && rm -rf /opt/jboss/tmp/

EXPOSE 8080 9990 8787
#CMD ["/usr/local/bin/docker-entrypoint.sh"]

CMD tail -f /dev/null

