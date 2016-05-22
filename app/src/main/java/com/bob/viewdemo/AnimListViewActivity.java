package com.bob.viewdemo;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Author: bob
 * Date: 16-5-22.
 */
public class AnimListViewActivity extends BaseActivity {


    SparseArray<String> stringSparseArray;

    @BindView(R.id.lv_container)
    ListView lv_container;

    @Override
    public int initLayout() {
        return R.layout.activity_animlist;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        stringSparseArray = new SparseArray<>();

        for (int i = 0; i < 100; i++) {
            stringSparseArray.append(i, "haha");
        }

        lv_container.setAdapter(new SimpleAdapter());
    }

    class SimpleAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return stringSparseArray.size();
        }

        @Override
        public Object getItem(int i) {
            return stringSparseArray.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(AnimListViewActivity.this, R.layout.item, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) view.findViewById(R.id.tv_item);
                view.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) view.getTag();
            viewHolder.textView.setText(stringSparseArray.get(i));
            return view;
        }
    }

    static class ViewHolder {
        TextView textView;
    }
}
