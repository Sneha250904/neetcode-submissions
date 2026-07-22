class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Bucket: index = frequency
        List<Integer>[] bucket = new List[nums.length + 1];

        // Store frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(
                n,
                frequencyMap.getOrDefault(n, 0) + 1
            );
        }

        // Put numbers into their frequency bucket
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        // Traverse from highest frequency to lowest
        for (int pos = bucket.length - 1;
             pos >= 0 && counter < k;
             pos--) {

            if (bucket[pos] != null) {

                for (Integer integer : bucket[pos]) {
                    res[counter++] = integer;

                    if (counter == k) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
