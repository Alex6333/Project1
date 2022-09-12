public enum StudyProfile {
    MEDICINE("Медицина"),
    HISTORY("История"),
    ENGINEERING("Машиностроение"),
    MARKETING("Маркетинг"),
    ECONOMIC("Экономика");

    final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
