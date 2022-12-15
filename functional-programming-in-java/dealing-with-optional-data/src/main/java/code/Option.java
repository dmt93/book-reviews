package code;

import java.util.function.Supplier;
import lombok.ToString;

public abstract class Option<A> {

  private static Option none = new None();

  public abstract A getOrThrow();

  public abstract A getOrElse(A defaultValue);

  public abstract A getOrElse (Supplier<A> defaultValue);

  public static <A> Option<A> some(A a) {
    return new Some<A>(a);
  }

  public static <A> Option<A> none() {
    return none;
  }

  @ToString
  private static class None<A> extends Option<A> {

    private None() {
    }

    @Override
    public A getOrThrow() {
      throw new IllegalStateException("Called on None!");
    }

    @Override
    public A getOrElse(A defaultValue) {
      return defaultValue;
    }

    @Override
    public A getOrElse(Supplier<A> defaultValue) {
      return defaultValue.get();
    }
  }

  @ToString
  private static class Some<A> extends Option<A> {

    private final A value;

    public Some(A value) {
      this.value = value;
    }

    @Override
    public A getOrThrow() {
      return null;
    }

    @Override
    public A getOrElse(A defaultValue) {
      return value;
    }

    @Override
    public A getOrElse(Supplier<A> defaultValue) {
      return value;
    }
  }

}
