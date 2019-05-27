package coordinate.domain;

import java.util.Objects;

public class Scala {
    private static final int MAX_SCALA_NUMBER = 24;
    private static final int MIN_SCALA_NUMBER = 0;
    private final int scala;

    public Scala(final String scala) {
        if (scala.contains(" ")) {
            throw new IllegalArgumentException("공백이 있으면 안됩니다..");
        }

        if (isNotInteger(scala)) {
            throw new IllegalArgumentException("문자열만은 안됩니다..");
        }

        int scala2 = Integer.parseInt(scala);
        if (scala2 > MAX_SCALA_NUMBER || scala2 < MIN_SCALA_NUMBER) {
            throw new IllegalArgumentException("0이상 24이하의 숫자를 입력해 주셔야 합니다.");
        }
        this.scala = scala2;
    }


    public boolean isNotInteger(String scala) {
        try {
            Integer.parseInt(scala);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
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
