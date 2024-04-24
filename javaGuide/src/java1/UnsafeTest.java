package java1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
//        Unsafe.getUnsafe();
        Unsafe singleUnsafe = reflectGetUnsafe();
    }
}
