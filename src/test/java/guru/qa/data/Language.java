package guru.qa.data;

public enum Language {
    Dansk("Inspiration til fremtidige smutture"),
    Català("Inspiració per a futures escapades");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}