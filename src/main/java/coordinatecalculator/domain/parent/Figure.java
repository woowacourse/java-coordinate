package coordinatecalculator.domain.parent;

import coordinatecalculator.domain.Points;

public interface Figure {
    // Figure 인터페이스를 상속하는 클래스라면 당연히 결과를 계산해야 하기 때문에
    // 추상클래스가 아니라 인터페이스에 넣어야 됨
    double calculateResult();
    Points getPoints();
    String getResultType();
    String getName();
}
