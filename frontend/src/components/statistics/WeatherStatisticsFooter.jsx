export const WeatherStatisticsFooter = ({data}) => {
    if (data === undefined || data === null) return <></>;
    return (
        <footer className="text-white p-5 rounded-3xl shadow-xl m-3 bg-blue-600">
            <p className="text-2xl">Statystyki z poprzedniego tygodnia</p>
            <p className="text-gray-300">Temperatury skrajne: {data.minTemperature}&deg;C - {data.maxTemperature}&deg;C</p>
            <p className="text-gray-300">Średnie ciśnienie: {Math.round(data.averageSurfacePressure * 100)/100} hPa</p>
            <p className="text-gray-300">Średni czas ekspozycji na słońce: {Math.round(data.averageSunshineDuration * 100)/100} s</p>
            <p className="text-gray-300">Podsumowanie tygodnia: {data.precipitationStatus === "WITH_PRECIPITATION" ? "Z opadami" : "Bez opadów"}</p>
        </footer>
    )
}