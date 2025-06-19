import {Marker, useMapEvents} from "react-leaflet";

export const LocationMarker = ({inputLongitude, inputLongitudeHandler, inputLatitude, inputLatitudeHandler}) => {
    function handleChange(e) {
        const latlng = e.latlng;
        inputLongitudeHandler(latlng.lng);
        inputLatitudeHandler(latlng.lat);
        map.flyTo(e.latlng, map.getZoom());
    }

    const map = useMapEvents({
        click(e) {
            handleChange(e);
        },
        locationfound(e) {
            handleChange(e);
        },
    });

    if (inputLongitude === undefined || inputLatitude === undefined || inputLongitude === null || inputLatitude === null) {
        return null
    } else {
        return <Marker position={{lat: inputLatitude, lng: inputLongitude}}></Marker>
    }
}