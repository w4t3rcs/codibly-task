export const DateTableRow = ({data}) => {
    return (
        <tr>
            <th scope="col" className="px-6 py-3" />
            {data.map((item, id) => (
                <th scope="col" className={id % 2 === 0 ? "px-6 py-3 dark:bg-gray-700" : "px-6 py-3 bg-gray-50 dark:bg-gray-800"} key={id}>
                    <strong>
                        {item.date.split("-").reverse()
                            .join("/")
                            .toUpperCase()}
                    </strong>
                </th>
            ))}
        </tr>
    )
}