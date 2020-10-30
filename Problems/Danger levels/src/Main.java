enum DangerLevel {
    HIGH(3, "HIGH"),
    MEDIUM(2, "MEDIUM"),
    LOW(1, "LOW");

    int level;
    String value;
    DangerLevel(int level, String value) {
        this.level = level;
        this.value = value;
    }

    public int getLevel() {
        return level;
    }



}