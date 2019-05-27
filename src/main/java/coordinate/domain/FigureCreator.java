package coordinate.domain;

@FunctionalInterface
public interface FigureCreator {
    Figure create(Vertices vertices);
}
