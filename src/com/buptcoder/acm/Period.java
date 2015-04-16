package com.buptcoder.acm;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {

    private static final long serialVersionUID = 5667129444303574326L;
    private final Date start;
    private final Date end;

    Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 5623061052458323877L;
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            start = p.start;
            end = p.end;
        }

        private Object readResolve() {
            return new Period(start, end);
        }
    }
}
