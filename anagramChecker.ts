const letterCounts = (word: string): Record<string, number> => {
  const trimmedWord = word.trim().split("");
  let counts: Record<string, number> = {};

  for (const letter of trimmedWord) {
    counts[letter] = (counts[letter] || 0) + 1;
  }

  return counts;
};

const checkAnagram = (word: string, wordToCheck: string): boolean => {
  if (word.length !== wordToCheck.length) return false;

  const firstWordCounts = letterCounts(word);
  const secondWordCounts = letterCounts(wordToCheck);

  for (const letter in firstWordCounts) {
    if (
      !secondWordCounts.hasOwnProperty(letter) ||
      firstWordCounts[letter] !== secondWordCounts[letter]
    ) {
      return false;
    }
  }

  return true;
};

console.log(checkAnagram("word", "dowr")); 
