#!/bin/sh
set -e

# Normalize DB_URL to jdbc:postgresql:// regardless of source or current scheme.
# Railway may inject DB_URL as postgresql:// or DATABASE_URL as postgres://.
RAW_URL="${DATABASE_URL:-$DB_URL}"
if [ -n "$RAW_URL" ]; then
  STRIPPED="${RAW_URL#jdbc:postgresql://}"
  STRIPPED="${STRIPPED#jdbc:postgres://}"
  STRIPPED="${STRIPPED#postgresql://}"
  STRIPPED="${STRIPPED#postgres://}"
  export DB_URL="jdbc:postgresql://${STRIPPED}"
  echo "INFO: DB_URL normalized to jdbc:postgresql://"
else
  echo "ERROR: Neither DATABASE_URL nor DB_URL is set"
  exit 1
fi

exec java -jar /app/app.jar
