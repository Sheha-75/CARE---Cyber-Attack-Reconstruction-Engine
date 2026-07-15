import {
    Box,
    CssBaseline,
    Drawer,
    Toolbar,
} from "@mui/material";

import Sidebar from "../components/layout/Sidebar";
import TopBar from "../components/layout/TopBar";

const drawerWidth = 240;

interface Props {
    children: React.ReactNode;
}

export default function MainLayout({
                                       children,
                                   }: Props) {

    return (

        <Box sx={{ display: "flex" }}>

            <CssBaseline />

            <TopBar />

            <Drawer
                variant="permanent"
                sx={{
                    width: drawerWidth,
                    flexShrink: 0,
                    "& .MuiDrawer-paper": {
                        width: drawerWidth,
                        boxSizing: "border-box",
                    },
                }}
            >
                <Toolbar />

                <Sidebar />

            </Drawer>

            <Box
                component="main"
                sx={{
                    flexGrow: 1,
                    p: 3,
                    bgcolor: "#F5F7FA",
                    minHeight: "100vh",
                }}
            >

                <Toolbar />

                {children}

            </Box>

        </Box>

    );

}