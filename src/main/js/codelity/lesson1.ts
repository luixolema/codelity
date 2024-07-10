function binaryGap(N: number) {
  let binaryString = N.toString(2);
  let maxGap = 0;
  let gapStarted = false;
  let gapEnded = false;

  let gap = 0;

  for (const stringNumber of binaryString) {
    if (+stringNumber === 1) {
      if (gapStarted) {
        gapEnded = true;
      }

      if (gapEnded) {
        if (gap > maxGap) {
          maxGap = gap;
        }
        gapEnded = false
        gap = 0;
      }
      gapStarted = true;
    } else if (gapStarted) {
      gap++;
    }
  }
  return maxGap;
}