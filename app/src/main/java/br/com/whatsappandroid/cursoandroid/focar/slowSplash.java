package br.com.whatsappandroid.cursoandroid.focar;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by gabrielestrela on 02/11/17.
 */

public class slowSplash extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(1000);
    }
}
