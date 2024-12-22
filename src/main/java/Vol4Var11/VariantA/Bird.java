package Vol4Var11.VariantA;

public abstract class Bird {
        public abstract void fly();
        public abstract void sing();

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            return obj != null && getClass() == obj.getClass();
        }

        @Override
        public int hashCode() {
            return this.getClass().hashCode();
        }

        @Override
        public String toString() {
            return "Птичка: " + this.getClass().getSimpleName();
        }
    }



