import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";

import {
    Box,
    Button,
    Card,
    CardContent,
    TextField,
    Typography,
    Alert,
} from "@mui/material";

import { login } from "../../services/authService";
import { AuthContext } from "../../auth/AuthContext";

export default function LoginPage() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    const navigate = useNavigate();
    const auth = useContext(AuthContext);

    const handleLogin = async () => {
        setLoading(true);
        setError("");

        try {
            const response = await login({
                email,
                password,
            });

            auth.login(
                response.accessToken,
                response.user
            );

            navigate("/dashboard");
        } catch (err: any) {
            console.error(err);

            if (err.response?.data?.message) {
                setError(err.response.data.message);
            } else {
                setError("Invalid email or password.");
            }
        } finally {
            setLoading(false);
        }
    };

    return (
        <Box
            display="flex"
            justifyContent="center"
            alignItems="center"
            sx={{
                minHeight: "100vh",
                backgroundColor: "#f5f7fa",
            }}
        >
            <Card
                sx={{
                    width: 420,
                    borderRadius: 3,
                    boxShadow: 5,
                }}
            >
                <CardContent sx={{ p: 4 }}>
                    <Typography
                        variant="h4"
                        align="center"
                        gutterBottom
                    >
                        CARE Login
                    </Typography>

                    <Typography
                        variant="body2"
                        color="text.secondary"
                        align="center"
                        mb={3}
                    >
                        Cyber Attack Reconstruction Engine
                    </Typography>

                    {error && (
                        <Alert severity="error" sx={{ mb: 2 }}>
                            {error}
                        </Alert>
                    )}

                    <TextField
                        fullWidth
                        label="Email"
                        margin="normal"
                        value={email}
                        onChange={(e) =>
                            setEmail(e.target.value)
                        }
                    />

                    <TextField
                        fullWidth
                        label="Password"
                        type="password"
                        margin="normal"
                        value={password}
                        onChange={(e) =>
                            setPassword(e.target.value)
                        }
                    />

                    <Button
                        fullWidth
                        variant="contained"
                        sx={{ mt: 3 }}
                        onClick={handleLogin}
                        disabled={loading}
                    >
                        {loading ? "Signing In..." : "Login"}
                    </Button>
                </CardContent>
            </Card>
        </Box>
    );
}