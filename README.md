# Project-Management-API

## Startup

Create build.properties file with environment variables.

_Packaging:_

```bash
mvn clean package
```

_Building docker image:_

```bash
docker build . -t project-management-api:1.0
```

_Starting docker container:_

```bash
docker run --env-file ./buil.properties -p 8080:8080 project-management-api:1.0
```

## Build properties

```properties
DB_URL=
DB_USERNAME=
DB_PASSWORD=
```

## Requirements

- MySQL database
- Keycloak - open source identity and access management solution
- Docker

## Security

## Tests

- TestContainers
- Allure

#### 

```properties
DB_URL=
DB_USERNAME=
DB_PASSWORD=
```

## API Documentation

[swagger-ui](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)