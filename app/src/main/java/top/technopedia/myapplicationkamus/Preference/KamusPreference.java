package top.technopedia.myapplicationkamus.Preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import top.technopedia.myapplicationkamus.R;


public class KamusPreference {

    private SharedPreferences prefs;
    private Context context;

    public KamusPreference(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.context = context;
    }

    public void setFirstRun(Boolean input){

        SharedPreferences.Editor editor = prefs.edit();
        String key = context.getResources().getString(R.string.kamus_pref);
        editor.putBoolean(key,input);
        editor.apply();
    }

    public Boolean getFirstRun(){
        String key = context.getResources().getString(R.string.kamus_pref);
        return prefs.getBoolean(key, true);
    }

}
