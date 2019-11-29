package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateNumber287 {

    @Test
    public void canFindDuplicate(){
        assertEquals(4, findDuplicate(new int[]{1,2,3,4,4}));
        assertEquals(1, findDuplicate(new int[]{1,1,1,4,3}));

    }

    public int findDuplicate(int[] nums) {
        int slowRunner = nums[0];
        int fastRunner = nums[nums[0]];

        while (slowRunner != fastRunner){
            slowRunner = nums[slowRunner];
            fastRunner = nums[nums[fastRunner]];
        }

        int head = 0;
        while(nums[head] != nums[slowRunner]){
            head = nums[head];
            slowRunner = nums[slowRunner];
        }

        return nums[head];
    }

}
