#!/bin/sh
set -e

# Railway provides DATABASE_URL as postgresql://user:pass@host:port/db
# Spring JDBC requires jdbc:postgresql://user:pass@host:port/db
if [ -n "$DATABASE_URL" ]; then
  STRIPPED="${DATABASE_URL#postgres://}"
  STRIPPED="${STRIPPED#postgresql://}"
  export DB_URL="jdbc:postgresql://${STRIPPED}"
fi

exec java -jar /app/app.jar
