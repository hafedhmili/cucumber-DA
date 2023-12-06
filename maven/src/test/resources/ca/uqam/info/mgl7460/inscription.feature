Feature: Inscriptions

Scenario: inscription simple

Given a program, a course, a course section, and a student

When student registers at course section

Then student found in course enrollment
