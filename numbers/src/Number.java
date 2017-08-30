import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Number {
    public static final int OPERATION_FIRST = 0;
    public static final int OPERATION_LAST = 1;
    public static final int OPERATION_LEFT = 2;
    public static final int OPERATION_RIGHT = 3;
    public static final int[] OPERATIONS = {OPERATION_FIRST, OPERATION_LAST, OPERATION_LEFT, OPERATION_RIGHT};

    int[] values;

    public Number() {
        this.values = new int[4];
        this.values[0] = 0;
        this.values[1] = 0;
        this.values[2] = 0;
        this.values[3] = 0;
    }

    @Override
    public String toString() {
        return Integer.toString(values[0])
                + Integer.toString(values[1])
                + Integer.toString(values[2])
                + Integer.toString(values[3]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        return Arrays.equals(values, number.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    public Number(int value) {
        this.values = new int[4];
        this.values[3] = value % 10;
        this.values[2] = value % 100 / 10;
        this.values[1] = value % 1000 / 100;
        this.values[0] = value / 1000;
    }

    public Number(int[] values) {
        this.values = values;
    }

    public Number next(int operation) throws Exception {
        if (!this.canNext(operation)) {
            throw new Exception("cannot next");
        }
        int[] values = new int[4];
        if (operation == OPERATION_FIRST) {
            System.arraycopy(this.values, 0, values, 0, this.values.length);
            values[0]++;
        }
        if (operation == OPERATION_LAST) {
            System.arraycopy(this.values, 0, values, 0, this.values.length);
            values[3]--;
        }
        if (operation == OPERATION_LEFT) {
            values[0] = this.values[1];
            values[1] = this.values[2];
            values[2] = this.values[3];
            values[3] = this.values[0];
        }
        if (operation == OPERATION_RIGHT) {
            values[0] = this.values[3];
            values[1] = this.values[0];
            values[2] = this.values[1];
            values[3] = this.values[2];
        }
        return new Number(values);
    }

    public List<Number> nextAll() throws Exception {
        List<Number> numbers = new LinkedList();
        for(int operation : OPERATIONS) {
            if (canNext(operation)) {
                numbers.add(next(operation));
            }
        }
        return numbers;
    }

    public boolean canNext(int operation) {
        return operation == OPERATION_FIRST && values[0] < 9 || operation == OPERATION_LAST && values[3] > 1
                || operation == OPERATION_LEFT || operation == OPERATION_RIGHT;
    }


}
