package JVM;

import java.util.ArrayList;
import java.util.List;

public class HeapOOm {
    static class OOMObject {
    }

    public static void main(String[] args) {
        System.gc();
    }

}
