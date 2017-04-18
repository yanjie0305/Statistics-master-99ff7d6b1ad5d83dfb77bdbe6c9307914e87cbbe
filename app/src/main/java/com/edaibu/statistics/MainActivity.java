package com.edaibu.statistics;

import android.os.Bundle;

import com.edaibu.statistics.bean.LoginResp;

public class MainActivity extends BaseActivity {
    /**
     * 登录返回的数据
     */
    private LoginResp loginResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginResp = getIntent().getParcelableExtra(EXTRA_DATA);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new LineFragment()).commit();
        }

    }



}
