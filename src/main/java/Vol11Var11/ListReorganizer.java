package Vol11Var11;

import java.util.List;

public class ListReorganizer {
    public static void reorganize(List<Integer> list) {
        int i = 0;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) >= 0) {
                if (i != j) {

                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
                i++;
            }
        }
    }
}
