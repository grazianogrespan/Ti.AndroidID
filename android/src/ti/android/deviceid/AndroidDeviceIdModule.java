package ti.android.deviceid;

import java.util.UUID;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings;


@Kroll.module(name="AndroidDeviceId", id="ti.android.deviceid")
public class AndroidDeviceIdModule extends KrollModule
{

	private static String uniqueID = null;
	private static final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";

	public AndroidDeviceIdModule()
	{
		super();
	}


	@Kroll.method
	public String getAndroidID()
	{
	    String androidId = Settings.Secure.getString(TiApplication.getInstance().getApplicationContext().getContentResolver(),Settings.Secure.ANDROID_ID); 
		return androidId;
	}

	
	@Kroll.method
	public synchronized String getAndroidUUID() {
	    if (uniqueID == null) {
	        SharedPreferences sharedPrefs = TiApplication.getInstance().getApplicationContext().getSharedPreferences(
	                PREF_UNIQUE_ID, Context.MODE_PRIVATE);
	        uniqueID = sharedPrefs.getString(PREF_UNIQUE_ID, null);
	        if (uniqueID == null) {
	            uniqueID = UUID.randomUUID().toString();
	            Editor editor = sharedPrefs.edit();
	            editor.putString(PREF_UNIQUE_ID, uniqueID);
	            editor.commit();
	        }
	    }
	    return uniqueID;
	}
}

