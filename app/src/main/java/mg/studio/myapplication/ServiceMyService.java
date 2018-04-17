package mg.studio.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class ServiceMyService extends Service implements Runnable {
    protected static final String LOG_TAG = "SERVICE";
    //In our case, we don`t need this constructor
    //public MyService() {}

    private Handler handler = new Handler();
    private int timerCounter = 0;



    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "Service onCreate - Service running");
        handler.post(this);
        Log.d(LOG_TAG, "Handler was run");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Service onDestroy - Service Destroyed");
        handler.removeCallbacks(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void run() {
        timerCounter+=1;
        Log.d(LOG_TAG, "Counter Service is "+ timerCounter );
        handler.postDelayed(this, 1000);
    }
}
