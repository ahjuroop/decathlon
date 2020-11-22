# Decathlon Score Calculator
A simple web application to calculate decathlon scores.

## Prerequisites
- Java 11
- Gradle 6.6.1 (wrapper included)

## Building & Running
- ./gradlew bootRun
- Navigate to http://localhost:8080

## Additional Features
There is a REST API for future Ajax requests.

`GET /api/events` - returns an array of decathlon events:
```
[
    {
      "code": "_100_M",
      "name": "100 m",
      "measurement": "s"
    },
    ...
]
```

`POST /api/results` - returns an object of decathlon results. Request structure:

```
{
    "results": {
        "_100_M": 25,
        ...
    }
}
```

where the keys in `results` map are the codes obtained from `/events` and values are the results corresponding to that decathlon event (in the format as specified by `measurement`).

Response:

```
{
    "scoreRefNum": -1,
    "calculatedScores": {
        "_100_M": 0,
        ...
    }
}
```

where the values in `calculatedScores` map are the points scored in the event.
