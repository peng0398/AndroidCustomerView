package com.bob.viewdemo;

import android.content.Intent;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    Intent intent;

    @BindView(R.id.btn_dragview)
    Button btn_dragview;

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.btn_dragview)
    void clickDrag() {
        intent = new Intent(MainActivity.this, DragActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_animationlist)
    void clickAnimList(){
        intent = new Intent(MainActivity.this, AnimListViewActivity.class);
        startActivity(intent);
    }
}
