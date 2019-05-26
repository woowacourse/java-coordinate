package coordinate.domain.generator;

import coordinate.domain.Lines;

@FunctionalInterface
public interface LinesGenerator {
    Lines generate();
}
