#!/bin/sh
set -e

# Railway provides DATABASE_URL as postgres://user:pass@host:port/db
# Spring JDBC requires jdbc:postgresql://user:pass@host:port/db
if [ -z "$DB_URL" ] && [ -n "$DATABASE_URL" ]; then
  # Replace postgres:// or postgresql:// scheme with jdbc:postgresql://
  STRIPPED="${DATABASE_URL#postgres://}"
  STRIPPED="${STRIPPED#postgresql://}"
  export DB_URL="jdbc:postgresql://${STRIPPED}"
fi

exec java -jar /app/app.jar