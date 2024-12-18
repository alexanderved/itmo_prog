package proglab34.utils;

public record NounWithCases(String nominative, String genitive, String dative,
    String accusative, String instrumental, String prepositional, String plural)
{
    private static final int NB_CASES = 7;

    public NounWithCases() {
        this("", "", "", "", "", "", "");
    }

    public NounWithCases(String s) {
        this(s, s, s, s, s, s, s);
    }

    public static NounWithCases fromArray(String[] arr) {
        return new NounWithCases(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
    }

    public String[] toArray() {
        String[] arr = { nominative(), genitive(), dative(),
            accusative(), instrumental(), prepositional(), plural() };

        return arr;
    }

    public NounWithCases concat(String s) {
        String[] cases = toArray();
        for (int i = 0; i < NB_CASES; ++i) {
            cases[i] = cases[i].concat(s);
        }

        return fromArray(cases);
    }

    public NounWithCases concat(NounWithCases noun) {
        String[] cases = toArray();
        String[] other_cases = noun.toArray();
        for (int i = 0; i < NB_CASES; ++i) {
            cases[i] = cases[i].concat(other_cases[i]);
        }

        return fromArray(cases);
    }

    public NounWithCases capitalize() {
        String[] cases = toArray();
        for (int i = 0; i < NB_CASES; ++i) {
            cases[i] = cases[i].substring(0, 1).toUpperCase() + cases[i].substring(1);
        }

        return fromArray(cases);
    }
}