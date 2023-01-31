package fi.team5.covid19helper.learnMore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fi.team5.covid19helper.R;

/**
 * Represents one of the age activities, in this case 45 to 64
 */
public class Age45to64 extends AppCompatActivity {

    /**
     * @param savedInstanceState
     * Shows the XML file activity_age45to64
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age45to64);
    }
}