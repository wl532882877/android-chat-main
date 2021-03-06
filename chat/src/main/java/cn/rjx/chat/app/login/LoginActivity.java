/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.app.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import cn.rjx.chat.R;
import cn.rjx.chat.app.AppService;
import cn.rjx.chat.app.login.model.LoginResult;
import cn.rjx.chat.app.main.MainActivity;
import cn.rjx.chat.kit.ChatManagerHolder;
import cn.rjx.chat.kit.Config;
import cn.rjx.chat.kit.WfcBaseActivity;


/**
 * use {@link SMSLoginActivity} instead
 */
@Deprecated
public class LoginActivity extends WfcBaseActivity {
    @BindView(R.id.loginButton)
    Button loginButton;
    @BindView(R.id.accountEditText)
    EditText accountEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @Override
    protected int contentLayout() {
        return R.layout.login_activity_account;
    }

    @Override
    protected boolean showHomeMenuItem() {
        return false;
    }

    @OnTextChanged(value = R.id.accountEditText, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void inputAccount(Editable editable) {
        if (!TextUtils.isEmpty(passwordEditText.getText()) && !TextUtils.isEmpty(editable)) {
            loginButton.setEnabled(true);
        } else {
            loginButton.setEnabled(false);
        }
    }

    @OnTextChanged(value = R.id.passwordEditText, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void inputPassword(Editable editable) {
        if (!TextUtils.isEmpty(accountEditText.getText()) && !TextUtils.isEmpty(editable)) {
            loginButton.setEnabled(true);
        } else {
            loginButton.setEnabled(false);
        }
    }


    @OnClick(R.id.loginButton)
    void login() {

        String account = accountEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        MaterialDialog dialog = new MaterialDialog.Builder(this)
            .content("?????????...")
            .progress(true, 10)
            .cancelable(false)
            .build();
        dialog.show();

        AppService.Instance().namePwdLogin(account, password, new AppService.LoginCallback() {
            @Override
            public void onUiSuccess(LoginResult loginResult) {
                if (isFinishing()) {
                    return;
                }

                //????????????token???clientId?????????????????????????????????getClientId?????????clientId??????????????????clientId??????token?????????connect???????????????????????????????????????clientId????????????token????????????????????????
                ChatManagerHolder.gChatManager.connect(loginResult.getUserId(), loginResult.getToken());
                SharedPreferences sp = getSharedPreferences(Config.SP_CONFIG_FILE_NAME, Context.MODE_PRIVATE);
                sp.edit()
                    .putString("id", loginResult.getUserId())
                    .putString("token", loginResult.getToken())
                    .apply();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                dialog.dismiss();
                finish();
            }

            @Override
            public void onUiFailure(int code, String msg) {
                if (isFinishing()) {
                    return;
                }
                dialog.dismiss();

                Toast.makeText(LoginActivity.this, "??????????????????:" + code + " " + msg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
