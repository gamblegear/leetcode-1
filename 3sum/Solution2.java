public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    if (num.length < 3)
        return new ArrayList<ArrayList<Integer>>();

    Arrays.sort(num);
    HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
    for (int i=0; i < num.length; i++)
    {
        int target = 0 - num[i];

        int low = i+1;
        int high = num.length - 1;
        while (low < high)
        {
            int twosum = num[low] + num[high];
            if (twosum < target)
                low++;
            else if (twosum > target)
                high--;
            else
            {
                ArrayList<Integer> triplet = new ArrayList<Integer>();
                triplet.add(num[i]);
                triplet.add(num[low]);
                triplet.add(num[high]);

                res.add(triplet);

                low++;
                high--;
            }
        }
    }
    return new ArrayList<ArrayList<Integer>>(res);
}    