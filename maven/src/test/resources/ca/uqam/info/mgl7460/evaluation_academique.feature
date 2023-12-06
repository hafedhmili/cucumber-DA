Feature: Evaluation Academique

Background: set up de données initiale communes
Given un programme P de M credits
And un cours C faisant partie du programme P comptant pour 3 credits
And un etudiant E inscrit au programme P ayant complété 30 credits
And un groupe cours GC pour le cours C auquel est inscrit l'étudiant E


Scenario: attribution de note de passage
Given une note de passage de 2.0 pour le groupe cours GC
When l'étudiant E reçoit une note 3.0 pour le groupe cours GC
Then le nombre de credits completes par l'étudiant E augmente de 3

Scenario: attribution de note d'échec
Given une note de passage de 2.0 pour le groupe cours GC
When l'étudiant E reçoit une note 1.0 pour le groupe cours GC
Then le nombre de credits completes par l'étudiant E reste le même
