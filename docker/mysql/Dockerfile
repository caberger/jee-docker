FROM mysql:5

COPY 10-createdb.sql 20-data.sql /docker-entrypoint-initdb.d/
#RUN echo "[mysqld]" >> /etc/mysql/conf.d/aberger.cnf && \
#    echo "default_authentication_plugin=mysql_native_password" >> /etc/mysql/conf.d/aberger.cnf

