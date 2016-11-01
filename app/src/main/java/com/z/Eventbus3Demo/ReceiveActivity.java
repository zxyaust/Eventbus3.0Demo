package com.z.Eventbus3Demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ReceiveActivity extends AppCompatActivity {

    private TextView mTvTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTextView = (TextView) findViewById(R.id.tv);


        EventBus.getDefault().register(this);
    }

    /**
     * 这个方法必须是public否则报错
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void handleMsg(MyEvent event) {
        if (event.getType() == EventBusType.TYPE) {
            mTvTextView.setText(event.getMsg());
        } else {
            mTvTextView.setText(event.getMsg() + event.getObj().toString());
        }
    }

    public void skip(View view) {
        EventBus.getDefault().postSticky(new MyEvent(EventBusType.TYPE2,"这个是还没有注册的时候就发送了"));

        startActivity(new Intent(this, SendActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
