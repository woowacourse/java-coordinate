package coordinate.domain;

import coordinate.domain.generator.LinesGenerator;

public abstract class RealFigure extends AbstractFigure {
    private Lines lines;

    RealFigure(final Points points, final LinesGenerator linesGenerator) {
        super(points);
        this.lines = linesGenerator.generate();
    }

    Lines getLines() {
        return lines;
    }
}
