function rotate(nums: number[], k: number): void {
    if (nums.length <  k && nums.length % k === 0) {
        return;
    }


    k = k > nums.length ? k % nums.length : k;
    let firstHalf = nums.splice(nums.length - k, k);
    nums.splice(0,0, ...firstHalf);
}

let nums = [-1,-100,3,99];
rotate(nums, 2);
console.log(nums);