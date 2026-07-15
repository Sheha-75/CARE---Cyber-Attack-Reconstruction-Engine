import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";

import FolderIcon from "@mui/icons-material/Folder";
import DescriptionIcon from "@mui/icons-material/Description";
import TimelineIcon from "@mui/icons-material/Timeline";
import ReportIcon from "@mui/icons-material/Assessment";

import StatCard from "../../components/common/StatCard";

export default function DashboardPage() {
    return (
        <Box sx={{ p: 2 }}>
            <Grid container spacing={3}>
                <Grid size={{ xs: 12, md: 3 }}>
                    <StatCard
                        title="Investigations"
                        value={12}
                        icon={<FolderIcon fontSize="large" />}
                    />
                </Grid>

                <Grid size={{ xs: 12, md: 3 }}>
                    <StatCard
                        title="Evidence"
                        value={84}
                        icon={<DescriptionIcon fontSize="large" />}
                    />
                </Grid>

                <Grid size={{ xs: 12, md: 3 }}>
                    <StatCard
                        title="Timeline Events"
                        value={621}
                        icon={<TimelineIcon fontSize="large" />}
                    />
                </Grid>

                <Grid size={{ xs: 12, md: 3 }}>
                    <StatCard
                        title="Reports"
                        value={9}
                        icon={<ReportIcon fontSize="large" />}
                    />
                </Grid>
            </Grid>
        </Box>
    );
}