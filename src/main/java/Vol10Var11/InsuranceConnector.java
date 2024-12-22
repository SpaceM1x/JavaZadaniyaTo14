package Vol10Var11;

import java.io.*;
import java.util.Comparator;
import java.util.List;

public class InsuranceConnector {
    private final String filePath;

    public InsuranceConnector(String filePath) {
        this.filePath = filePath;
    }

    public void saveInsurance(List<Insurance> insurances) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(insurances);
        }
    }

    public List<Insurance> loadInsurance() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Insurance>) ois.readObject();
        }
    }

    public List<Insurance> filterByRisk(List<Insurance> insurances, int minRisk, int maxRisk) {
        return insurances.stream()
                .filter(insurance -> insurance.getRisk() >= minRisk && insurance.getRisk() <= maxRisk)
                .toList();
    }

    public List<Insurance> sortByRisk(List<Insurance> insurances) {
        return insurances.stream()
                .sorted(Comparator.comparingInt(Insurance::getRisk).reversed())
                .toList();
    }
}
