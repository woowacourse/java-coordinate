# java-coordinate
## Domain
1. Point
    - x, y 좌표 저장
    - 1 ~ 24 범위의 좌표 저장
    - 다른 point와의 거리 계산
2. Points
    - 여러 개의 point 저장
    - 중복 좌표 검사
3. PointsGenerator
    - 특정 문자열을 points로 변환
4. Shape
    - points 개수에 맞는 Figure 생성
5. Figure
    - 여러 도형의 parent class
6. Line
    - 선의 길이 계산
7. Triangle
    - 삼각형 넓이 계산
    - 세 점이 일직선에 있는 경우 검사
8. Rectangle
    - 사각형 넓이 계산
    - 직사각형이 아닌 경우 검사
9. Calculable
    - 계산할 수 있다는 것을 나타내는 interface

## View
1. InputView
    - 좌표를 입력 받음
2. OutputView
    - point를 좌표계에 출력
    - 계산 결과 출력