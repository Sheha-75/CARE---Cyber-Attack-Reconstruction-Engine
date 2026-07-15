import { useContext } from "react";
import { Navigate } from "react-router-dom";

import { AuthContext } from "./AuthContext";

interface Props {
    children: React.ReactNode;
}

export default function ProtectedRoute({
                                           children,
                                       }: Props) {

    const auth = useContext(AuthContext);

    if (!auth.token) {

        return <Navigate to="/" replace />;

    }

    return children;

}