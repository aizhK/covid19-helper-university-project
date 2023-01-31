package fi.team5.covid19helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import fi.team5.covid19helper.countryClasses.CountryFragment;
import fi.team5.covid19helper.learnMore.LearnMoreActivity;

/**
 * Main Screen with two buttons and settings menu
 */
public class MainActivity extends AppCompatActivity {

    /**
     * finds two buttons onCreate and these buttons take to new activities
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ButtonListeners
        Button learnMoreBtn = findViewById(R.id.learnMoreBtn);
        learnMoreBtn.setOnClickListener(v -> {
            Log.d("Testing", "Learn button clicked");

            Intent learnMore = new Intent(getApplicationContext(), LearnMoreActivity.class);
            startActivity(learnMore);
        });

        Button currentStatusBtn = findViewById(R.id.currentStatusBtn);
        currentStatusBtn.setOnClickListener(v -> {
            Log.d("Testing", "current status button clicked");

            Intent currentStatus = new Intent(getApplicationContext(), CurrentStatusActivity.class);
            startActivity(currentStatus);
        });



    }

    /**
     * this inflates a menu coming down when pressing three dots on screen
     * @param menu
     * @return
     */
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

    /**
     * checks which item selected and then changes activity based on that
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
           Intent settings = new Intent(this, SettingsActivity.class);
           startActivity(settings);
            return true;
        } else if (id == R.id.about_us) {
            Intent aboutUs = new Intent(this, AboutUsActivity.class);
            startActivity(aboutUs);
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}