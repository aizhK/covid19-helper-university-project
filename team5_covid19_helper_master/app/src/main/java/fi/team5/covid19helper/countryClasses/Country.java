package fi.team5.covid19helper.countryClasses;

import android.os.Parcel;
import android.os.Parcelable;

//Reference from https://github.com/abdulazizahwan/TrackCovid19

/**
 * Country class that will be used to return all data for the tracker.
 */

public class Country implements Parcelable {


    String countryName, totalCases, todayCases, totalDeath, todayDeaths, totalRecovered,
            totalActive, totalCritical, flag;
    Long updatedTime;

    /**
     * Parameters for a country, based on what is available from the API JSONArray
     * @param updatedTime
     * @param countryName
     * @param totalCases
     * @param todayCases
     * @param totalDeath
     * @param todayDeaths
     * @param totalRecovered
     * @param totalActive
     * @param totalCritical
     * @param flag
     */
    public Country(Long updatedTime, String countryName, String totalCases, String todayCases, String totalDeath,
                   String todayDeaths, String totalRecovered, String totalActive,
                   String totalCritical, String flag) {
        this.updatedTime = updatedTime;
        this.countryName = countryName;
        this.totalCases = totalCases;
        this.todayCases = todayCases;
        this.totalDeath = totalDeath;
        this.todayDeaths = todayDeaths;
        this.totalRecovered = totalRecovered;
        this.totalActive = totalActive;
        this.totalCritical = totalCritical;
        this.flag = flag;
    }

    /**
     * Returning values
     * @return
     */
    public Long getUpdatedTime() {
        return updatedTime;
    }
    public String getCountryName() {
        return countryName;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public String getTotalDeath() {
        return totalDeath;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public String getTotalActive() {
        return totalActive;
    }

    public String getTotalCritical() {
        return totalCritical;
    }

    public String getFlag() {
        return flag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Writing to a parcel
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.updatedTime);
        dest.writeString(this.countryName);
        dest.writeString(this.totalCases);
        dest.writeString(this.todayCases);
        dest.writeString(this.totalDeath);
        dest.writeString(this.todayDeaths);
        dest.writeString(this.totalRecovered);
        dest.writeString(this.totalActive);
        dest.writeString(this.totalCritical);
        dest.writeString(this.flag);
    }

    /**
     * Reading from parcel
     * @param in
     */
    protected Country(Parcel in) {
        this.updatedTime = in.readLong();
        this.countryName = in.readString();
        this.totalCases = in.readString();
        this.todayCases = in.readString();
        this.totalDeath = in.readString();
        this.todayDeaths = in.readString();
        this.totalRecovered = in.readString();
        this.totalActive = in.readString();
        this.totalCritical = in.readString();
        this.flag = in.readString();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}