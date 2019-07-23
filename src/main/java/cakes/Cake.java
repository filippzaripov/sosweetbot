package cakes;

public class Cake {

    private final CakeType cakeType;
    private final CakeSize cakeSize;

    public Cake(CakeType cakeType, CakeSize cakeSize) {
        this.cakeType = cakeType;
        this.cakeSize = cakeSize;
    }

    public CakeType getCakeType() {
        return cakeType;
    }

    public CakeSize getCakeSize() {
        return cakeSize;
    }


    public class CakeBuilder {
        private Cake cakeTmp;

        public CakeBuilder() {
            cakeTmp = new Cake(cakeType, cakeSize);
        }

        public Cake build() {
            return cakeTmp;
        }

//        public CakeBuilder setCakeType(CakeType cakeType) {
//            cakeTmp.setCakeType(cakeType);
//            return this;
//        }
//
//        public CakeBuilder setCakeSize(CakeSize cakeSize) {
//            cakeTmp.setCakeSize(cakeSize);
//            return this;
//        }

    }
}
