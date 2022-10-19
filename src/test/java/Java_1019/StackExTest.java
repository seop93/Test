package Java_1019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackExTest {
    @Test
    void pushTest(){
    StackEx stackex = new StackEx();
    stackex.push(10);
    stackex.push(20);

    int[] arr = stackex.getArr();
    //10,20

        Assertions.assertEquals(10,arr[0]);
        Assertions.assertEquals(20,arr[1]);

        stackex.push(30);
        Assertions.assertEquals(30,stackex.pop());

    }
}