package distributed;

import java.util.UUID;

public class UuidTest {

    public static UUID getUUid(){
        return UUID.randomUUID();
    }

    public static void main(String[] args) {
        System.out.println(UuidTest.getUUid());
    }


}
