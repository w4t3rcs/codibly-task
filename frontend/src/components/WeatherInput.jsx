import {Button, Grid, TextField} from '@mui/material';
import {useState} from "react";
import axios from "axios";
import {WeatherForecastTable} from "./WeatherForecastTable.jsx";

function handleLongitudeInput(handler) {
    return (e) => handler(e.target.value);
}

function handleLatitudeInput(handler) {
    return (e) => handler(e.target.value);
}

function handleSubmit(handler, endpoint, longitude, latitude) {
    axios.get("http://localhost:8080/api/v1/weather/" + endpoint, {
        params: {
            longitude: longitude,
            latitude: latitude,
        }
    }).then(response => {handler(response.data)});
}

export const WeatherInput = () => {
    const [longitude, setLongitude] = useState(0)
    const [latitude, setLatitude] = useState(0)
    const [forecastData, setForecastData] = useState({})
    const [statisticsData, setStatisticsData] = useState({})

    return (
        <Grid container margin={3} spacing={3}>
            <TextField onChange={handleLongitudeInput(setLongitude)} type="number" label="Longitude" variant="outlined" value={longitude} />
            <TextField onChange={handleLatitudeInput(setLatitude)} type="number" label="Latitude" variant="outlined" value={latitude} />
            <WeatherForecastTable data={forecastData.dailyWeatherForecasts} />
            <Button onClick={() => handleSubmit(setForecastData, "forecast", longitude, latitude)}>Forecast</Button>
            <Button onClick={() => handleSubmit(setStatisticsData, "statistics", longitude, latitude)}>Statistics</Button>
        </Grid>
    )
}