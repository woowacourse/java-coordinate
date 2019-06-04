# java-coordinateView
좌표계산기 미션을 진행하기 위한 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 좌표 계산기

1. 좌표 입력 받기
    - 입력 형식에서 숫자만 추출
    - 단계별로 추출
2. 좌표 관리
    - x, y좌표를 래핑할 클래스 Point
    - 좌표들의 묶음도 필요. Points? List<Point>?
3. 좌표들의 집합에 따라 타입 분류
    - Line, Triangle, Rectangle
    - 인터페이스
    - 팩토리
4. 그래프 출력
    - 좌표계를 미리 가지고 있음.
5. 삼각형 넓이 계산
6. 사각형 넓이 계산
    - 직사각형만 계산
    
## 예외
- 좌표 파싱이 안될 경우
- 직선, 삼각형, 사각형이 아닌 경우