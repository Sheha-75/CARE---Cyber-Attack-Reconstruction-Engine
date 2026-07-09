import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";

function Dashboard() {

    const [stats, setStats] = useState(null);

    const navigate = useNavigate();

    useEffect(() => {

        loadStats();

    }, []);

    const loadStats = async () => {

        try {

            const response =
                await api.get("/dashboard/stats");

            setStats(response.data);

        } catch (error) {

            console.log(error);

            alert("Failed to load dashboard");
        }
    };

    if (!stats) {

        return (

            <div className="container mt-5">
                Loading...
            </div>

        );
    }

    return (

        <div className="container mt-5">

            <h1>CARE Dashboard</h1>

            <hr />

            <h3>
                Total Cases: {stats.totalCases}
            </h3>

            <h3>
                Open Cases: {stats.openCases}
            </h3>

            <h3>
                Total Evidence: {stats.totalEvidence}
            </h3>

            <h3>
                Timeline Events: {stats.totalTimelineEvents}
            </h3>

            <button
                className="btn btn-primary mt-4"
                onClick={() => navigate("/case")}
            >
                Open Investigation
            </button>

        </div>
    );
}

export default Dashboard;