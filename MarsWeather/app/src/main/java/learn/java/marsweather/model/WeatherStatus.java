package learn.java.marsweather.model;

import com.google.gson.annotations.SerializedName;

public class WeatherStatus {

    private String season;
    private Air air;

    public WeatherStatus() {
    }

    public WeatherStatus(String season, Air air) {
        this.season = season;
        this.air = air;
    }

    //Firulagem
    public WeatherStatus(String season, float average, float maximum, float minimum) {
        this.season = season;
        Temperature temperature = new Temperature(average, maximum, minimum);
        this.air = new Air(temperature);
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }


    public class Air {

        private Temperature temperature;

        public Air(Temperature temperature) {
            this.temperature = temperature;
        }

        public Temperature getTemperature() {
            return temperature;
        }

        public void setTemperature(Temperature temperature) {
            this.temperature = temperature;
        }
    }

    public class Temperature {

        private float average;
        private float minimum;
        private float maximum;

        public Temperature(float average, float minimum, float maximum) {
            this.average = average;
            this.minimum = minimum;
            this.maximum = maximum;
        }

        public float getAverage() {
            return average;
        }

        public void setAverage(float average) {
            this.average = average;
        }

        public float getMinimum() {
            return minimum;
        }

        public void setMinimum(float minimum) {
            this.minimum = minimum;
        }

        public float getMaximum() {
            return maximum;
        }

        public void setMaximum(float maximum) {
            this.maximum = maximum;
        }
    }
}
