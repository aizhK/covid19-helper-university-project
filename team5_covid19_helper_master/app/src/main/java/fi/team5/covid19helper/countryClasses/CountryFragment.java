package fi.team5.covid19helper.countryClasses;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fi.team5.covid19helper.R;

/**
 * This fragment shows the recyclerView with all the countries from JSONArray
 */
//Reference from https://github.com/abdulazizahwan/TrackCovid19
public class CountryFragment extends Fragment {

    RecyclerView rvCountry;
    CountyAdapter countyAdapter;


    private static final String TAG = CountryFragment.class.getSimpleName();
    List<Country> covidCountries;

    /**
     * The activity_country_selection will be Inflated onCreateView. The container for ViewGroup is a RelativeLayout in this case.
     * also adds a divider between the countries
     * also by using method getDataFromServer() it will get data from API URL
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_country_selection, container, false);

        setHasOptionsMenu(true);

        //call view
        rvCountry = root.findViewById(R.id.rvCountry);
        rvCountry.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvCountry.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.line_divider));
        rvCountry.addItemDecoration(dividerItemDecoration);

        covidCountries = new ArrayList<>();

        //call Volley Method
        getDataFromServer();


        return root;
    }

    /**
     * Showing recyclerView and adding onItemClickListener to it
     */
    private void showRecyclerView() {
        countyAdapter = new CountyAdapter(covidCountries, getActivity());
        rvCountry.setAdapter(countyAdapter);

        ItemClickSupport.addTo(rvCountry).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedCountry(covidCountries.get(position));
            }
        });
    }

    /**
     * Showing a selected country
     * @param country
     */
    private void showSelectedCountry(Country country) {
        Intent countryDetailActivity = new Intent(getActivity(), CountryDetailsActivity.class);
        countryDetailActivity.putExtra("EXTRA_COVID", country);
        startActivity(countryDetailActivity);
    }

    /**
     * Getting data from URL address
     * by using a StringRequest we can request strings/JSONObjects from the JSONArray stored in the API
     */
    private void getDataFromServer() {
        String url = "https://disease.sh/v3/covid-19/countries?sort=cases";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Log.e(TAG, "onResponse: " + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);

                            JSONObject countryInfo = data.getJSONObject("countryInfo");

                            covidCountries.add(new Country(
                                    data.getLong("updated"), data.getString("country"), data.getString("cases"),
                                    data.getString("todayCases"), data.getString("deaths"),
                                    data.getString("todayDeaths"), data.getString("recovered"),
                                    data.getString("active"), data.getString("critical"), countryInfo.getString("flag")
                            ));
                        }

                        getActivity().setTitle(jsonArray.length() + " Countries");

                        showRecyclerView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onResponse: " + error);
                    }
                });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }

    /**
     * onCreateOptionsMenu inflates the search_menu and gives it a onQueryTextListener
     * @param menu
     * @param inflater
     */
    //Inflate search menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(getActivity());
        searchView.setQueryHint("Search...");
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (countyAdapter != null) {
                    countyAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
        searchItem.setActionView(searchView);
        super.onCreateOptionsMenu(menu, inflater);
    }
}