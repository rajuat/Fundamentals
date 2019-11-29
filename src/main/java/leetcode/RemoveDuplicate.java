package leetcode;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0};
        int count = new RemoveDuplicate().removeDuplicates(nums);
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length - 1 - counter; i++) {
            while (nums[i] == nums[i + 1] && i < nums.length - 1 - counter) {
                counter++;
                for (int j = i + 1; j < nums.length - counter; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
        return nums.length - counter;
    }

}
