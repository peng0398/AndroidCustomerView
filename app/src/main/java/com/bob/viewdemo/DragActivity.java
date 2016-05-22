package com.bob.viewdemo;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author: bob
 * Date: 16-5-22.
 */
public class DragActivity extends BaseActivity {

    @BindView(R.id.dv)
    DragView dv;

    @OnClick(R.id.dv)
    void clickDv() {
        dv.smoothScrollTo(30, 0);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_drag;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
