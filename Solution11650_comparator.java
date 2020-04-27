import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Solution11650_comparator {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        Location[] locations = new Location[n];
        String[] line = new String[2];

        for (int i = 0; i < locations.length; i++) {
            line = bufferedReader.readLine().split(" ");
            locations[i] = new Location(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        bufferedReader.close();
        Arrays.sort(locations, new Comparator<Location>() {

            @Override
            public int compare(Location o1, Location o2) {
                if (o1.x == o2.x) {
                    return Integer.compare(o1.y, o2.y);
                }
                return Integer.compare(o1.x, o2.x);
            }
        });

        for (int i = 0; i < locations.length; i++) {
            bufferedWriter.write(locations[i].x + " " + locations[i].y + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
