package Vol14Var11;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class IpScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальный IP-адрес (например, 192.168.1.1):");
        String startIp = scanner.nextLine();

        System.out.println("Введите конечный IP-адрес (например, 192.168.1.255):");
        String endIp = scanner.nextLine();

        System.out.println("Сканирование сети...\n");

        try {
            scanNetwork(startIp, endIp);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void scanNetwork(String startIp, String endIp) throws Exception {
        long start = ipToLong(startIp);
        long end = ipToLong(endIp);

        if (start > end) {
            throw new IllegalArgumentException("Начальный IP-адрес должен быть меньше или равен конечному.");
        }

        for (long i = start; i <= end; i++) {
            String currentIp = longToIp(i);
            if (isHostReachable(currentIp)) {
                System.out.println("Активный хост найден: " + currentIp);
            } else {
                System.out.println("Хост неактивен: " + currentIp);
            }
        }
    }

    private static boolean isHostReachable(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            return address.isReachable(1000);
        } catch (IOException e) {
            return false;
        }
    }

    private static long ipToLong(String ipAddress) throws Exception {
        String[] octets = ipAddress.split("\\.");
        if (octets.length != 4) {
            throw new IllegalArgumentException("Некорректный формат IP-адреса: " + ipAddress);
        }

        long result = 0;
        for (String octet : octets) {
            int value = Integer.parseInt(octet);
            if (value < 0 || value > 255) {
                throw new IllegalArgumentException("Некорректное значение в IP-адресе: " + value);
            }
            result = (result << 8) + value;
        }
        return result;
    }

    private static String longToIp(long ip) {
        return ((ip >> 24) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                (ip & 0xFF);
    }
}
