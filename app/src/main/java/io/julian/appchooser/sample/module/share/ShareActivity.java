package io.julian.appchooser.sample.module.share;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import io.julian.appchooser.AppChooser;
import io.julian.appchooser.sample.R;

public class ShareActivity extends AppCompatActivity {

    private ComponentName[] mComponentNames = new ComponentName[]{
            new ComponentName("nutstore.android", "nutstore.android.SendToNutstoreIndex"),
            new ComponentName("nutstore.android.debug", "nutstore.android.SendToNutstoreIndex")
    };

    public static void start(Context context) {
        Intent starter = new Intent(context, ShareActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onShareClick(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_text);
        if (editText != null) {
            CharSequence shareContent = editText.getText();
            AppChooser.from(this).text(shareContent.toString()).excluded(mComponentNames).load();
        }
    }
}
