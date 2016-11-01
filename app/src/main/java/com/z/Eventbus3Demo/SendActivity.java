package com.z.Eventbus3Demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SendActivity extends AppCompatActivity {

    private TextView mTvTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        mTvTextView = (TextView) findViewById(R.id.tv);

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 如果是stick方式,那么先发送后注册也是可以收到的
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveSticky(MyEvent event) {
        mTvTextView.setText(event.getMsg());
    }

    public void send1(View view) {
        EventBus.getDefault().post(new MyEvent(EventBusType.TYPE, "我发送了消息"));
    }

    public void send2(View view) {
        EventBus.getDefault().post(new MyEvent(EventBusType.TYPE1, "我发送了消息1")
                .setObj("这是一个字符串的对象,实际上"));
    }
}

