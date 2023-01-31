package fi.team5.covid19helper.learnMore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import fi.team5.covid19helper.R;

/**
 * Represents one of the age activities, in this case 18 to 44
 */
public class Age18to44 extends AppCompatActivity {
    /**
     * @param savedInstanceState
     * Shows the XML file activity_age18to44
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age18to44);
    }
}