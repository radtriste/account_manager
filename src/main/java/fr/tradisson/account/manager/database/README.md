# FS database

## FS storage

### Each model class should be stored into different files.

  - per account (`accounts` folder => no specific folder needed)
  - per budget (`budgets` folder => subfolder `month_year`)
  - per transaction (`transactions` folder => subfolder `month_year`)
  - per month summaries (`summaries` folder => subfolder `month_year`)

### Store as key/value pair ?

  - Each model class should have an `id`
  - Per subfolder should define which attribute to be taken for `subfolder`

# FS functionality

### Startup

- Load all files into memory
  - wouldn't that be too much ?
    - to see
- Setup listeners on folders
  - https://docs.oracle.com/javase/tutorial/essential/io/notification.html

### Listeners

- Transaction listener on transactions folder
  - Update transaction memory database
- Summary listener on summary folders
  - Update summary memory database
- Transaction Summary listener on transactions folder
  - Calculate new summary and store to FS
- Account listener on accounts folder
  - Update account memory database
- Budget listener on budget folder
  - Update budget memory database

### Add a transaction
  
- Register new transaction to a queue
- Transaction listener will listen for that new information and reconcile
  - reconciler should be synchronized to avoid parallel run
- Reconciler will update filesystem with new transaction

### Add an account

# Compaction

To be done later

More or less, aggregate each file containing one entry to 