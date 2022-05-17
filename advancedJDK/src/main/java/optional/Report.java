package optional;

/**
 * @version : V1.0
 * @date : 2022/3/10 11:19
 * @Author : LLH
 * @Desc :
 */
public class Report {
    String ReportFiles;

    public String getReportFiles() {
        return ReportFiles;
    }

    public void setReportFiles(String reportFiles) {
        ReportFiles = reportFiles;
    }

    @Override
    public String toString() {
        return "Report{" +
                "ReportFiles='" + ReportFiles + '\'' +
                '}';
    }
}
