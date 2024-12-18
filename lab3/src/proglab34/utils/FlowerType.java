package proglab34.utils;

public enum FlowerType {
    DAISY(new NounWithCases("маргаритка", "маргаритки", "маргаритке",
        "маргаритку", "маргариткой", "маргаритке", "маргаритки")),
    CHAMOMILE(new NounWithCases("ромашка", "ромашки", "ромашке",
        "ромашку", "ромашкой", "ромашке", "ромашки")),
    PANSY(new NounWithCases("анютины глазки", "анютиных глазок", "анютиным глазкам",
        "анютины глазки", "анютиными глазками", "анютиных глазках", "анютины глазки")),
    TULIP(new NounWithCases("тюльпан", "тюльпана", "тюльпану",
        "тюльпан", "тюльпаном", "тюльпане", "тюльпаны"));

    private NounWithCases name = new NounWithCases("");

    private FlowerType(NounWithCases name) {
        this.name = name;
    }

    public NounWithCases getName() {
        return name;
    }
}