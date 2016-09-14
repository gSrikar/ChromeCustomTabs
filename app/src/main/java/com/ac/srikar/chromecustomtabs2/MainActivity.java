package com.ac.srikar.chromecustomtabs2;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize UI elements
        urlEditText = (EditText) findViewById(R.id.urlEditText);
    }

    public void launchButton(View view) {
        // Store the url entered by the user as a string
        String openUrl = urlEditText.getText().toString().trim();

        // Use a CustomTabsIntent.Builder to configure CustomTabsIntent.
        CustomTabsIntent.Builder customTabsIntentBuilder = new CustomTabsIntent.Builder();
        // Set the toolbar color
        customTabsIntentBuilder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        // Shows Website name in the toolbar if true
        customTabsIntentBuilder.setShowTitle(true);
        // Animate when launch the custom tabs is launched
        customTabsIntentBuilder.setStartAnimations(this, R.anim.slide_in_right, R.anim.slide_out_left);
        // Animate when launch the custom tabs is exited
        customTabsIntentBuilder.setExitAnimations(this, R.anim.push_down_in, R.anim.push_down_out);
        // Call CustomTabsIntent.Builder.build() to create a CustomTabsIntent
        CustomTabsIntent customTabsIntent = customTabsIntentBuilder.build();
        // Launch the desired Url with CustomTabsIntent.launchUrl()
        customTabsIntent.launchUrl(this, Uri.parse(openUrl));
    }
}
