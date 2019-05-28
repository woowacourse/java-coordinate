package coordinate.domain;

import java.util.List;

public abstract class AbstractShape implements Shape{
    AbstractShape(List<Point> points) {
        if(points.size() != size()){
            throw new IllegalArgumentException("해당 도형을 생성하기 위한 좌표의 개수가 올바르지 않습니다. 다시 입력해 주세요");
        }
    }
}
