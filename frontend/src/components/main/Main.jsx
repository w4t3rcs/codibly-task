import {WeatherInput} from "./WeatherInput.jsx";
import * as React from "react";

export const Main = () => {
    return (
        <main className="bg-white dark:bg-gray-800 dark:text-white shadow-md rounded-lg m-7 transition-all">
            <WeatherInput />
        </main>
    )
}