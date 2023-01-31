package fi.team5.covid19helper.learnMore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fi.team5.covid19helper.R;

/**
 * Represents one of the age activities, in this case the risk group
 */
public class RiskGroup extends AppCompatActivity {

    /**
     * @param savedInstanceState
     * Shows the XML file activity_risk_group
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_group);
    }
}