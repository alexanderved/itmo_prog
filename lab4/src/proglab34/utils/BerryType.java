package proglab34.utils;

public enum BerryType {
    STRAWBERRY(new NounWithCases("клубника", "клубники", "клубнике",
        "клубнику", "клубникой", "клубнике", "клубники"));

    private NounWithCases name = new NounWithCases("");

    private BerryType(NounWithCases name) {
        this.name = name;
    }

    public NounWithCases getName() {
        return name;
    }
}