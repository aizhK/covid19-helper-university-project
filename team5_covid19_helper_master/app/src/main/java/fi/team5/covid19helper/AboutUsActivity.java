package fi.team5.covid19helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Represents the About Us page of the app
 */
public class AboutUsActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     * Shows the XML file activity_about_us
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
}