package interviews.Houzz;

import java.util.*;

public class TripArrangement {

    static class StationEntry {
        String station;
        int departing;
        int arriving;
        StationEntry(String station, int departing, int arriving) {
            this.station = station;
            this.departing = departing;
            this.arriving = arriving;
        }
    }

    List<String> findPath(List<String> table, String src, String dst) {
        Map<String, List<StationEntry>> map = getMap(table);
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(src);
        dfs(map, src, 0, path, result, new int[1], dst);
        return result.isEmpty() ? new ArrayList<>() : result.get(result.size() - 1);
    }

    private Map<String, List<StationEntry>> getMap(List<String> table) {
        Map<String, List<StationEntry>> map = new HashMap<>();
        for (String entry : table) {
            String[] infos = entry.split("\\s+");
            if (!map.containsKey(infos[0])) {
                map.put(infos[0], new ArrayList<>());
            }
            map.get(infos[0]).add(new StationEntry(infos[1], Integer.parseInt(infos[2]), Integer.parseInt(infos[3])));
        }
        return map;
    }

    private void dfs(Map<String, List<StationEntry>> map, String curStation, int curTime,
                     List<String> path, List<List<String>> result, int[] time, String dst) {
        if (curStation.equals(dst)) {
            if (result.isEmpty() || time[0] > curTime) {
                result.add(new ArrayList<>(path));
                time[0] = curTime;
            }
            return;
        }
        for (StationEntry nextHop : map.get(curStation)) {
            if (nextHop.departing >= curTime) {
                path.add(nextHop.station);
                dfs(map, nextHop.station, nextHop.arriving, path, result, time, dst);
                path.remove(path.size() - 1);
            }
        }
    }

}
