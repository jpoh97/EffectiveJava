package com.effective.java.yanaga.effectivejava;

import com.google.common.base.MoreObjects;

import java.util.*;

import static com.google.common.base.Preconditions.*;

public class PhoneNumber implements Formattable, Comparable<PhoneNumber> {

    private static final PhoneNumber COMMON = new PhoneNumber(123, 1234);

    private final int areaCode;
    private final int number;

    private int hashCode;

    public PhoneNumber(int areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
        this.hashCode = Objects.hash(this.areaCode, this.number);
    }

    public static PhoneNumber of(int areaCode, int number) {
        checkArgument(areaCode > 100); // IllegalArgumentException
        checkArgument(number > 1000);
        if (123 == areaCode && 1234 == number) {
            return COMMON;
        }
        return new PhoneNumber(areaCode, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof PhoneNumber) {
            PhoneNumber other = (PhoneNumber) obj;
            return Objects.equals(this.areaCode, other.areaCode) && this.number == other.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Objects.hash(this.areaCode, this.number);
        }
        this.hashCode = result;
        return result;
    }

    // This way is used for debug output, in production use Formattable
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("areaCode", areaCode)
                .add("number", number)
                .toString();
    }

    // U can localize the output, this way is used in production
    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d-%d", areaCode, number);
    }

    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt((PhoneNumber p) -> p.areaCode)
            .thenComparingInt(p -> p.number);

    @Override
    public int compareTo(PhoneNumber o) {
        return COMPARATOR.compare(this, o);
        /*return ComparisonChain.start()
                .compare(this.areaCode, o.areaCode)
                .compare(this.number, o.number)
                .result();*/
    }

    public static void main(String[] args) {
        System.out.println(PhoneNumber.of(123, 1234));
        System.out.println(String.format("%s", PhoneNumber.of(123, 1234)));
        PhoneNumber p1 = PhoneNumber.of(123, 1234);
        PhoneNumber p2 = PhoneNumber.of(124, 1234);
        PhoneNumber p3 = PhoneNumber.of(124, 1235);
        ArrayList<PhoneNumber> list = new ArrayList<>();
        list.add(p1);
        list.add(p3);
        list.add(p2);
        Collections.sort(list);
        list.sort(COMPARATOR);
        System.out.println(list);
    }
}
