class TimeMap {

    private static class Entry{
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Entry>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        int left = 0;
        List<Entry> list = map.get(key);
        int right = list.size();

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp > timestamp) right = mid;
            else left = mid+1;
        }
        if (left == 0) return "";
        return list.get(left-1).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
