public enum CalculoSeguro {
    VALOR_BASE(10),
    FATOR_18_30(1.25),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    private final double fator;

    CalculoSeguro(double fator) {
        this.fator = fator;
    }

    public double getFator() {
        return fator;
    }
}