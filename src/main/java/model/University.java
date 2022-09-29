package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

public class University {

    @SerializedName("id")
    private String id;
    @SerializedName("universityFullName")
    private String fullName;
    @SerializedName("universityShortName")
    private String shortName;
    @SerializedName("yearOfFoundation")
    private int yearOfFoundation;
    @SerializedName("profile")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public University() {
    }

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return   "id университета: " + this.id + "\n" + "Полное название университета: " + this.fullName + "\n"
                + "сокращенное название университета: " + this.shortName + "\n"
                + "год основания университета: " + this.yearOfFoundation + "\n"
                + "направление обучения: " + this.mainProfile+ "\n"
                + "==================================================";
    }
}
