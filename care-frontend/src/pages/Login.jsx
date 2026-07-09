import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";

function Login() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    const handleLogin = async (e) => {

        e.preventDefault();

        try {

            const response = await api.post("/auth/login", {
                email,
                password
            });

            localStorage.setItem(
                "token",
                response.data.token
            );

            navigate("/dashboard");

        }catch (error) {

            console.log(error);

            if (error.response) {
                alert(
                    "Error: " +
                    error.response.status +
                    " - " +
                    JSON.stringify(error.response.data)
                );
            } else {
                alert(error.message);
            }
        }
    };

    return (
        <div className="container mt-5">

            <h2>CARE Login</h2>

            <form onSubmit={handleLogin}>

                <div className="mb-3">
                    <input
                        className="form-control"
                        placeholder="Email"
                        value={email}
                        onChange={(e) =>
                            setEmail(e.target.value)
                        }
                    />
                </div>

                <div className="mb-3">
                    <input
                        type="password"
                        className="form-control"
                        placeholder="Password"
                        value={password}
                        onChange={(e) =>
                            setPassword(e.target.value)
                        }
                    />
                </div>

                <button
                    className="btn btn-primary"
                    type="submit"
                >
                    Login
                </button>

            </form>

        </div>
    );
}

export default Login;