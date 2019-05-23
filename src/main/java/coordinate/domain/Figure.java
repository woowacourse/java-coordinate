package coordinate.domain;

import java.util.Set;

public abstract class Figure implements LengthCalculable {
    public abstract String getClassName();
    public abstract Set<Point> getPoints();
}
