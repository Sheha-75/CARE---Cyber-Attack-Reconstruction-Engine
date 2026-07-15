import {
    AppBar,
    Toolbar,
    Typography,
    IconButton,
    Box,
} from "@mui/material";

import LogoutIcon from "@mui/icons-material/Logout";
import NotificationsIcon from "@mui/icons-material/Notifications";

import { useContext } from "react";
import { useNavigate } from "react-router-dom";

import { AuthContext } from "../../auth/AuthContext";

export default function TopBar() {

    const auth = useContext(AuthContext);

    const navigate = useNavigate();

    const logout = () => {

        auth.logout();

        navigate("/");

    };

    return (

        <AppBar position="fixed">

            <Toolbar>

                <Typography
                    variant="h6"
                    sx={{ flexGrow: 1 }}
                >
                    CARE Platform
                </Typography>

                <Box>

                    <IconButton color="inherit">

                        <NotificationsIcon />

                    </IconButton>

                    <IconButton
                        color="inherit"
                        onClick={logout}
                    >

                        <LogoutIcon />

                    </IconButton>

                </Box>

            </Toolbar>

        </AppBar>

    );

}