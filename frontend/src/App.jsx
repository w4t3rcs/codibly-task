import {WeatherForecastTable} from "./components/WeatherForecastTable.jsx";
import {useState} from "react";
import {WeatherInput} from "./components/WeatherInput.jsx";

export const App = () => {
    const [tableData, setTableData] = useState({
        dailyWeatherForecasts: [
            {
                date: "2025-06-18",
                weatherCode: "0",
                maxTemperature: 23.6,
                minTemperature: 14.3,
                estimatedEnergy: 6.73255
            },
            {
                date: "2025-06-19",
                weatherCode: "56",
                maxTemperature: 20.6,
                minTemperature: 12.2,
                estimatedEnergy: 7.552883333333334
            },
            {
                date: "2025-06-20",
                weatherCode: "61",
                maxTemperature: 22.1,
                minTemperature: 10.5,
                estimatedEnergy: 7.7198416666666665
            },
            {
                date: "2025-06-21",
                weatherCode: "2",
                maxTemperature: 26.0,
                minTemperature: 10.6,
                estimatedEnergy: 7.617220833333333
            },
            {
                date: "2025-06-22",
                weatherCode: "80",
                maxTemperature: 32.9,
                minTemperature: 15.8,
                estimatedEnergy: 7.522894444444444
            },
            {
                date: "2025-06-23",
                weatherCode: "80",
                maxTemperature: 28.5,
                minTemperature: 16.8,
                estimatedEnergy: 6.163811111111111
            },
            {
                date: "2025-06-24",
                weatherCode: "96",
                maxTemperature: 22.4,
                minTemperature: 15.3,
                estimatedEnergy: 4.194943055555555
            }
        ]
    });

    return (
        <>
            <WeatherInput />
            <WeatherForecastTable data={tableData.dailyWeatherForecasts} />
        </>
    )
}
