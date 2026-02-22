class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        qsort(arr, 0, arr.length - 1);

        if(arr[0].equals("0"))
            return "0";

        StringBuilder res = new StringBuilder();
        for(String s : arr)
            res.append(s);

        return res.toString();
    }

    public void qsort(String[] arr, int lb, int ub){
        if(lb < ub){
            int part = partition(arr, lb, ub);
            qsort(arr, lb, part - 1);
            qsort(arr, part + 1, ub);
        }
    }

    public int partition(String[] arr, int lb, int ub){
        String pivot = arr[lb];
        int st = lb;
        int en = ub;

        while(st < en){

            while(st <= ub && compare(arr[st], pivot) >= 0)
                st++;

            while(en >= lb && compare(arr[en], pivot) < 0)
                en--;

            if(st < en)
                swap(arr, st, en);
        }

        swap(arr, lb, en);
        return en;
    }

    // Custom comparator logic
    public int compare(String a, String b){
        String ab = a + b;
        String ba = b + a;
        return ab.compareTo(ba);
    }

    public void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}