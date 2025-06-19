import {DateTableRow} from "./DateTableRow.jsx";
import {WeatherIconTableRow} from "./WeatherIconTableRow.jsx";
import {TemperatureRow} from "./TemperatureRow.jsx";
import {EnergyTableRow} from "./EnergyTableRow.jsx";

export const WeatherForecastTable = ({data}) => {
    if (data === undefined || data === null) return <></>;
    return (
        <div className="relative flex flex-col w-full h-full overflow-x-auto border border-gray-100 dark:border-gray-600 rounded-xl">
            <table className="w-full text-sm min-w-max text-left rtl:text-right text-gray-500 dark:text-gray-400">
                <thead className="text-xs text-gray-700 dark:text-gray-400">
                    <DateTableRow data={data}/>
                </thead>
                <tbody>
                    <WeatherIconTableRow data={data}/>
                    <TemperatureRow data={data} value="Temperatura Minimalna" fieldGetter={(i) => i.minTemperature}/>
                    <TemperatureRow data={data} value="Temperatura Maksymalna" fieldGetter={(i) => i.maxTemperature}/>
                    <EnergyTableRow data={data}/>
                </tbody>
            </table>
        </div>
    )
}