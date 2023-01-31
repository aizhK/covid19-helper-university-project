package fi.team5.covid19helper.countryClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import fi.team5.covid19helper.R;

//Reference from https://github.com/abdulazizahwan/TrackCovid19

/**
 * CountryDetailsActivity finds all textViews and sets texts to them based on what is given from the Country class
 */

public class CountryDetailsActivity extends AppCompatActivity {

    TextView tvDetailCountryName, tvDetailTotalCases, tvDetailTodayCases, tvDetailTotalDeaths,
            tvDetailTodayDeaths, tvDetailTotalRecovered, tvDetailTotalActive, tvDetailTotalCritical, tvDetailTimeUpdated;

    /**
     * When created it will show activity_country_details with all TextViews set to correct text
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        tvDetailCountryName = findViewById(R.id.tvDetailCountryName);
        tvDetailTotalCases = findViewById(R.id.tvDetailTotalCases);
        tvDetailTodayCases = findViewById(R.id.tvDetailTodayCases);
        tvDetailTotalDeaths = findViewById(R.id.tvDetailTotalDeaths);
        tvDetailTodayDeaths = findViewById(R.id.tvDetailTodayDeaths);
        tvDetailTotalRecovered = findViewById(R.id.tvDetailTotalRecovered);
        tvDetailTotalActive = findViewById(R.id.tvDetailTotalActive);
        tvDetailTotalCritical = findViewById(R.id.tvDetailTotalCritical);
        tvDetailTimeUpdated = findViewById(R.id.tvDetailTimeUpdated);
        tvDetailTimeUpdated = findViewById(R.id.tvDetailTimeUpdated);

        Country country = getIntent().getParcelableExtra("EXTRA_COVID");

        tvDetailCountryName.setText(country.getCountryName());
        tvDetailTotalCases.setText(country.getTotalCases());
        tvDetailTodayCases.setText(country.getTodayCases());
        tvDetailTotalDeaths.setText(country.getTotalDeath());
        tvDetailTodayDeaths.setText(country.getTodayDeaths());
        tvDetailTotalRecovered.setText(country.getTotalRecovered());
        tvDetailTotalActive.setText(country.getTotalActive());
        tvDetailTotalCritical.setText(country.getTotalCritical());


        tvDetailTimeUpdated.setText("Last Updated"+"\n"+ getDate(country.getUpdatedTime()));


    }

    /**
     * GetDate formats the milliSeconds to a readable date and time
     * @param milliSecond
     * @return
     */
    //formatting time from milliseconds to a readable date and time.
    private String getDate(long milliSecond){
        // in the form of: Mon, 23 Mar 2020 02:01:04 PM
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss aaa");

        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(milliSecond);
        return formatter.format(calendar.getTime());
    }

}