import {useTheme} from "../../context/ThemeProvider.jsx";
import {BsMoon, BsSun} from "react-icons/bs";

export const DarkModeButton = () => {
    const {darkMode, setDarkMode} = useTheme();
    return (
        <button className="px-2 py-2 rounded-full bg-gray-200 dark:bg-gray-900 dark:text-white" onClick={() => setDarkMode(!darkMode)}>
            {darkMode ? <BsMoon className="text-2xl" /> : <BsSun className="text-2xl" />}
        </button>
    );
}