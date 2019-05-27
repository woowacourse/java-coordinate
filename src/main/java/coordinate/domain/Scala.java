package coordinate.domain;

import java.util.Objects;

public class Scala {
    private static final int MAX_SCALA_NUMBER = 24;
    private static final int MIN_SCALA_NUMBER = 0;
    private final int scala;

    public Scala(final int scala) {
        if (scala > MAX_SCALA_NUMBER || scala < MIN_SCALA_NUMBER) {
            throw new IllegalArgumentException("0이상 24이하의 숫자를 입력해 주셔야 합니다.");
        }
        this.scala = scala;
    }


    public int subScala(Scala anotherScala) {
        return this.scala - anotherScala.scala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scala scala1 = (Scala) o;
        return scala == scala1.scala;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scala);
    }


}
