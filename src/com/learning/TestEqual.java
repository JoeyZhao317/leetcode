package com.learning;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestEqual {

    private String value = null;

    public TestEqual(String v) {
        value = v;
        Date start = new Date();
        Date end = new Date();
        ImmuableTest p = new ImmuableTest(start, end);
        end.setYear(2013);
    }

    public boolean equals(TestEqual o) {
        if (o == this) {
            return true;
        }
        if (o instanceof TestEqual) {
            TestEqual test = (TestEqual) o;
            return value.equals(test.value);
        }

        return false;
    }

    static public void main(String args[]) {
        List list = new ArrayList();
        TestEqual test1 = new TestEqual("object");
        TestEqual test2 = new TestEqual("object");
        TestEqual test3 = new TestEqual("object");
        Object test4 = new TestEqual("object");

        list.add(test1);
        // System.out.println(list.contains(test2));
        // System.out.println(test2.equals(test3));
        // System.out.println(test3.equals(test4));
        int value = 5;
        System.out.println("value is " + (value < 5 ? 10.5 : 9));

        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);
 
    }

    final class ImmuableTest {
        private final Date start;
        private final Date end;

        public ImmuableTest(Date start, Date end) {
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());
        }

        public Date getStart() {
            return new Date(start.getTime());
        }

        public Date getEnd() {
            return end;
        }
    }
}
