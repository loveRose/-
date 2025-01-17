package com.lvyerose.helpcommunity.im;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lvyerose.helpcommunity.R;
import com.lvyerose.helpcommunity.base.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Locale;

import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Conversation;

@EActivity(R.layout.activity_conversation)
public class ConversationActivity extends BaseActivity {


    /**
     * 目标 Id
     */
    private String mTargetId;

    /**
     * 刚刚创建完讨论组后获得讨论组的id 为targetIds，需要根据 为targetIds 获取 targetId
     */
    private String mTargetIds;

    /**
     * 会话类型
     */
    private Conversation.ConversationType mConversationType;


    @ViewById(R.id.id_title_tv)
    TextView title;

    @AfterViews
    void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConversationActivity.this.finish();
            }
        });

        Intent intent = getIntent();
        getIntentDate(intent);
    }


            /**
             * 展示如何从 Intent 中得到 融云会话页面传递的 Uri
             */
            private void getIntentDate(Intent intent) {

                mTargetId = intent.getData().getQueryParameter("targetId");
                mTargetIds = intent.getData().getQueryParameter("targetIds");
                title.setText(intent.getData().getQueryParameter("title"));
                //intent.getData().getLastPathSegment();//获得当前会话类型
                mConversationType = Conversation.ConversationType.valueOf(intent.getData().getLastPathSegment().toUpperCase(Locale.getDefault()));
                enterFragment(mConversationType, mTargetId);
            }

            /**
             * 加载会话页面 ConversationFragment
             *
             * @param mConversationType 会话类型
             * @param mTargetId 目标 Id
             */
            private void enterFragment(Conversation.ConversationType mConversationType, String mTargetId) {

                ConversationFragment fragment = (ConversationFragment) getSupportFragmentManager().findFragmentById(R.id.conversation);

                Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                        .appendPath("conversation").appendPath(mConversationType.getName().toLowerCase())
                        .appendQueryParameter("targetId", mTargetId).build();
                fragment.setUri(uri);

            }

        }
