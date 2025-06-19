export const TemperatureRow = ({data, fieldGetter, value}) => {
    return (
        <tr>
            <th scope="row" className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white border-b border-gray-200 dark:border-gray-700">{value}</th>
            {data.map((item, id) => (
                <td className={`${id % 2 !== 0 ? "bg-gray-50 dark:bg-gray-800" : "dark:bg-gray-700"} px-6 py-4 border-b border-gray-200 dark:border-gray-700`} key={id}>
                    {fieldGetter(item)}&deg;C
                </td>
            ))}
        </tr>
    );
}