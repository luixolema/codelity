function canJump(nums: number[]): boolean {
    if (nums.length === 1){
        return true;
    }

    let reserves = nums[0];
    for (let i = 1; i < nums.length - 1; i++) {
        if (reserves === 0){
            break;
        }
        reserves--;
        if (reserves < nums[i]){
            reserves = nums[i];
        }
    }

    return reserves > 0
}

console.log(canJump([0]));