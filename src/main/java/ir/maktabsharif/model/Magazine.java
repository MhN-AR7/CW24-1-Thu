package ir.maktabsharif.model;

import ir.maktabsharif.enums.FrequencyStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Magazine extends LibraryItem {
    /*
     fields `issueNumber`, `publisher`, `frequency` (enum: `WEEKLY`, `MONTHLY`, `QUARTERLY`)
     */
    private int issueNumber;
    private String publisher;
    @Enumerated(EnumType.STRING)
    private FrequencyStatus frequency;

    public Magazine(String title, int publishYear, int availableCopies, int issueNumber, String publisher, FrequencyStatus frequency) {
        super(title, publishYear, availableCopies);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
        this.frequency = frequency;
    }

    public Magazine(int issueNumber, String publisher, FrequencyStatus frequency) {
        this.issueNumber = issueNumber;
        this.publisher = publisher;
        this.frequency = frequency;
    }

    public Magazine() {
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public FrequencyStatus getFrequency() {
        return frequency;
    }

    public void setFrequency(FrequencyStatus frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber=" + issueNumber +
                ", publisher='" + publisher + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
