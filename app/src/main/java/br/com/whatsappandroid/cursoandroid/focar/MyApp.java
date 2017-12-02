package br.com.whatsappandroid.cursoandroid.focar;

import android.app.Application;
import android.content.Context;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class MyApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate(){
        mContext = getApplicationContext();
        super.onCreate();

    }

    public static Context getContext(){
        return mContext;
    }


}
