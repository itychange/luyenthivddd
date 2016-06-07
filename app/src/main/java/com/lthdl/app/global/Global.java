package com.lthdl.app.global;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.lthdl.app.model.User;

public class Global {
    public static Point SCREEN;
    public static User USER;

    public static boolean isLoggedIn() {
        boolean sessionExpired = true;
        if (USER == null) {
            USER = new User();
            USER.social_token = "";
        }
        AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
        if ((localAccessToken != null) /*|| (!TextUtils.isEmpty(localAccessToken.getToken()))*/) {
            Log.e("AccessToken ==", "AccessToken ==" + localAccessToken.toString());
            Log.e("Profile ==", "Profile ==" + Profile.getCurrentProfile());
            sessionExpired = localAccessToken.isExpired();
        }
        //return false;
//    } else {
//        //USER.fbToken = localAccessToken.getToken();
//        //return true;
//    }
//      return !TextUtils.isEmpty(USER.fbToken);
//    USER.fbToken = localAccessToken.getToken();
        return !(sessionExpired);
    }
}