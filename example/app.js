var win = Ti.UI.createWindow();
var AndroidID  = require('ti.android.deviceid');

Ti.API.error( " ANDROID_ID is : " + AndroidID.getAndroidID());
Ti.API.error( " ANDROID_UUID is : " + AndroidID.getAndroidUUID());

win.open();



