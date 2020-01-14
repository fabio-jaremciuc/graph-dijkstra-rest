FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE root
ENV MYSQL_USER root
VOLUME /tmp
COPY ./schema.sql /docker-entrypoint-initdb.d/schema.sql
EXPOSE 3306
