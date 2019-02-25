# Babysitter Problem
- https://github.com/PillarTechnology/kata-babysitter

## Prerequisites
- Maven
- Java 8 or later
- JAVA_HOME environment variable set

## Run Tests
`mvn clean test`

## Run Service
`mvn clean spring-boot:run`

Using curl or some http client send a request to `localhost:8080/total` with the following schema

```json
{
	"start": "2019-02-22T01:00:29.836",
	"end": "2019-02-22T04:00:29.836",
	"ranges": [
		{
			"name": "familyA",
			"type": "before",
			"before": "2019-02-22T02:02:55.836",
			"rate": 14
		}
	]
}
```

