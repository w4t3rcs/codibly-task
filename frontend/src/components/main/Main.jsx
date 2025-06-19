import {WeatherInput} from "./WeatherInput.jsx";
import * as React from "react";

export const Main = () => {
    return (
        <div className="bg-gray-200 dark:bg-gray-900 h-screen p-7 transition-all">
            <main className="bg-white dark:bg-gray-800 dark:text-white shadow-md rounded-lg">
                <WeatherInput />
            </main>
        </div>
    )
}