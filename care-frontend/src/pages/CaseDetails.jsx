import { useEffect, useState } from "react";
import api from "../services/api";

function CaseDetails() {

    const [timeline, setTimeline] = useState([]);
    const [summary, setSummary] = useState("");

    useEffect(() => {

        loadData();

    }, []);

    const loadData = async () => {

        try {

            const timelineResponse =
                await api.get("/timeline/case/1");

            setTimeline(
                timelineResponse.data
            );

            const summaryResponse =
                await api.get("/summary/case/1");

            setSummary(
                summaryResponse.data.summary
            );

        } catch (error) {

            console.log(error);
        }
    };

    return (

        <div className="container mt-4">

            <h2>Investigation Case #1</h2>

            <hr />

            <h4>AI Incident Summary</h4>

            <div className="card p-3 mb-4">
                {summary}
            </div>

            <h4>Timeline Events</h4>

            <div className="card p-3">

                {timeline.map(event => (

                    <div
                        key={event.id}
                        className="border-bottom mb-3 pb-2"
                    >

                        <strong>
                            {event.eventType}
                        </strong>

                        <br />

                        {event.description}

                        <br />

                        <small>
                            {event.eventTime}
                        </small>

                    </div>

                ))}

            </div>

        </div>
    );
}

export default CaseDetails;