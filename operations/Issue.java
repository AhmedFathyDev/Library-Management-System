package operations;

import main.Data;

/**
 * @author Fathy & Najm
 */
public class Issue implements Operation {

    private long issueDate;

    private Search search;

    private short studentID;

    public Issue(short ID) {
        this.search = new Search(ID);
        this.search.operation();
    }

    @Override
    public void operation() {
        if (this.search.isExist()) {
            this.issueDate = System.currentTimeMillis();
            Data.publications.get(
                    this.search.getPublicationIndex()
            ).setNumberOfCopies((short) 1);
            System.out.println("Done.");
        } else {
            System.out.println("The publication is not exist");
        }
    }

    public void setIssueDate(long issueDate) {
        this.issueDate = issueDate;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public void setStudentID(short studentID) {
        this.studentID = studentID;
    }

    public long getIssueDate() {
        return issueDate;
    }

    public Search getSearch() {
        return search;
    }

    public short getStudentID() {
        return studentID;
    }

}
