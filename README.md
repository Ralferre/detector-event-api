# detector-event-api
    An API which has methods CRUD to persist detectors events. Simulating a system of detection providing to the 
users, complete registers of each event. This event will be set on frontend app React being like a set point that 
shoots persistence methods on database, carrying registered value above the set point, hour and date. Providing like an
interactive system, users can act in three different ways, which are: 
    - recognize detector event: this method will register on database the user, date and hour of his action, providing 
traceability. This action can be done only after the occurrence that shot the detector is resolved;
    - muted: this method means a situation that not yet resolved the occurrence, but the user is doing something to
treat. Even thought, this API will register on database date, hour and user, holding a reliable system;
    - alarm: this a condition that the detector just detected a leak event, registering value, hour and date;

    Providing resources to the users make analysis, searching by detector TAG, date, detected values, all theses params
can be inserted like filter to search register on database.
    Still in development, this API will offer integration with React app frontend, to present which machines and
senses detected leak and its correct register.
