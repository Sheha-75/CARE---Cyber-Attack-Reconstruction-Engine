import { useState } from "react";
import { AuthContext, User } from "./AuthContext";

interface Props {
    children: React.ReactNode;
}

export default function AuthProvider({ children }: Props) {

    const [token, setToken] = useState<string | null>(
        localStorage.getItem("token")
    );

    const [user, setUser] = useState<User | null>(
        localStorage.getItem("user")
            ? JSON.parse(localStorage.getItem("user")!)
            : null
    );

    const login = (jwt: string, user: User) => {

        localStorage.setItem("token", jwt);
        localStorage.setItem("user", JSON.stringify(user));

        setToken(jwt);
        setUser(user);
    };

    const logout = () => {

        localStorage.removeItem("token");
        localStorage.removeItem("user");

        setToken(null);
        setUser(null);
    };

    return (
        <AuthContext.Provider
            value={{
                token,
                user,
                login,
                logout,
            }}
        >
            {children}
        </AuthContext.Provider>
    );
}