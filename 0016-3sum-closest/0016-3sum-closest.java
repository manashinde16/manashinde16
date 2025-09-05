class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use two-pointer technique
        Arrays.sort(nums); // Sort the array
        
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum with the first three elements
        
        // Iterate through the array, fixing one element at a time
        for (int i = 0; i < nums.length - 2; i++) { // Loop through each element except the last two
            int left = i + 1; // Set left pointer
            int right = nums.length - 1; // Set right pointer
            
            // Use two pointers to find the best pair for current i
            while (left < right) { // While left pointer is less than right pointer
                int currentSum = nums[i] + nums[left] + nums[right]; // Calculate current sum
                
                // If this sum is closer to target, update closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) { // Check if current sum is closer
                    closestSum = currentSum; // Update closest sum
                }
                
                // Move pointers based on comparison with target
                if (currentSum < target) { // If current sum is less than target
                    left++; // Move left pointer to the right
                } else if (currentSum > target) { // If current sum is greater than target
                    right--; // Move right pointer to the left
                } else { // If current sum equals target
                    return currentSum; // Return immediately as it's the closest possible
                }
            }
        }
        return closestSum; // Return the closest sum found
    }
}