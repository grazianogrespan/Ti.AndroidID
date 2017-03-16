# Ti.AndroidID
## Overview

This module gives you the possibility to uniquely identify Android devices.

Before using this module I recommend you to read this article :

##### [Android Best Practices for Unique Identifiers](https://developer.android.com/training/articles/user-data-ids.html)

## Usage

Here's an example of how to use the module.

```javascript
// Load module
var AndroidID  = require('ti.android.deviceid');

Ti.API.error( " ANDROID_ID is : " + AndroidID.getAndroidID());
Ti.API.error( " ANDROID_UUID is : " + AndroidID.getAndroidUUID());

```

## Methods

- _getAndroidID()_ : returns a string that represents ANDROID_ID of device.

It's a 64-bit number (as a hex string) that is randomly generated when the user first sets up the device and should remain constant for the lifetime of the user's device. The value may change if a factory reset is performed on the device.

- _getAndroidUUID()_ : returns a string that represents UUID of device.

The UUID is generated randomly and then stored to device internal memory when method ```getAndroidUUID()``` is executed. UUID is not maintained if the user reinstalls the app.
