#!/bin/bash

echo "Resetting repo to clean state..."

# Reset Git changes
git reset --hard origin/main
git clean -fd

echo "Repo files reset to origin/main."

# Optional: Drop and recreate the MySQL schema
echo "Resetting MySQL database..."
mysql -h mysql -u serverdbadmin -p12345 -e "DROP DATABASE IF EXISTS serverdb; CREATE DATABASE serverdb;"

echo "MySQL database reset complete."

# Optional: Rerun any SQL seed scripts if you have one
# mysql -h mysql -u serverdbadmin -p12345 serverdb < ./seed.sql

echo "🚀 Restarting Spring Boot app..."
pkill -f 'spring-boot' || true
./mvnw spring-boot:run
