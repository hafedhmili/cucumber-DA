package ca.uqam.info.mgl7460;

import ca.uqam.info.mgl7460.domain.Cours;
import ca.uqam.info.mgl7460.domain.Etudiant;
import ca.uqam.info.mgl7460.domain.GroupeCours;
import ca.uqam.info.mgl7460.domain.Programme;
import ca.uqam.info.mgl7460.domain.ServiceDossierAcademique;
import ca.uqam.info.mgl7460.domain.Session;
import ca.uqam.info.mgl7460.implementation.ServiceDossierAcademiqueImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenariosEvaluation {

    private ServiceDossierAcademique serviceDA = new ServiceDossierAcademiqueImpl();

    private Programme programme;

    private Cours cours;

    private GroupeCours groupeCours;

    private Etudiant etudiant;

    private int nombreInitialDeCredits;
    
    @Given("un programme P de M credits")
    public void unProgrammePdeMCredits() {
        programme = serviceDA.creerProgramme("3918", "Maitrise en génie logiciel",45);
    }
    @Given("un cours C faisant partie du programme P comptant pour {int} credits")
    public void unCoursCFaisantPartieDuProgrammePComptantPourCredits(Integer int1) {
        cours = serviceDA.creerCours("MGL7460", "Réalisation et maintenance de logiciels","Pour écoeurer les étudiants",int1);
        programme.ajouterCours(cours);
    }

    /**
     * on simule ça en créant un cours avec int2 credits et en attribuant
     * la note de passage à ce cours
     * @param int2
     */
    @Given("un etudiant E inscrit au programme P ayant complété {int} credits")
    public void unEtudiantEinscritAuProgrammePayantCompleteNcredits(Integer int2) {
        nombreInitialDeCredits = int2;
        etudiant = serviceDA.creerEtudiant("Hafedh","Mili", "MILH12345678");
        long numeroCoursBidon = 1000 + Math.round(999*Math.random());
        Cours coursBidon = serviceDA.creerCours("INF"+ numeroCoursBidon, "Cours INF"+numeroCoursBidon, "Cours Bidon",int2.intValue());
        GroupeCours groupeCoursBidon = serviceDA.creerGroupeCours(coursBidon, (int)(2020 + Math.round(2*Math.random()+1)), Session.Automne,"Enseignant"+numeroCoursBidon);
        etudiant.inscrireGroupeCours(groupeCoursBidon);
        // leur attribuer note de passage
        etudiant.setNoteGroupeCours(groupeCoursBidon, 4.0f);
    }

    @Given("un groupe cours GC pour le cours C auquel est inscrit l'étudiant E")
    public void unGroupeCoursGCpourLeCoursCauquelEstInscritlEtudiantE() {
        groupeCours = serviceDA.creerGroupeCours(cours, 2023, Session.Automne, "Mili");
        etudiant.inscrireGroupeCours(groupeCours);
    }    
    
        @Given("une note de passage de {double} pour le groupe cours GC")
public void setNoteDePassagePourGroupeCours(Double double1) {
    groupeCours.setNoteDePassage(double1.floatValue());
}
@When("l'étudiant E reçoit une note {double} pour le groupe cours GC")
public void setNotePourGroupeCours(Double double1) {
    etudiant.setNoteGroupeCours(groupeCours, double1.floatValue());
}

@Then("le nombre de credits completes par l'étudiant E reste le même")
public void leNombreDeCreditsCompletesParLetudiantResteLeMeme() {
    int nouveauNombreCreditsReussis = (int)etudiant.getNombreCreditsReussis();
    assert (nombreInitialDeCredits == nouveauNombreCreditsReussis);
}

@Then("le nombre de credits completes par l'étudiant E augmente de {int}")
    public void leNombreDeCreditsCompletesParLetudiantAugmenteDe(Integer int1) {
        int nouveauNombreCreditsReussis = (int)etudiant.getNombreCreditsReussis();
        assert ((nombreInitialDeCredits + int1) == nouveauNombreCreditsReussis);
    }
}
