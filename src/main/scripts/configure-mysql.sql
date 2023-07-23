# docker run --name mysqldbv1 -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
# create databases
create database recipe_dev;
create database recipe_prod;

#create database service accounts
create user 'recipe_dev_user'@'localhost' identified by '23summer';
create user 'recipe_prod_user'@'localhost' identified by '23summer';

# Database grants
grant select on recipe_dev.* to 'recipe_dev_user'@'localhost';
grant insert on recipe_dev.* to 'recipe_dev_user'@'localhost';
grant delete on recipe_dev.* to 'recipe_dev_user'@'localhost';
grant update on recipe_dev.* to 'recipe_dev_user'@'localhost';
grant select on recipe_prod.* to 'recipe_prod_user'@'localhost';
grant insert on recipe_prod.* to 'recipe_prod_user'@'localhost';
grant delete on recipe_prod.* to 'recipe_prod_user'@'localhost';
grant update on recipe_prod.* to 'recipe_prod_user'@'localhost';

