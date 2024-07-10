function canJump(nums: number[]): number {
    let left = 0;
    let right = 0;
    let result = 0;
    let maximumReachedIndex = 0;

    while (right < nums.length - 1) {
        for (let i = left; i < right + 1; i++) {
            maximumReachedIndex = Math.max(maximumReachedIndex, i + nums[i])
        }
        result++;
        left = right + 1;
        right = maximumReachedIndex;
    }

    return result;
}

console.log(([1, 1, 1, 1, 1]));


(function e(){
    console.log(x);
    var x =10;
    console.log(x);
})();
