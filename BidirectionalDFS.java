import java.util.*;

class BidirectionalDFS {

    static boolean bidirDFS(Map<Integer, List<Integer>> g,
                            int s, int t,
                            Set<Integer> v1, Set<Integer> v2) {

        if (v2.contains(s)) return true;
        v1.add(s);

        for (int n : g.getOrDefault(s, new ArrayList<>())) {
            if (!v1.contains(n))
                if (bidirDFS(g, n, t, v1, v2)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        g.put(0, Arrays.asList(1, 2));
        g.put(1, Arrays.asList(0, 3));
        g.put(2, Arrays.asList(0, 3));
        g.put(3, Arrays.asList(1, 2));

        Set<Integer> v1 = new HashSet<>();
        Set<Integer> v2 = new HashSet<>();

        boolean found =
            bidirDFS(g, 0, 3, v1, v2) ||
            bidirDFS(g, 3, 0, v2, v1);

        System.out.println(found);
    }
}
