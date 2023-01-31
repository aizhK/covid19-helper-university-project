package fi.team5.covid19helper.learnMore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;

import fi.team5.covid19helper.R;

/**
 * Represents one of the age activities, in this case the under 18
 */

public class Under18 extends AppCompatActivity {

    ExpandableListView expandableTextView;

    /**
     * @param savedInstanceState
     * Shows the XML file activity_under18
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under18);
    }
}