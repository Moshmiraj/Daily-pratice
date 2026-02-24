import java.util.*;

class State {
    int x, y;

    State(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Jug{

    static int jug1 = 4;
    static int jug2 = 3;
    static int target = 2;

    public static void solve() {

        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new State(0, 0));

        while (!q.isEmpty()) {

            State curr = q.poll();

            if (curr.x == target || curr.y == target) {
                System.out.println("Target reached: (" + curr.x + ", " + curr.y + ")");
                return;
            }

            String key = curr.x + "," + curr.y;

            if (visited.contains(key))
                continue;

            visited.add(key);

            // Fill Jug1
            q.add(new State(jug1, curr.y));

            // Fill Jug2
            q.add(new State(curr.x, jug2));

            // Empty Jug1
            q.add(new State(0, curr.y));

            // Empty Jug2
            q.add(new State(curr.x, 0));

            // Pour Jug1 → Jug2
            int pour = Math.min(curr.x, jug2 - curr.y);
            q.add(new State(curr.x - pour, curr.y + pour));

            // Pour Jug2 → Jug1
            pour = Math.min(curr.y, jug1 - curr.x);
            q.add(new State(curr.x + pour, curr.y - pour));
        }

        System.out.println("No solution found");
    }

    public static void main(String[] args) {
        solve();
    }
}