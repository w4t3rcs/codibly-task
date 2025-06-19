import {Main} from "./components/main/Main.jsx";
import "./App.css";
import * as React from "react";
import {ThemeProvider} from "./context/ThemeProvider.jsx";
import {Header} from "./components/header/Header.jsx";

export const App = () => {
    return (
        <ThemeProvider>
            <Header />
            <Main />
        </ThemeProvider>
    )
}