package coord.model;

import java.util.*;

public class Combinations implements Iterator<List<Integer>> {
    private final int n;
    private final int k;
    private int current;
    private Combinations subCombination;

    private Combinations(int n, int k, int base) {
        if (n < 1 || k < 1 || base < 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.k = k;
        this.current = base;
        subCombination = (k == 1) ? null : new Combinations(n, k - 1, base + 1);
    }

    public Combinations(int n, int k) {
        this(n, k, 0);
    }

    public boolean hasNext() {
        return current < n - k + 1;
    }

    public List<Integer> next() {
        if (k == 1) {
            return Collections.unmodifiableList(new ArrayList<>(Arrays.asList(current++)));
        }
        List<Integer> result = new ArrayList<>(Arrays.asList(current));
        result.addAll(subCombination.next());
        if (!subCombination.hasNext()) {
            subCombination = this.hasNext() ? new Combinations(n, k - 1, ++current + 1) : null;
        }
        return Collections.unmodifiableList(result);
    }
}