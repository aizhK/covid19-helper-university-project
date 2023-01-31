package fi.team5.covid19helper.learnMore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fi.team5.covid19helper.R;

/**
 * Represents one of the age activities, in this case 65 and above
 */

public class Age65AndAbove extends AppCompatActivity {

    /**
     * @param savedInstanceState
     * Shows the XML file activity_age65_and_above
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age65_and_above);
    }
}