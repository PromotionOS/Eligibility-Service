#!/bin/sh
set -e

# Railway provides DATABASE_URL as postgresql://user:pass@host:port/db
# Spring JDBC requires jdbc:postgresql://user:pass@host:port/db
if [ -n "$DATABASE_URL" ]; then
  STRIPPED="${DATABASE_URL#postgres://}"
  STRIPPED="${STRIPPED#postgresql://}"
  export DB_URL="jdbc:postgresql://${STRIPPED}"
  echo "INFO: DB_URL scheme set to jdbc:postgresql://"
else
  echo "WARN: DATABASE_URL not set — DB_URL must be provided manually"
fi

exec java -jar /app/app.jar
