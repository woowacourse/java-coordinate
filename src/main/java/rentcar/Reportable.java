package rentcar;

interface Reportable {
    String NEWLINE = System.getProperty("line.separator");

    String generateReport();
}
