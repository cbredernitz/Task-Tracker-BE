# Task-Tracker-BE

## Overview

This is a Kotlin SpringBoot backend for the application Task Tracker.

## Integration Tests

You can run the integration tests independently through gradle. 
The `application-test.yml` file is the active profile for these, which includes a connection to H2 and flyway access
```bash
./gradlew integrationTest
```

