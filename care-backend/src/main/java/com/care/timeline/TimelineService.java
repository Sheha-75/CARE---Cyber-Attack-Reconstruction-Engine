public TimelineEvent createEvent(
        Long caseId,
        String eventType,
        String description
) {

    InvestigationCase investigationCase =
            caseRepository.findById(caseId)
                    .orElseThrow();

    TimelineEvent event =
            new TimelineEvent();

    event.setEventType(eventType);

    event.setDescription(description);

    event.setEventTime(
            LocalDateTime.now()
    );

    event.setInvestigationCase(
            investigationCase
    );

    return timelineRepository.save(event);
}