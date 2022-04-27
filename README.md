# Account manager

**NOTE: This project DOES NOT work yet. It is in progress ...**

I started this project to be able to manage my different accounts using:

- Filesystem database storage
  - All information stored as file(s)
  - Easy synchronization possible via a file sync
    - like Synology Drive (used for my tests) 
    - or Google Drive or any other file sync.
- Quarkus app for managing the REST interface
- Simple web UI (to be done)

There is NO:

- user management

## TODO

### First impl

- Read / Write transaction file(s)
- Transaction file listener + Startup load transactions
- CRUD transaction rest endpoint
  
- Read / Write account file(s)
- Account file listener + Startup load accounts
- CRUD account rest endpoint
  
- Read / Write category file(s)
- Category file listener  + Startup load categories
- CRUD category rest endpoint
  
- Create transaction summary files (per account, per category ?)
- Transaction summary file listener + Startup load transaction summaries

- List of transactions filters
	- for a given time period
	- on a specific account (source & target)
	- for all accounts

### Later

- Organize transaction files per subfolders (month/year)
- Setup budget storage (budgetline)
  - Code
  - Tests
- Compact old months/years
- Scheduled transactions

## Dev

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

### Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

### Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/account_manager-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

### Related Guides

