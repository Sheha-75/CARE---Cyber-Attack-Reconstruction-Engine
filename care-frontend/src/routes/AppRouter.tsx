import { BrowserRouter, Routes, Route } from "react-router-dom";

import LoginPage from "../pages/Login/LoginPage";
import DashboardPage from "../pages/Dashboard/DashboardPage";

import MainLayout from "../layouts/MainLayout";
import ProtectedRoute from "../auth/ProtectedRoute";

export default function AppRouter() {

    return (

        <BrowserRouter>

            <Routes>

                <Route
                    path="/"
                    element={<LoginPage />}
                />

                <Route
                    path="/dashboard"
                    element={
                        <ProtectedRoute>

                            <MainLayout>

                                <DashboardPage />

                            </MainLayout>

                        </ProtectedRoute>
                    }
                />

            </Routes>

        </BrowserRouter>

    );

}