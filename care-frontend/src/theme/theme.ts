import { createTheme } from "@mui/material/styles";

const theme = createTheme({
    palette: {
        mode: "light",

        primary: {
            main: "#1565C0",
        },

        secondary: {
            main: "#26A69A",
        },

        background: {
            default: "#F5F7FA",
            paper: "#FFFFFF",
        },
    },

    typography: {
        fontFamily: [
            "Inter",
            "Roboto",
            "Arial",
            "sans-serif",
        ].join(","),
    },

    shape: {
        borderRadius: 10,
    },
});

export default theme;