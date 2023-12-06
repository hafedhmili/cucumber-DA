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

public class ScenarioInscription {

    private ServiceDossierAcademique serviceDossierAcademique = new ServiceDossierAcademiqueImpl();
    private GroupeCours groupeCours;
    private Etudiant etudiant;

    @Given ("a program, a course, a course section, and a student")
    public void creerProgramCourseCourseSectionStudent() {
        Programme programme = serviceDossierAcademique.creerProgramme("3817","Maitrise en génie logiciel", 45);
        Cours cours = serviceDossierAcademique.creerCours("MGL7460", "Réalisation et Maintenance de Logiciels", "Ce cours est fait pour vous écoeurer", 3);
        programme.ajouterCours(cours);
        groupeCours = serviceDossierAcademique.creerGroupeCours(cours, 2023, Session.Automne, "Mili");
        etudiant = serviceDossierAcademique.creerEtudiant("Hafedh", "Mili","MILH12345678" );
        etudiant.inscrireProgramme(programme);
    }

    @When("student registers at course section")
    public void inscriptionEtudiantDansGroupeCours() {
        this.etudiant.inscrireGroupeCours(this.groupeCours);
    }

    @Then ("student found in course enrollment")
    public void verifierInscriptionEtudiantDansGroupeCours() {
        assert (groupeCours.estInscrit(etudiant));
    }   
}
