package ru.tinkoff.edu.compare;

import java.util.Objects;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CompareUtils {

  // Note: по умолчанию в record'ах equals и hashCode уже переопределены
  public record ClassWithProperEquals(long id, String data)
      implements Comparable<ClassWithProperEquals> {

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }

      if (this == obj) {
        return true;
      }

      if (!(obj instanceof ClassWithProperEquals other)) {
        return false;
      }
      return other.id == this.id && Objects.equals(other.data, this.data);
    }

    @Override
    public int hashCode() {
      return 31 * Long.hashCode(id) + Objects.hashCode(data);
    }

    @Override
    public int compareTo(ClassWithProperEquals o) {
      final var idComparisonResult = Long.compare(id, o.id);
      return switch (idComparisonResult) {
        case 0 -> CharSequence.compare(data, o.data);
        default -> idComparisonResult;
      };
    }
  }

  // Note: по умолчанию в record'ах equals и hashCode уже переопределены
  public record ClassWithImproperEquals(long id, String data) {

    private static final int MULT_COEF = 1_000;

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (this == obj) {
        return true;
      }

      if (!(obj instanceof ClassWithImproperEquals other)) {
        return false;
      }
      //noinspection StringEquality
      return other.id == this.id && other.data == this.data;
    }

    @Override
    public int hashCode() {
      return (int) (Math.random() * MULT_COEF);
    }

  }

}
