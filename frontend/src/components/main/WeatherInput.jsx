import {useEffect, useState} from "react";
import axios from "axios";
import {WeatherForecastTable} from "../forecast/WeatherForecastTable.jsx";
import {WeatherStatisticsFooter} from "../statistics/WeatherStatisticsFooter.jsx";
import {LeafletMap} from "../map/LeafletMap.jsx";
import {Squircle} from 'ldrs/react'
import 'ldrs/react/Squircle.css'

function handleSubmit(handler, endpoint, longitude, latitude) {
    if (longitude === undefined || latitude === undefined) return;
    axios.get("https://w4t3rcs-codibly-task-backend.onrender.com/api/v1/weather/" + endpoint, {
        params: {
            longitude: longitude,
            latitude: latitude,
        }
    }).then(response => {
        let data = response.data;
        handler(data);
        console.log(data);
    });
}

function handleChange(handler) {
    return (e) => handler(e.target.value);
}

export const WeatherInput = () => {
    const [longitude, setLongitude] = useState(23);
    const [latitude, setLatitude] = useState(50);
    const [forecastData, setForecastData] = useState();
    const [statisticsData, setStatisticsData] = useState();
    useEffect(() => {
        handleSubmit(setForecastData, "forecast", longitude, latitude);
        handleSubmit(setStatisticsData, "statistics", longitude, latitude);
    }, [longitude, latitude])

    return (
        <div className="flex flex-col items-center gap-6 p-4">
            <LeafletMap inputLatitude={latitude} inputLatitudeHandler={setLatitude} inputLongitude={longitude} inputLongitudeHandler={setLongitude} />
            <div className="flex flex-col sm:flex-row gap-4 w-full max-w-xl">
                <div className="flex flex-col w-full">
                    <label className="mb-1 font-medium text-sm">Longitude</label>
                    <input
                        type="number"
                        onChange={handleChange(setLongitude)}
                        className="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                        placeholder="Enter longitude"
                        value={longitude}
                    />
                </div>
                <div className="flex flex-col w-full">
                    <label className="mb-1 font-medium text-sm">Latitude</label>
                    <input
                        type="number"
                        onChange={handleChange(setLatitude)}
                        className="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
                        placeholder="Enter latitude"
                        value={latitude}
                    />
                </div>
            </div>
            {forecastData === undefined || forecastData === null
                ? <div className="flex items-center justify-center">
                    <Squircle
                        size="37"
                        stroke="5"
                        strokeLength="0.15"
                        bgOpacity="0.1"
                        speed="0.9"
                        color="#2b7fff"
                    />
                </div>
                : <WeatherForecastTable data={forecastData.dailyWeatherForecasts} />}
            {statisticsData === undefined || statisticsData === null
                ? <div className="flex items-center justify-center">
                    <Squircle
                        size="37"
                        stroke="5"
                        strokeLength="0.15"
                        bgOpacity="0.1"
                        speed="0.9"
                        color="#2b7fff"
                    />
                </div>
                : <WeatherStatisticsFooter data={statisticsData} />}
        </div>
    )
}