function hIndex(citations: number[]): number {
    citations.sort((a,b)=> b-a);
    let result = 0;
    let citedArticles = 0;
    for (let i = 0; i < citations.length; i++) {
        const citation = citations[i];
        citedArticles++;

        if (citation < citedArticles){
            break;
        }

        result = citedArticles;
    }

    return result;
}


console.log(hIndex([3,0,6,1,5]));
