class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] lcandies = new int[ratings.length];
        int[] rcandies = new int[ratings.length];
        lcandies[0] = (ratings[0] > ratings[1]) ? 2 : 1;
        rcandies[ratings.length - 1] = (ratings[ratings.length-1] > ratings[ratings.length-2]) ? 2 : 1;

        for (int l = 1; l < ratings.length; l++) {
            if (ratings[l] > ratings[l-1]) {
                lcandies[l] = lcandies[l-1] + 1;
            } else {
                lcandies[l] = 1;
            }
        }

        int result = Math.max(lcandies[ratings.length - 1], rcandies[ratings.length-1]);
        for (int r = ratings.length - 2; r>=0; r--) {
            if (ratings[r] > ratings[r+1]) {
                rcandies[r] = rcandies[r+1] + 1;
            } else {
                rcandies[r] = 1;
            }
            result += Math.max(lcandies[r], rcandies[r]);
        }
        return result;
    }
}