import {MapContainer, TileLayer} from "react-leaflet";
import 'leaflet/dist/leaflet.css'
import 'leaflet-defaulticon-compatibility/dist/leaflet-defaulticon-compatibility.css'
import "leaflet-defaulticon-compatibility";
import {LocationMarker} from "./LocationMarker.jsx";

export const LeafletMap = ({inputLongitude, inputLongitudeHandler, inputLatitude, inputLatitudeHandler}) => {
    return (
        <section className="w-full h-64">
            <MapContainer
                center={[inputLatitude, inputLongitude]}
                zoom={13}
                scrollWheelZoom={true}
                className="w-full h-full rounded shadow"
            >
                <TileLayer
                    attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                />
                <LocationMarker inputLatitude={inputLatitude} inputLongitudeHandler={inputLongitudeHandler} inputLongitude={inputLongitude} inputLatitudeHandler={inputLatitudeHandler} />
            </MapContainer>
        </section>
    );
}