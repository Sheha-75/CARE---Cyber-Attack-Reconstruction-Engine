import { Card, CardContent, Typography, Box } from "@mui/material";
import { ReactNode } from "react";

interface StatCardProps {
    title: string;
    value: number | string;
    icon: ReactNode;
}

export default function StatCard({
                                     title,
                                     value,
                                     icon,
                                 }: StatCardProps) {
    return (
        <Card elevation={3}>
            <CardContent>
                <Box
                    display="flex"
                    justifyContent="space-between"
                    alignItems="center"
                >
                    <Box>
                        <Typography
                            variant="body2"
                            color="text.secondary"
                        >
                            {title}
                        </Typography>

                        <Typography
                            variant="h4"
                            fontWeight="bold"
                        >
                            {value}
                        </Typography>
                    </Box>

                    {icon}
                </Box>
            </CardContent>
        </Card>
    );
}