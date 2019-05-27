package coordinate.model;

class Delta {
    private final int deltaValue;

    Delta(int delta) {
        this.deltaValue = delta;
    }

    int getDeltaValue() {
        return deltaValue;
    }

    Delta sum(Delta delta) {
        return new Delta(this.deltaValue + delta.deltaValue);
    }

    double multiply(Delta delta) {
        return (double) this.deltaValue * delta.deltaValue;
    }
}