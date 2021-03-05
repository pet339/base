package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachographImpl {
    Table<String, String, Integer> tachographTable =  HashBasedTable.create();


    public TrainTachographImpl(String currentTime, String joystickPosition, Integer referenceSpeed) {
        tachographTable.put(currentTime, joystickPosition, referenceSpeed);
    }
}
