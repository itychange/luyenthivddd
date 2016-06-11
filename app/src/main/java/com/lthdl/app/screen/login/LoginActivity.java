package com.lthdl.app.screen.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.lthdl.app.BaseActivity;
import com.lthdl.app.R;
import com.lthdl.app.common.Utils;
import com.lthdl.app.global.Global;
import com.lthdl.app.model.User;
import com.lthdl.app.network.ApiClient;
import com.lthdl.app.network.ApiInterface;
import com.lthdl.app.screen.core.CoreActivity;
import com.lthdl.app.screen.home.event.OnEventOpenHomeActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    URL img = null;
    String profile_image;
    @Bind(R.id.btnLoginFb)
    Button btnLoginFb;
    private List<User> userList = new ArrayList<User>();
    private CallbackManager callbackManager;
    SharedPreferences pre=null;
    @Bind(R.id.login_button)
    LoginButton login_button;

    protected void init() {
        SharedPreferences pre=this.getSharedPreferences ("login",MODE_PRIVATE);
        boolean bchk=pre.getBoolean("check", false);
        if(bchk==true){
            EventBus.getDefault().post(new OnEventOpenHomeActivity());
            finish();
        }
        this.login_button = ((LoginButton) findViewById(R.id.login_button));
        this.login_button.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday", "user_friends","user_location"));
        this.login_button.registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onCancel() {
                Utils.showToast(LoginActivity.this.getApplicationContext(), "Cancel", false);
                AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
                if (localAccessToken != null) {
//                    Log.e("TAG", "user Token:" + localAccessToken.getToken());

                }
            }

            @Override
            public void onError(FacebookException paramFacebookException) {
                Utils.showToast(LoginActivity.this.getApplicationContext(), paramFacebookException.toString(), true);
            }

            public void onSuccess(LoginResult paramLoginResult) {
                Log.e("TAG", "user Token:" + paramLoginResult.getAccessToken().getToken());
                if (Global.USER == null)
                Global.USER = new User();
                Global.USER.social_token = paramLoginResult.getAccessToken().getToken();

                GraphRequest request = GraphRequest.newMeRequest(paramLoginResult.getAccessToken(),
                      new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                final JSONObject jsonObject = response.getJSONObject();
                                Log.e("Loca",jsonObject.toString());

                                try {
                                    User user= new User();
                                    img = new URL("http://graph.facebook.com/"+jsonObject.getString("id")+"/picture?type=normal");
                                    user.setSocial_id(jsonObject.getString("id"));
                                    user.setName(jsonObject.getString("name"));
                                    user.setSocial_token(Global.USER.social_token);
                                    user.setThumbnail(img.toString());
                                    user.setEmail(jsonObject.getString("email"));
                                    user.setGender(jsonObject.getString("gender"));
                                    user.setBirthday("11-1-1999");
                                    user.setLocation("HaNoi");
                                    user.setTienThuong(0);
                                    user.setRole(0);
                                    user.setSoDu(0);

                                    SharedPreferences pre=getSharedPreferences("login", MODE_PRIVATE);
                                    SharedPreferences.Editor edit=pre.edit();
                                    edit.putBoolean("check", true);
                                    edit.commit();


                                    Login(user);

                                } catch(JSONException ex) {
                                    ex.printStackTrace();
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday,location"); // Parámetros que pedimos a facebook
                request.setParameters(parameters);
                request.executeAsync();
                EventBus.getDefault().post(new OnEventOpenHomeActivity());
            }
        });
        this.btnLoginFb.setOnClickListener(new OnClickListener() {
            public void onClick(View paramView) {
                LoginActivity.this.login_button.performClick();
            }
        });

    }


    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.callbackManager.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        int i = 0;
        super.onCreate(paramBundle);
        this.callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.login_activity);
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.lthdl.app",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (NameNotFoundException notFoundEx) {
            notFoundEx.printStackTrace();
            return;
        } catch (NoSuchAlgorithmException noSuchAlgorithmEx) {
            noSuchAlgorithmEx.printStackTrace();
        }
    }

    @Subscribe
    public void onEvent(OnEventOpenHomeActivity paramOnEventOpenHomeActivity) {

        OnEventOpenHomeActivity onEventOpenHomeActivity = new OnEventOpenHomeActivity();

//        Toast.makeText(LoginActivity.this,"Login",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, CoreActivity.class));
        finish();
    }

    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }
    private void Login(User user){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<User> call= apiService.login(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(LoginActivity.this, LoginActivity.this.getResources().getString(R.string.login_success), Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "onFailure", Toast.LENGTH_LONG).show();

            }
        });
    }
}