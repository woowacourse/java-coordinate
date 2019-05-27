# Week 3. Coordinate Calculator

## [Sub Mission] Inheritance and Interface - Charging Fuel

### Function Description
1. Input
    - approximate Travel Distance
2. Domain
    - calculate Fuel Amount based on Travel Distance
3. Output
    - showing Fuel Amount about each Car

### Programming Requirements
1. Using **Abstract Class** and **Interface**
2. Don't Use **if-expression**

## [Main Mission] Coordinate Calculator
### Step 1. Length of Line
#### Function Requirements
1. View
    - X and Y coordinate
        - [INPUT] coordinates are written in parenthesis ``(x,y)``
    - When two coordinates are found from user input, it is a **Line**
        - [INPUT] separate each coordinate using ``-``
        - [OUTPUT] print distance between coordinates

2. Domain
    - ~~Point (which contains x-coordinate and y-coordinate)~~
        - ~~{EXCEPTION} upper bound is 24, lower bound is 0~~

#### Code Implements
1. domain/Coordinate
- This Object have a ``int`` value.
- Purpose of this class is to make Point Class. (Point Class have two ``Coordinate`` instance)
- Check lower bound(0) and upper bound(24)

2. domain/Point
- This Object have two ``Coordinate`` instance.

3. domain/Line
- ``-ing``

4. view/InputView
- request to user coordinate input

5. view/OutputView
- print result of Line distance