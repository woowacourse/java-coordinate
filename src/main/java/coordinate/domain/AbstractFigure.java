package coordinate.domain;

public abstract class AbstractFigure implements Figure {
    private Points points;

    AbstractFigure(final Points points) {
        this.points = points;
        validateSize();
    }

    private void validateSize() {
        if (size() != points.size()) {
            throw new IllegalArgumentException(getName() + "는 " + points + " 개의 점이 필요합니다.");
        }
    }

    @Override
    public Points getPoints() {
        return points;
    }
}

