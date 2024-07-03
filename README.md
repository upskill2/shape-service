# shape-service
Shape service is a RESTful service implemented using Spring Boot 2.6.3, Java 17, Maven. The service supports the following shapes:

- Circle
- Square
- Triangle
- Rectangle

Calculations supported for each shape are:

- Area
- Perimeter

# Task Requirements:
- Validations - custom validations implemented:
    - unsupported shape type
    - unsupported calculation type
    - missing calculation type request params (shapeType, calculationType)
    - missing shape parameters (e.g. radius, side, base, height, etc.)
    - shape parameter is less than or equal to zero
    - custom exceptions, handler and HTTP statuses for exceptions - see "exception" package
- One endpoint for all shapes
    - implemented using factory and strategy patterns
    - polymorphism OOP is widely used
- Unit tests - app context load test

## Build and Run

mvn clean install -DskipTests

mvn spring-boot:run

## HTTP Request Parameters

The service supports the following request parameters:

- shapeType = circle || square || triangle || rectangle
- calculationType = area || perimeter

## HTTP Request Method

POST, Content-Type: application/json, Accept: application/json, uri: /shape

## HTTP Request BODY
Depending on the shape, the request body should contain one or number of the following fields:

```json
{
  // Square
  "squareSide": double (optional),
  // Rectangle
  "length": double (optional),
  "width": double (optional),
  // Circle
  "radius": double (optional),
  // Triangle
  "triangleBase": double (optional),
  "triangleSide2": double (optional),
  "triangleSide3": double (optional),
  "height": double (optional)
}
```
## Send HTTP Request
The service exposes the following endpoints:

- Triangle shape service
    - Calculate the area of a triangle
        - POST http://localhost:8080/shape?shapeType=triangle&calculationType=area
    - Calculate the perimeter of a triangle
        - POST http://localhost:8080/shape?shapeType=triangle&calculationType=perimeter

```json
{
  "triangleSide2": 10,
  "triangleSide3": 10,
  "triangleBase": 10,
  "height": 5
}
```

- Circle shape service
    - Calculate the area of a circle
        - POST http://localhost:8080/shape?shapeType=circle&calculationType=area
    - Calculate the perimeter of a circle
        - POST http://localhost:8080/shape?shapeType=circle&calculationType=perimeter

```json
{
  "radius": 5
}
```

- Square shape service
    - Calculate the area of a square
        - POST http://localhost:8080/shape?shapeType=square&calculationType=area
    - Calculate the perimeter of a square
        - POST http://localhost:8080/shape?shapeType=square&calculationType=perimeter

```json
{
  "squareSide": 5
}
```

- Rectangle shape service
    - Calculate the area of a rectangle
        - POST http://localhost:8080/shape?shapeType=rectangle&calculationType=area
    - Calculate the perimeter of a rectangle
        - POST http://localhost:8080/shape?shapeType=rectangle&calculationType=perimeter

```json
{
  "length": 5,
  "width": 4
}
```