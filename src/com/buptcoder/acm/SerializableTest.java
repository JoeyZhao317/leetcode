package com.buptcoder.acm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class SerializableTest {
    private void immutableAttack() {
        try {
            Date start;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(new StringList());
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            start = (Date)in.readObject();
            //modify date
            start.setYear(85);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public final class StringList implements Serializable {
        private transient int size = 0;
        private Date start;
        private Date end;

        private static final long serialVersionUID = 1L;

        private void writeObject(ObjectOutputStream s) throws IOException {
            s.defaultWriteObject();
            s.writeInt(size);
        }

        private void readObject(ObjectInputStream s) throws IOException,
                ClassNotFoundException {
            s.defaultReadObject();
            start = new Date(start.getTime());
            end = new Date(end.getTime());
            if (start.compareTo(end) > 0) {
                throw new InvalidObjectException(start + "after" + end);
            }
        }
    }
    
    static class Singleton implements Serializable {
        private static Singleton  INSTANCE = new Singleton();
        private static final long serialVersionUID = -2030568621921394039L;
        private Singleton(){};
        public static Singleton getInstance() {
            return INSTANCE;
        }
        
        private Object readResolve() {
            return INSTANCE;
        }
    }
}
