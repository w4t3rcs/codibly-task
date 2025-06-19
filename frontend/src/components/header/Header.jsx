import {DarkModeButton} from "./DarkModeButton.jsx";

export const Header = () => {
    return (
        <header className="transition-all bg-white dark:bg-gray-800 w-full flex justify-end p-4">
            <DarkModeButton />
        </header>
    )
}