// To parse the JSON, install jackson-module-kotlin and do:
//
//   val weatherAPI = WeatherAPI.fromJson(jsonString)

package app.olauncher.data

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.module.kotlin.*

val mapper = jacksonObjectMapper().apply {
    propertyNamingStrategy = PropertyNamingStrategy.LOWER_CAMEL_CASE
    setSerializationInclusion(JsonInclude.Include.NON_NULL)
}

data class WeatherAPI (
    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val location: Location,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val current: Current
) {
    fun toJson() = mapper.writeValueAsString(this)!!

    companion object {
        fun fromJson(json: String) = mapper.readValue<WeatherAPI>(json)
    }
}

data class Current (
    @get:JsonProperty("last_updated_epoch", required=true)@field:JsonProperty("last_updated_epoch", required=true)
    val lastUpdatedEpoch: Long,

    @get:JsonProperty("last_updated", required=true)@field:JsonProperty("last_updated", required=true)
    val lastUpdated: String,

    @get:JsonProperty("temp_c", required=true)@field:JsonProperty("temp_c", required=true)
    val tempC: Long,

    @get:JsonProperty("temp_f", required=true)@field:JsonProperty("temp_f", required=true)
    val tempF: Double,

    @get:JsonProperty("is_day", required=true)@field:JsonProperty("is_day", required=true)
    val isDay: Long,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val condition: Condition,

    @get:JsonProperty("wind_mph", required=true)@field:JsonProperty("wind_mph", required=true)
    val windMph: Double,

    @get:JsonProperty("wind_kph", required=true)@field:JsonProperty("wind_kph", required=true)
    val windKph: Double,

    @get:JsonProperty("wind_degree", required=true)@field:JsonProperty("wind_degree", required=true)
    val windDegree: Long,

    @get:JsonProperty("wind_dir", required=true)@field:JsonProperty("wind_dir", required=true)
    val windDir: String,

    @get:JsonProperty("pressure_mb", required=true)@field:JsonProperty("pressure_mb", required=true)
    val pressureMB: Long,

    @get:JsonProperty("pressure_in", required=true)@field:JsonProperty("pressure_in", required=true)
    val pressureIn: Double,

    @get:JsonProperty("precip_mm", required=true)@field:JsonProperty("precip_mm", required=true)
    val precipMm: Double,

    @get:JsonProperty("precip_in", required=true)@field:JsonProperty("precip_in", required=true)
    val precipIn: Double,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val humidity: Long,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val cloud: Long,

    @get:JsonProperty("feelslike_c", required=true)@field:JsonProperty("feelslike_c", required=true)
    val feelslikeC: Long,

    @get:JsonProperty("feelslike_f", required=true)@field:JsonProperty("feelslike_f", required=true)
    val feelslikeF: Double,

    @get:JsonProperty("vis_km", required=true)@field:JsonProperty("vis_km", required=true)
    val visKM: Long,

    @get:JsonProperty("vis_miles", required=true)@field:JsonProperty("vis_miles", required=true)
    val visMiles: Long,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val uv: Long,

    @get:JsonProperty("gust_mph", required=true)@field:JsonProperty("gust_mph", required=true)
    val gustMph: Double,

    @get:JsonProperty("gust_kph", required=true)@field:JsonProperty("gust_kph", required=true)
    val gustKph: Double
)

data class Condition (
    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val text: String,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val icon: String,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val code: Long
)

data class Location (
    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val name: String,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val region: String,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val country: String,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val lat: Double,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val lon: Double,

    @get:JsonProperty("tz_id", required=true)@field:JsonProperty("tz_id", required=true)
    val tzID: String,

    @get:JsonProperty("localtime_epoch", required=true)@field:JsonProperty("localtime_epoch", required=true)
    val localtimeEpoch: Long,

    @get:JsonProperty(required=true)@field:JsonProperty(required=true)
    val localtime: String
)
