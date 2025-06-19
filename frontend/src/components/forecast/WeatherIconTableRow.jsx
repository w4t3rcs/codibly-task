import {WeatherIcon} from "./WeatherIcon.jsx";

export const WeatherIconTableRow = ({data}) => {
    return (
        <tr className="border-b border-gray-200 dark:border-gray-700">
            <th scope="row"></th>
            {data.map((item, id) => (
                <td className={`${id % 2 !== 0 ? "bg-gray-50 dark:bg-gray-800" : "dark:bg-gray-700"} px-6 py-4 border-b border-gray-200 dark:border-gray-700`} key={id}>
                    <WeatherIcon code={item.weatherCode} />
                </td>
            ))}
        </tr>
    );
}