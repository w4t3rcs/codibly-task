import SunnyIcon from '@mui/icons-material/Sunny';
import CloudIcon from '@mui/icons-material/Cloud';
import FoggyIcon from '@mui/icons-material/Foggy';
import WaterDropIcon from '@mui/icons-material/WaterDrop';
import WaterIcon from '@mui/icons-material/Water';
import AcUnitIcon from '@mui/icons-material/AcUnit';
import SevereColdIcon from '@mui/icons-material/SevereCold';
import FloodIcon from '@mui/icons-material/Flood';
import CycloneIcon from '@mui/icons-material/Cyclone';
import ThunderstormIcon from '@mui/icons-material/Thunderstorm';
import {useEffect, useState} from "react";

export const WeatherIcon = ({code}) => {
    const [icon, setIcon] = useState(null)
    useEffect(() => {
        if (code === "0") {
            setIcon(<SunnyIcon color="warning" />);
        } else if (code === "1" || code === "2" || code === "3") {
            setIcon(<CloudIcon color="action" />);
        } else if (code === "45" || code === "48") {
            setIcon(<FoggyIcon color="action" />);
        } else if (code === "51" || code === "53" || code === "55") {
            setIcon(<WaterDropIcon color="info" />);
        } else if (code === "56" || code === "57") {
            setIcon(<WaterDropIcon color="primary" />);
        } else if (code === "61" || code === "63" || code === "65") {
            setIcon(<WaterIcon color="info" />);
        } else if (code === "66" || code === "67") {
            setIcon(<WaterIcon color="primary" />);
        } else if (code === "71" || code === "73" || code === "75") {
            setIcon(<AcUnitIcon color="info" />);
        } else if (code === "77") {
            setIcon(<SevereColdIcon color="info" />);
        } else if (code === "80" || code === "81" || code === "82") {
            setIcon(<FloodIcon color="info" />);
        } else if (code === "85" || code === "86") {
            setIcon(<CycloneIcon color="info" />);
        } else if (code === "95 *") {
            setIcon(<ThunderstormIcon color="warning" />);
        } else if (code === "96" || code === "99 *") {
            setIcon(<ThunderstormIcon color="error" />);
        }
    }, [code])

    return icon;
}