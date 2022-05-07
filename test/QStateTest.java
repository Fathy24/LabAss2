import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

import static org.junit.Assert.*;

public class QStateTest {
    @Nested
    class EdgeCoverage{
        QState mainobj;

        @BeforeEach
        public void setup(){
            mainobj = new QState();
        }

        @Test
        public void ECtest1(){
            String[] res = mainobj.input('a');
            assertEquals("NORMAL",res[0]);
            assertEquals("DATE",res[1]);
            assertEquals("2000-1-1",res[2]);
            assertEquals("0:0",res[3]);
        }

        @Test
        public void ECtest2(){
            mainobj.input('a');
            String[] res = mainobj.input('a');
            assertEquals("NORMAL",res[0]);
            assertEquals("DATE",res[1]);
            assertEquals("2000-1-1",res[2]);
            assertEquals("0:0",res[3]);
        }
        @Test
        public void ECtest3(){
            mainobj.input('a');
            mainobj.input('a');
            String[] res = mainobj.input('c');
            assertEquals("UPDATE",res[0]);
            assertEquals("min",res[1]);
            assertEquals("2000-1-1",res[2]);
            assertEquals("0:0",res[3]);
        }
    }

    @Nested
    class ADUP{
        QState mainobj;

        @BeforeEach
        public void setup(){
            mainobj = new QState();
        }
        @Test
        public void ADUPTest1(){
            String[] res = mainobj.input('c');
            assertEquals("UPDATE",res[0]);
            assertEquals("min",res[1]);
            assertEquals("2000-1-1",res[2]);
            assertEquals("0:0",res[3]);
        }
        @Test
        public void ADUPTest2(){
            mainobj.input('c');
            String[] res = mainobj.input('b');
            assertEquals("UPDATE",res[0]);
            assertEquals("min",res[1]);
            assertEquals("2000-1-1",res[2]);
            assertEquals("0:1",res[3]);
        }
        @Test
        public void ADUPTest3(){
            mainobj.input('c');
            mainobj.input('b');
            String[] res = mainobj.input('b');
            assertEquals("UPDATE",res[0]);
            assertEquals("min",res[1]);
            assertEquals("2000-1-1",res[2]);
            assertEquals("0:2",res[3]);
        }

    }
}