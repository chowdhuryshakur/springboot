package com.managemeeting.managemeetin;

import com.managemeeting.managemeetin.meeting.Meetings;

public interface MeetingChangeListener {
    void meetingChanged(Meetings meeting);
}