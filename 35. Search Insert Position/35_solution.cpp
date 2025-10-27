// 1
int searchInsert(int* nums, int numsSize, int target) {
    int i;
    for ( i = 0; i<numsSize ; i++){
         if (target == nums[i]) {
            return i;
         }
         else if (target < nums[i]){
            return i;
         }
    }
    return i;
}
// 1. yazdığım kod zaman karmaşıklığı açısından (O(n)) LeetCode sorusu O(log n) istiyor.

// 2 Zaman karmaşıklığı › O(log n)
int searchInsert(int* nums, int numsSize, int target) {

    int left = 0;
    int right = numsSize-1;

    while(left <=right)
    {
        int mid = (left + right) / 2;

        if (target == nums[mid]){
            return mid;
        }

        else if (target > nums[mid]){
            left = mid+1;
        }

        else { //target < nums[mid]
            right = mid -1;
        }
    }

    return left;
}

