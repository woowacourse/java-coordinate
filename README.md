# java-coordinate
좌표계산기 미션을 진행하기 위한 저장소

## 1단계

### - 요구사항
    + 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
    + 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
    + X, Y좌표 모두 최대 24까지만 입력할 수 있다.
    + 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.
    + 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
    + 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
    + 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.
   
### - 필요한 기능
    1. 좌표 (X, Y)
        - 0 ~ 24 사이의 값을 가지는지
        - ~~null 검사~~
            파라미터가 원시타입이므로 null 검사가 필요없다고 판단.
    2. 점 (Point)
    3. 선 (Line)
        - 거리 계산
  
## 2단계      
    
### - 요구사항
    + 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
    + 좌표값을 네 개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.
    + 네 점이 뒤틀어진 사다리꼴이나 마름모는 제외하고 직사각형만 허용하도록 검사한다.
    + 사각형인 경우 사각형의 넓이를 계산해서 출력한다

### - 필요한 기능
    1. 사각형
        - 중복된 Point가 있는지 여부
        - 직사각형 여부
        - Point가 4개인지
        - null 검사
        - 넓이 계산
    