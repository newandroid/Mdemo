package css.com.designpattern.chapter3;

/**
 * Created by css on 2018-03-24.
 */

public class Car {
    private String name;
    private int mile;

    private Car(Builder builder) {
        name = builder.name;
        mile = builder.mile;
    }

    @Override
    public String toString() {
        return "CarFactory{" +
                "name='" + name + '\'' +
                ", mile=" + mile +
                '}';
    }

    public static class Builder {
        private String name;
        private int mile;

        public Builder buildName(String name) {
            this.name = name;
            return this;
        }

        public Builder buildMile(int mile) {
            this.mile = mile;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
