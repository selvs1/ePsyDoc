package ch.bfh.btx8081.w2019.white.ePsyDoc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.jpa.Archive;
import org.eclipse.persistence.jpa.jpql.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.bfh.btx8081.w2019.white.ePsyDoc.view.connections.ReportConnector;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.database.Database;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.ReportModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;


/**
 * Unfortunatley due to technical problems we haven't finished this test class yet.
 *
 * @author David Gaupp
 * @author Viktor Velkov
 */
public class ReportViewImplTest {

    ReportModel reportmodel = new ReportModel();

    static Patient patTest = new Patient(42069, "Meyer", "Markus", "m", Date.valueOf(LocalDate.now()), "Blumenstrasse 24", "3280" );
    //    private static final Doctor docTest = new Doctor("Rudolf", "Bühler", "buer1", "0000",  Date.valueOf(LocalDate.now()), "Sonnenweg 31", "5720", "Bärn");
    private static final Doctor docTest = new Doctor();
    static PatientCase patientCaseTest = new PatientCase(patTest, docTest);
    private static String[] diagnosis = {"Normaler Krebs", "Lungenkarzinom", "Bronchitis"};
    static Diagnosis diagnosisTest1 = new Diagnosis(patientCaseTest, diagnosis[0]);
    static Diagnosis diagnosisTest2 = new Diagnosis(patientCaseTest, diagnosis[1]);
    static Diagnosis diagnosisTest3 = new Diagnosis(patientCaseTest, diagnosis[2]);
    private static final Diagnosis[] DIAGNOSIS = {diagnosisTest1, diagnosisTest2, diagnosisTest3};
    private static ArrayList<PatientCase> patList = new ArrayList<PatientCase>();
    static String reportT1 = "Befund eines normalen Krebses";
    static String reportT2 = "Kratzen im Hals. Vermutung auf entzündete Mandeln";
    PatientCase newCase = new PatientCase(patTest, docTest);
    PatientCase newnewCase = new PatientCase(patTest, docTest);



    private final String url = "jdbc:postgresql://147.87.116.213/ePsyDoc1";
    private final String user = "postgres";
    private final String password = "<add your password>";



    @Before
    public void preparePersistenceTest() throws Exception {

        String report1 = "Befund eines normalen Krebses";
        String report2 = "Kratzen im Hals. Vermutung auf entzündete Mandeln";
        newCase.setReport(report1);
        newnewCase.setReport(report2);
        patList.add(newCase);

        reportmodel.addPatientCase(newCase);

    }


    /*
    @Test
    public void findAllDiagnosisInPatientCase() throws Exception {
        // given
        String fetchingAllGamesInJpql = "select p from Patiencase q order by p.patientCaseID";

        // when
        System.out.println("Selecting (using JDBC)...");
        List<PatientCase> pcs = em.createQuery(fetchingAllGamesInJpql, PatientCase.class).getResultList();

        // then
        System.out.println("Found " + pcs.size() + " PatientCase (using JPA):");
        asertContainAllDiagnosis(pcs);
    }

    private static void asertContainAllDiagnosis(List<PatientCase> retrievedPatientCase) {
        final Set<String> retrievedDiagnosis = new HashSet<String>();
        for (PatientCase pc : retrievedPatientCase) {
        	for(Diagnosis dg : pc.getDiagnosis())
        	{
        		assertTrue(dg.getDiagnosis().equals(diagnosis));
        	}
            System.out.println("* " + pc.getDiagnosis());
            retrievedDiagnosis.add(pc.getDiagnosis().toString());
        }
        assertTrue(retrievedDiagnosis.contains(Arrays.asList(DIAGNOSIS)));
    }
    */

}