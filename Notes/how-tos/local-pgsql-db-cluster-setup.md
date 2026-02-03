# Setting up a Local PostgreSQL Database Cluster [↑](../../README.md#how-tos)

1. Open Command Prompt.
2. cd to the PostgreSQL installation bin directory (e.g. `C:\Postgres\bin`).
3. Run this command `initdb -D "Path\To\Desired\Location\Of\DB\Cluster -U porgres`.
4. Once initialization of database is complete, start the database by running the command
```bash
pg_ctl start -D "Path\To\Location\Of\DB\Cluster\PostgresData
```