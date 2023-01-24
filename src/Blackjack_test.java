
import javax.management.DescriptorKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import jp.ac.uryukyu.ie.e225740.*;
import Blackjack.java;

class Blackjack_test {
    @Test
    void actTest() {
        player testDealer = new dealer();
        ArrayList<> deck = new ArrayList<>();
        deck.add(1);
        deck.add(10);
        testDealer.act(deck);
        boolean actual = testDealer.isBrackJack();
        boolean expect = true;

        assertEquals(expect, actual);
    }    
}
    
}
