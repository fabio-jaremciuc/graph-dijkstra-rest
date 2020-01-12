FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE root
ENV MYSQL_USER root
COPY ./create_tables.sql /docker-entrypoint-initdb.d/create_tables.sql
EXPOSE 3306
