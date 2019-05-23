package coordinate.domain.Figure;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;

public class FigureFactory {
    public static Figure getInstance(PointGroup pointGroup) {
        if (pointGroup.size() == 2)  {
            return new Line(pointGroup);
        }
        if (pointGroup.size() == 3)  {
            return new Triangle(pointGroup);
        }
        if (pointGroup.size() == 4)  {
            return new Rectangle(pointGroup);
        }
        return null;
    }

}
