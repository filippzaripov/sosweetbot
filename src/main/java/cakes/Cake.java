package cakes;

public class Cake {

    private final CakeType cakeType;
    private final CakeSize cakeSize;
    private final CakeViewDecoration cakeViewDecoration;


    private Cake(CakeType cakeType,
                 CakeSize cakeSize, CakeViewDecoration cakeViewDecoration) {
        this.cakeType = cakeType;
        this.cakeSize = cakeSize;
        this.cakeViewDecoration = cakeViewDecoration;
    }

    public CakeType getCakeType() {
        return cakeType;
    }

    public CakeSize getCakeSize() {
        return cakeSize;
    }

    public CakeViewDecoration getCakeViewDecoration() {
        return cakeViewDecoration;
    }

    public static class CakeBuilder {

        private CakeType cakeType;
        private CakeSize cakeSize;
        private CakeViewDecoration cakeViewDecoration;

        public CakeBuilder cakeType(CakeType cakeType) {
            this.cakeType = cakeType;
            return this;
        }

        public CakeBuilder cakeSize(CakeSize cakeSize) {
            this.cakeSize = cakeSize;
            return this;
        }

        public CakeBuilder cakeView(CakeViewDecoration cakeViewDecoration) {
            this.cakeViewDecoration = cakeViewDecoration;
            return this;
        }

        public Cake build() {
            return new Cake(
                    cakeType,
                    cakeSize,
                    cakeViewDecoration);
        }

    }
}
