import DashboardIcon from "@mui/icons-material/Dashboard";
import FolderIcon from "@mui/icons-material/Folder";
import DescriptionIcon from "@mui/icons-material/Description";
import TimelineIcon from "@mui/icons-material/Timeline";
import AssessmentIcon from "@mui/icons-material/Assessment";
import PeopleIcon from "@mui/icons-material/People";

import {
    List,
    ListItem,
    ListItemButton,
    ListItemIcon,
    ListItemText,
} from "@mui/material";

const menuItems = [
    { text: "Dashboard", icon: <DashboardIcon /> },
    { text: "Investigations", icon: <FolderIcon /> },
    { text: "Evidence", icon: <DescriptionIcon /> },
    { text: "Timeline", icon: <TimelineIcon /> },
    { text: "Reports", icon: <AssessmentIcon /> },
    { text: "Users", icon: <PeopleIcon /> },
];

export default function Sidebar() {
    return (
        <List>
            {menuItems.map((item) => (
                <ListItem key={item.text} disablePadding>
                    <ListItemButton>
                        <ListItemIcon>{item.icon}</ListItemIcon>
                        <ListItemText primary={item.text} />
                    </ListItemButton>
                </ListItem>
            ))}
        </List>
    );
}