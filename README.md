README (Hack4Good Submission)

Table of Contents:
Info on our Hack4Good Submission
Getting Started
Google Calendar
Features at a glance
    Managing pending events
    Scheduling follow-up tasks and meetings
    AI Summary Genrator (TBC)


Info on our Hack4Good Submission: 

This project is meant to address the problem statement of the Singapore Book Council:

"Develop a cost-effective digital PA system for system administrators to efficiently arrange and schedule meetings and automate tasks 
such as sending follow-up tasks to themselves or others, sending reminder, generating summaries of email threads, and arranging meetings."

Our solution leverages on the functionalities of Google Calendar, 
and builds upon them so as to acheive the quality of life and efficiency goals as stated in the prompt.
The main bulk of our program was coded in Java, 
mainly because it is a relatively simple and readable language built for its modularity and scalability, 
and also is object-oriented.

Google Calendar:

We have chosen to built on Google Calendar as Google Calendar is a widely accessible, free productivity tool available to everyone, and so we thought it would
be wise to leverage on the current functionalities of Google Calendar, such as creating and sharing events and meetings on a specific time and day, 
and setting reminders for events.

Features at a glance: (must add implementation)
    View and manage events:
    Our solution features a dashboard in which the administrator can track pending events, or rather, events that are waiting on people to accept the invite
    send by the administrator.
    The dashboard also allows other administrators to view invites to other's events, and accept them from the dashboard.

    Scheduling follow-up tasks and meetings:
    After a meeting, there are often follow-up tasks and meetings that proceed an event/meeting. Thus, administrators may add follow-up tasks,
    that can be marked completed when done, and follow-up meetings to the original meeting. We have designed it such that the original meeting can
    be traced from its follow-up activities, to ensure that everyone is on the same page.  