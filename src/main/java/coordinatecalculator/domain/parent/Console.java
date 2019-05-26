package coordinatecalculator.domain.parent;

public interface Console {
    String LINE_RESULT_MESSAGE = "두 점 사이 거리는 ";
    String TRIANGLE_RESULT_MESSAGE = "사각형 넓이는 ";
    String RECTANGLE_RESULT_MESSAGE = "사각형 넓이는 ";
    String INVALID_CHECK_MESSAGE = "직사각형이 아닙니다. 다시 입력해 주세요";
    String INVALID_TRIANGLE_MESSAGE = "세 점이 일직선 상에 위치할 수는 없습니다. 다시 입력해주세요.";

    String makeResult();
}
