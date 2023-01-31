package fi.team5.covid19helper.countryClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import fi.team5.covid19helper.R;

//Reference from https://github.com/abdulazizahwan/TrackCovid19

/**
 * CountryAdapter is an adapter for the RecyclerView, it has a filter for searching inside RecyclerView
 * It sets the text for country total cases and country name
 * also sets a flag visible
 */
public class CountyAdapter extends RecyclerView.Adapter<CountyAdapter.ViewHolder> implements Filterable {

    private List<Country> covidCountries;
    private List<Country> covidCountriesFull;
    private Context context;

    /**
     * Takes parameters List and context
     * @param covidCountries
     * @param context
     */
    public CountyAdapter(List<Country> covidCountries, Context context) {
        this.covidCountries = covidCountries;
        this.context = context;
        covidCountriesFull = new ArrayList<>(covidCountries);
    }


    /**
     * inflating item_list_country to parent
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public CountyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_country,
                parent, false);


        return new ViewHolder(view);
    }

    /**
     * Setting text based on position in List
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CountyAdapter.ViewHolder holder, int position) {
        Country country = covidCountries.get(position);
        holder.tvTotalCases.setText(country.getTotalCases());
        holder.tvCountryName.setText(country.getCountryName());

        Glide.with(context)
                .load(country.getFlag())
                .apply(new RequestOptions().override(240, 160))
                .into(holder.imgCountryFlag);
    }

    /**
     * getting total countries
     * @return
     */
    @Override
    public int getItemCount() {
        return covidCountries.size();
    }

    /**
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTotalCases, tvCountryName;
        ImageView imgCountryFlag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTotalCases = itemView.findViewById(R.id.tvTotalCases);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
            imgCountryFlag = itemView.findViewById(R.id.imgCountryFlag);
        }
    }

    /**
     * returns filter
     * @return
     */
    @Override
    public Filter getFilter() {
        return covidCountriesFilter;
    }

    /**
     * Filters RecyclerView based on what you type into the search bar.
     * changes all to lowercase so it doesnt matter how you write the name.
     */
    private Filter covidCountriesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Country> filteredCountry = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredCountry.addAll(covidCountriesFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Country itemCovidCountry : covidCountriesFull) {
                    if (itemCovidCountry.getCountryName().toLowerCase().contains(filterPattern)) {
                        filteredCountry.add(itemCovidCountry);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredCountry;
            return results;
        }

        /**
         * shows you only the countries that contains what has been searched
         * @param constraint
         * @param results
         */
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            covidCountries.clear();
            covidCountries.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
