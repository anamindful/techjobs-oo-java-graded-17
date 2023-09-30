package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    private Job job1;
    private Job job2;

    @Before
    public void setUp() {
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        // declare + initialize new job object
        Job job = new Job
                ("Product tester",
                        new Employer("ACME"),
                        new Location("Desert"),
                        new PositionType("Quality control"),
                        new CoreCompetency("Persistence"));

        assertNotNull(job.getName());
        assertNotNull(job.getEmployer());
        assertNotNull(job.getLocation());
        assertNotNull(job.getPositionType());
        assertNotNull(job.getCoreCompetency());

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    //generate two job objects, same except for id
    public void testJobsForEquality() {
        Job jobA = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job jobB = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        // test that returns false when ids don't match
        assertFalse(jobA.equals(jobB));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job();
        String jobString = job.toString();

        assertTrue(jobString.startsWith(System.lineSeparator()));
        assertTrue(jobString.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job
                ("Software Developer",
                new Employer("Mind Body"),
                new Location("LA"),
                new PositionType("Full-Time"),
                new CoreCompetency("Java Programming")
                );

        String jobString = job.toString();

        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: Software Developer"));
        assertTrue(jobString.contains("Employer: Mind Body"));
        assertTrue(jobString.contains("Location: LA"));
        assertTrue(jobString.contains("Position Type: Full-Time"));
        assertTrue(jobString.contains("Core Competency: Java Programming"));

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job
                ("",
                new Employer(" "),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));

        String jobString = job.toString();

        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: "));
        assertTrue(jobString.contains("Employer: "));
        assertTrue(jobString.contains("Location: "));
        assertTrue(jobString.contains("Position Type: "));
        assertTrue(jobString.contains("Core Competency: "));
    }
}
