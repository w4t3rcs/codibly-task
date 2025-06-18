import {Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import {WeatherIcon} from "./WeatherIcon.jsx";

export const WeatherForecastTable = ({data}) => {
    if (data === undefined || data === null) return <></>;
    return (
        <TableContainer>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell></TableCell>
                        {data.map((item, id) => (
                            <TableCell key={id}>
                                <strong>
                                    {item.date.split("-").reverse()
                                        .join("/")
                                        .toUpperCase()}
                                </strong>
                            </TableCell>
                        ))}
                    </TableRow>
                </TableHead>
                <TableBody>
                    <TableRow>
                        <TableCell>Ikona</TableCell>
                        {data.map((item, id) => (
                            <TableCell key={id}>
                                <WeatherIcon code={item.weatherCode} />
                            </TableCell>
                        ))}
                    </TableRow>
                    <TableRow>
                        <TableCell>Temperatura Minimalna</TableCell>
                        {data.map((item, id) => (
                            <TableCell key={id}>
                                {item.minTemperature}
                            </TableCell>
                        ))}
                    </TableRow>
                    <TableRow>
                        <TableCell>Temperatura Maksymalna</TableCell>
                        {data.map((item, id) => (
                            <TableCell key={id}>
                                {item.maxTemperature}
                            </TableCell>
                        ))}
                    </TableRow>
                    <TableRow>
                        <TableCell>Energia</TableCell>
                        {data.map((item, id) => (
                            <TableCell key={id}>
                                {Math.round(item.estimatedEnergy * 1000) / 1000}
                            </TableCell>
                        ))}
                    </TableRow>
                </TableBody>
            </Table>
        </TableContainer>
    )
}