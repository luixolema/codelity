function OddOccurrencesInArray(A: number[]) {
  const occurrences:{[key: number]: number} = {};

  A.forEach(e => {
    if (occurrences[e] !== undefined) {
      delete occurrences[e];
    }else{
      occurrences[e] = e;
    }
  })

  return Object.keys(occurrences)[0];
}

console.log(OddOccurrencesInArray([9,5,9,4,4,3,2,2,5,6,7,7,6]))