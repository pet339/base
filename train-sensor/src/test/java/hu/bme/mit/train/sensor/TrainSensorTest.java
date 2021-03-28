package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainController controller;
    private TrainUser user;
    private TrainSensorImpl sensor;

    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void Test_TrainSensorAbsolute_False() {
        int[] data = {0,1,250,499,500};
        for(int i = 0; i < data.length; i++){
            sensor.overrideSpeedLimit(data[i]);
        }
        verify(user, times(data.length)).setAlarmState(false);
        verify(user, times(0)).setAlarmState(true);
    }

    @Test
    public void Test_TrainSensorAbsolute_True() {
        int[] data = {-1,501};
        for(int i = 0; i < data.length; i++){
            sensor.overrideSpeedLimit(data[i]);
        }
        verify(user, times(data.length)).setAlarmState(true);
        verify(user, times(0)).setAlarmState(false);
    }

    @Test
    public void Test_TrainSensorRelative_False() {
        int[] data = {50,51};
        when(controller.getReferenceSpeed()).thenReturn(100);
        for(int i = 0; i < data.length; i++){
            sensor.overrideSpeedLimit(data[i]);
        }
        verify(user, times(data.length)).setAlarmState(false);
    }

    @Test
    public void Test_TrainSensorRelative_True() {
        int data = 49;
        when(controller.getReferenceSpeed()).thenReturn(100);
        sensor.overrideSpeedLimit(data);
        verify(user, times(1)).setAlarmState(true);
    }
}
